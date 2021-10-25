package com.example.happy_tummy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;

import com.example.happy_tummy.Ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class CartAdapter extends BaseAdapter {
    Context context;
    List<Sandwich> sandwichList;
    LayoutInflater inflater;
    int totalPrice = 0;

    public CartAdapter(Context context, List<Sandwich> sandwichList) {
        this.context = context;
        this.sandwichList = sandwichList;
    }

    @Override
    public int getCount() {
        return sandwichList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View sandwichView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (sandwichView == null){
            sandwichView = inflater.inflate(R.layout.activity_cart_item,null);
        }
        Button add = sandwichView.findViewById(R.id.sandwich_add);
        Button remove = sandwichView.findViewById(R.id.sandwich_remove);
        Button deleteSandwich = sandwichView.findViewById(R.id.delete_sandwich);
        Button changeSandwich = sandwichView.findViewById(R.id.change_sandwich);
        TextView sandwichQuantityText = sandwichView.findViewById(R.id.sandwich_quantity);
        TextView sandwichPriceText = sandwichView.findViewById(R.id.sandwich_price);
        EditText sandwichName = sandwichView.findViewById(R.id.sandwich_name);
        ListView sandwichItemPreview = sandwichView.findViewById(R.id.sandwich_item_preview);

        if(sandwichList.get(position).name.equals("") || sandwichList.get(position).name.equals("Sandwich "+(position+1))){
            sandwichList.get(position).name = "Sandwich "+(position+1);
        }

        sandwichName.setText(sandwichList.get(position).name);
        List<Ingredient> ingredientList = new ArrayList<>();

        ingredientList.add(sandwichList.get(position).bread);
        ingredientList.addAll(sandwichList.get(position).sauces);
        ingredientList.addAll(sandwichList.get(position).veggies);
        ingredientList.addAll(sandwichList.get(position).addOns);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sandwichList.get(position).quantity<=50) sandwichList.get(position).quantity++;
                sandwichQuantityText.setText(Integer.toString(sandwichList.get(position).quantity));
                sandwichPriceText.setText(Integer.toString(sandwichList.get(position).price * sandwichList.get(position).quantity));
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sandwichList.get(position).quantity>1) sandwichList.get(position).quantity--;
                sandwichQuantityText.setText(Integer.toString(sandwichList.get(position).quantity));
                sandwichPriceText.setText(Integer.toString(sandwichList.get(position).price * sandwichList.get(position).quantity));
            }
        });

        deleteSandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sandwichList.remove(sandwichList.get(position))){
                    Toast.makeText(context,"Successfully Deleted The Sandwich",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context,CartActivity.class);
                    context.startActivity(intent);
                }else{
                    Toast.makeText(context,"An Error Occurred While Deleting the Sandwich",Toast.LENGTH_SHORT).show();
                }
            }
        });

        changeSandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home.passSandwich = sandwichList.get(position);
                Intent intent = new Intent(context,BreadSelection.class);
                context.startActivity(intent);
            }
        });


        sandwichPriceText.setText(Integer.toString(sandwichList.get(position).price * sandwichList.get(position).quantity));
        SandwichListAdapter sandwichListAdapter = new SandwichListAdapter(sandwichView.getContext(), ingredientList);
        sandwichItemPreview.setAdapter(sandwichListAdapter);

        sandwichQuantityText.setText(Integer.toString(sandwichList.get(position).quantity));

        return sandwichView;
    }
}
