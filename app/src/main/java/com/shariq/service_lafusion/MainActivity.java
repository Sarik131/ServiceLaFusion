package com.shariq.service_lafusion;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

//implements HomeAdapter.ItemClickListener
public class MainActivity extends AppCompatActivity  {
//    HomeAdapter adapter;
//    private ArrayList<Category> data;

    Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);


        //startActivity(new Intent(MainActivity.this, ARactivity.class));
//        // data to populate the RecyclerView with
//       // String[] data = {"@string/plumbing", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances"};
//        ArrayList<Category> data = new ArrayList<>();
//        data.add(new Category(R.drawable.plumbing, getString(R.string.plumbing)));
//        data.add(new Category(R.drawable.appliances, getString(R.string.appliances)));
//        data.add(new Category(R.drawable.cleaninglady, getString(R.string.Cleaning)));
//        data.add(new Category(R.drawable.elecrical, getString(R.string.Elec)));
//        data.add(new Category(R.drawable.carpenter, getString(R.string.Carpentry)));
//        data.add(new Category(R.drawable.car, getString(R.string.Vehicle)));
//        data.add(new Category(R.drawable.painter, getString(R.string.Painting)));
//        data.add(new Category(R.drawable.homesecurity, getString(R.string.home)));
//        data.add(new Category(R.drawable.pest, getString(R.string.pest)));
//        data.add(new Category(R.drawable.plumbing, getString(R.string.plumbing)));
//        data.add(new Category(R.drawable.appliances, getString(R.string.appliances)));
//        data.add(new Category(R.drawable.cleaninglady, getString(R.string.Cleaning)));
//        data.add(new Category(R.drawable.elecrical, getString(R.string.Elec)));
//        data.add(new Category(R.drawable.carpenter, getString(R.string.Carpentry)));
//        data.add(new Category(R.drawable.car, getString(R.string.Vehicle)));
//        data.add(new Category(R.drawable.painter, getString(R.string.Painting)));
//        data.add(new Category(R.drawable.homesecurity, getString(R.string.home)));
//        data.add(new Category(R.drawable.pest, getString(R.string.pest)));
//
//
//        // set up the RecyclerView
//        RecyclerView recyclerView = findViewById(R.id.rvTypes);
//        int numberOfColumns = 3;
//        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
//        adapter = new HomeAdapter(this, data, this);
//        recyclerView.setAdapter(adapter);
    }

   /* public void onclick(View view)
    {
        ImageView ivWelcomme = (ImageView) findViewById(R.id.ivWelcome);
        ivWelcomme.animate().alpha(0f).setDuration(1000);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }*/
//    @Override
//    public void onItemClick(int position) {
//        Log.i("TAG", "You clicked number , which is at cell position " + position);
//    }

}

