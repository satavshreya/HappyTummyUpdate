package com.example.happy_tummy.Ingredients;

public class Veggie implements Ingredient {

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

    public Veggie(String name, String image, int price) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = 0;
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
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_veggies);
//        String[] itemname2 = {"Veggie Delight","Chatpata Chana","Corn & Peas","Mexican Patty"};
//        int[] images2={R.drawable.veggies,R.drawable.chatpatachana,R.drawable.cornpeas,R.drawable.mexicanpatty};
//        int[] prices2 = {200,300,400,200};
//        GridView gridView2 = findViewById(R.id.gridView2);
//        GridAdapter gridAdapter2 = new GridAdapter(Veggie.this,itemname2,images2,prices2);
//        gridView2.setAdapter(gridAdapter2);
//        Button addonbtn = findViewById(R.id.addonbtn);
//        addonbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent deals = new Intent(Veggie.this,AddOn.class);
//                startActivity(deals);
//            }
//        });
//
//    }
}