package com.example.happy_tummy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.happy_tummy.Ingredients.AddOn;
import com.example.happy_tummy.Ingredients.Bread;
import com.example.happy_tummy.Ingredients.Ingredient;
import com.example.happy_tummy.Ingredients.Sauce;
import com.example.happy_tummy.Ingredients.Veggie;
import com.squareup.picasso.Picasso;
import java.util.List;

public class GridAdapter extends BaseAdapter{

    Context context;
    List<Ingredient> IngredientList;
    Sandwich sandwich;
    String ingredientType;

    LayoutInflater inflater;

    public GridAdapter(Context context, List<Ingredient> IngredientList,Sandwich sandwich,String ingredientType) {
        this.context = context;
        this.IngredientList = IngredientList;
        this.sandwich = sandwich;
        this.ingredientType = ingredientType;
    }

    @Override
    public int getCount() {
        return IngredientList.size();
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
            convertView = inflater.inflate(R.layout.grid_item,null);
        }
        Button add = convertView.findViewById(R.id.item_add);
        Button remove = convertView.findViewById(R.id.item_remove);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ingredientType.toLowerCase().equals("bread")){
                    sandwich.bread = (Bread) IngredientList.get(position);
                    Log.d("Item Added",IngredientList.get(position).getName());
                }else if(ingredientType.toLowerCase().equals("sauce") && !sandwich.sauces.contains((Sauce) IngredientList.get(position))){
                    sandwich.sauces.add((Sauce) IngredientList.get(position));
                    Log.d("Item Added",IngredientList.get(position).getName());
                }
                else if(ingredientType.toLowerCase().equals("addon") && !sandwich.addOns.contains((AddOn) IngredientList.get(position))){
                    sandwich.addOns.add((AddOn) IngredientList.get(position));
                    Log.d("Item Added",IngredientList.get(position).getName());
                }
                else if(ingredientType.toLowerCase().equals("veggie") && !sandwich.veggies.contains((Veggie) IngredientList.get(position))){
                    sandwich.veggies.add((Veggie) IngredientList.get(position));
                    Log.d("Item Added",IngredientList.get(position).getName());
                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ingredientType.toLowerCase().equals("bread")){
                    Toast.makeText(context,"You cannot remove bread select another one if you want to get another bread",Toast.LENGTH_LONG).show();
                }else if(ingredientType.toLowerCase().equals("sauce")){
                    if(sandwich.sauces.contains((Sauce) IngredientList.get(position))){
                        sandwich.sauces.remove(((Sauce) IngredientList.get(position)));
                    }else{
                        Toast.makeText(context,"This sauce was never selected",Toast.LENGTH_LONG).show();
                    }
                }
                else if(ingredientType.toLowerCase().equals("addon")){
                    if(sandwich.addOns.contains((AddOn) IngredientList.get(position))){
                        sandwich.addOns.remove((AddOn) IngredientList.get(position));
                    }else{
                        Toast.makeText(context,"This addOn was never selected",Toast.LENGTH_LONG).show();
                    }
                }
                else if(ingredientType.toLowerCase().equals("veggie")){
                    if(sandwich.veggies.contains((Veggie) IngredientList.get(position))){
                        sandwich.veggies.remove((Veggie) IngredientList.get(position));
                    }else{
                        Toast.makeText(context,"This Veggie was never selected",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


        Log.d("This is Grid","We are not able to navigate");
        ImageView ingredientImage = convertView.findViewById(R.id.item_image);
        TextView ingredientName =  convertView.findViewById(R.id.item_name);
        TextView ingredientPrice = convertView.findViewById(R.id.grid_item_price);
        Log.d("the path is",IngredientList.get(position).getImage());
        Picasso.with(context).load(IngredientList.get(position).getImage()).into(ingredientImage);
        ingredientName.setText(IngredientList.get(position).getName());
        ingredientPrice.setText(Integer.toString(IngredientList.get(position).getPrice()));

        return convertView;
    }
}


