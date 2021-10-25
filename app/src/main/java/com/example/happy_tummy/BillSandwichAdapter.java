package com.example.happy_tummy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LongDef;

import com.example.happy_tummy.Ingredients.Ingredient;
import com.example.happy_tummy.R;
import com.example.happy_tummy.Sandwich;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class BillSandwichAdapter extends BaseAdapter {
    List<Sandwich> sandwichList;
    Context context;
    LayoutInflater inflater;
    
    BillSandwichAdapter(Context context, List<Sandwich> sandwichList){
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        if (convertView == null){
            convertView = inflater.inflate(R.layout.activity_bill_item_card,null);
        }

        TextView sandwichName = convertView.findViewById(R.id.bill_sandwich_name);
        TextView sandwichPrice = convertView.findViewById(R.id.bill_sandwich_price);
        TextView sandwichQuantity = convertView.findViewById(R.id.bill_sandwich_quantity);
        TextView sandwichAmount = convertView.findViewById(R.id.bill_sandwich_amount);
        ExpandableTextView sandwichDetails = convertView.findViewById(R.id.bill_sandwich_details);
        Log.d("Sandwich Name",sandwichList.get(position).name);

        sandwichName.setText(sandwichList.get(position).name);
        sandwichAmount.setText("Rs."+Integer.toString(sandwichList.get(position).quantity*sandwichList.get(position).price));
        sandwichQuantity.setText(Integer.toString(sandwichList.get(position).quantity));
        sandwichPrice.setText("Rs."+Integer.toString(sandwichList.get(position).price));
        StringBuilder details = new StringBuilder();
        details.append(sandwichList.get(position).bread.getName()+"\t\t\t\t\t"+sandwichList.get(position).bread.getPrice());
        details.append("\n");
        for(Ingredient ingredient : sandwichList.get(position).sauces){
            details.append(ingredient.getName()+"\t\t\t\t\t"+ingredient.getPrice());
            details.append("\n");
        }
        for(Ingredient ingredient : sandwichList.get(position).veggies){
            details.append(ingredient.getName()+"\t\t\t\t\t"+ingredient.getPrice());
            details.append("\n");
        }
        for(Ingredient ingredient : sandwichList.get(position).addOns){
            details.append(ingredient.getName()+"\t\t\t\t\t"+ingredient.getPrice());
            details.append("\n");
        }
        sandwichDetails.setText(new String(details));
        return convertView;
    }
}
