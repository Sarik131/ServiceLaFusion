package com.shariq.service_lafusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.shariq.service_lafusion.adapter.HomeAdapter;
import com.shariq.service_lafusion.model.Category;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements HomeAdapter.ItemClickListener {
    HomeAdapter adapter;
    private ArrayList<Category> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //http servlet request
        //
        // This is test comment
        //startActivity(new Intent(MainActivity.this, ARactivity.class));
//        // data to populate the RecyclerView with
//       // String[] data = {"@string/plumbing", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances", "@string/appliances"};
        ArrayList<Category> data = new ArrayList<>();
        data.add(new Category(R.drawable.plumbing, getString(R.string.plumbing)));
        data.add(new Category(R.drawable.appliances, getString(R.string.appliances)));
        data.add(new Category(R.drawable.cleaninglady, getString(R.string.Cleaning)));
        data.add(new Category(R.drawable.elecrical, getString(R.string.Elec)));
        data.add(new Category(R.drawable.carpenter, getString(R.string.Carpentry)));
        data.add(new Category(R.drawable.car, getString(R.string.Vehicle)));
        data.add(new Category(R.drawable.painter, getString(R.string.Painting)));
        data.add(new Category(R.drawable.homesecurity, getString(R.string.home)));
        data.add(new Category(R.drawable.pest, getString(R.string.pest)));
        data.add(new Category(R.drawable.plumbing, getString(R.string.plumbing)));
        data.add(new Category(R.drawable.appliances, getString(R.string.appliances)));
        data.add(new Category(R.drawable.cleaninglady, getString(R.string.Cleaning)));
        data.add(new Category(R.drawable.elecrical, getString(R.string.Elec)));
        data.add(new Category(R.drawable.carpenter, getString(R.string.Carpentry)));
        data.add(new Category(R.drawable.car, getString(R.string.Vehicle)));
        data.add(new Category(R.drawable.painter, getString(R.string.Painting)));
        data.add(new Category(R.drawable.homesecurity, getString(R.string.home)));
        data.add(new Category(R.drawable.pest, getString(R.string.pest)));


        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvTypes);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new HomeAdapter(this, data, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(int position) {
        Log.i("TAG", "You clicked number , which is at cell position " + position);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this, QueryScreenActivity.class);
        startActivity(intent);
    }

}