package com.example.happy_tummy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.happy_tummy.Ingredients.Ingredient;

import java.util.List;

public class SandwichListAdapter extends BaseAdapter {

    Context context;
    List<Ingredient> ingredientList;
    LayoutInflater inflater;

    public SandwichListAdapter(Context context, List<Ingredient> ingredientList){
        this.context = context;
        this.ingredientList = ingredientList;

    }
    @Override
    public int getCount() {
        return ingredientList.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null){
            view = inflater.inflate(R.layout.activity_sandwich_list,null);
        }

        TextView itemName = view.findViewById(R.id.sandwich_item_name);
        TextView itemPrice = view.findViewById(R.id.sandwich_item_price);

        itemName.setText(ingredientList.get(position).getName());
        itemPrice.setText(Integer.toString(ingredientList.get(position).getPrice()));

        return view;
    }
}
