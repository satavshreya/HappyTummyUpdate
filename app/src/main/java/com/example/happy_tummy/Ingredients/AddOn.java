package com.example.happy_tummy.Ingredients;

import com.example.happy_tummy.CartDatabase;

public class AddOn implements Ingredient {

    String name;
    String image;
    int price;
    int quantity;
    boolean selected;

    @Override
    public void addToCart() {
        this.selected = true;
    }

    @Override
    public void removeFromCart() {
        this.selected = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public AddOn(String name, String image, int price) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = 0;
    }
    //
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_ons);
//        String[] itemname3 = {"Iced Tea","Lime Soda","Cold Coffee","Diet Can"};
//        int[] images3={R.drawable.icedtea,R.drawable.limesoda,R.drawable.coldcoffee,R.drawable.dietcan};
//        int[] prices3 = {100,150,299,199};
//        GridView gridView2 = findViewById(R.id.gridView3);
//        GridAdapter gridAdapter2 = new GridAdapter(AddOn.this,itemname3,images3,prices3);
//        gridView2.setAdapter(gridAdapter2);
//    }
}