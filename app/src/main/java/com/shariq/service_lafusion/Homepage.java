package com.shariq.service_lafusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import com.shariq.service_lafusion.adapter.GridAdapter;
import com.shariq.service_lafusion.model.Category;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    public GridView gridView;
    GridAdapter gridAdapter;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ArrayList<Category> data = new ArrayList<>();

 /*
    String[] vlaues = {
            "Carpenter",
            "Painter",
            "Cleaning",
            "Applicances",
            "Electrician",
            "Movers & Packers",
            "Photographer",
            "EventManagement ",
            "FitnessTrainer",
            "PestController",
            "BeautyParlour",
            "Gardener",
            "Astrologer",
            "Plumber"};
    int[] images = {
            R.drawable.iccarpenter,
            R.drawable.icpainter,
            R.drawable.iccleaning,
            R.drawable.icappliances,
            R.drawable.icelectricain,
            R.drawable.icpakers,
            R.drawable.icphotographer,
            R.drawable.icevents,
            R.drawable.icfitness,
            R.drawable.icpest,
            R.drawable.icparlour,
            R.drawable.icgardener,
            R.drawable.icastrologer,
            R.drawable.icplumber};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        data = new ArrayList<>();
        data.add(new Category(R.drawable.iccarpenter, "Carpenter"));
        data.add(new Category(R.drawable.icpainter, "Painter"));
        data.add(new Category(R.drawable.iccleaning, "Cleaning"));
        data.add(new Category(R.drawable.icappliances, "Applicances"));
        data.add(new Category(R.drawable.icelectricain, "Electrician"));
        data.add(new Category(R.drawable.icpakers, "Packers"));
        data.add(new Category(R.drawable.icphotographer, "Photographer"));
        data.add(new Category(R.drawable.icevents, "EventManagement "));
        data.add(new Category(R.drawable.icfitness, "FitnessTrainer"));
        data.add(new Category(R.drawable.icpest, "PestController"));
        data.add(new Category(R.drawable.icparlour, "BeautyParlour"));
        data.add(new Category(R.drawable.icgardener, "Gardener"));
        data.add(new Category(R.drawable.icastrologer, "Astrologer"));
        data.add(new Category(R.drawable.icplumber, "Plumber"));


        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);//toolbar
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // to add actionbar

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new SpaceItemDecoration(10));
        layoutManager = new GridLayoutManager(Homepage.this, 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        gridAdapter = new GridAdapter(this, data);
        recyclerView.setAdapter(gridAdapter);
    }

    public void createQuery(View view) {
        Intent intent = new Intent(Homepage.this, CreateQueryActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        MenuItem menuItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText == null || newText.isEmpty()) {
                    gridAdapter = new GridAdapter(Homepage.this, data);
                    recyclerView.setAdapter(gridAdapter);
                } else {
                    gridAdapter.getFilter().filter(newText);
                }

                return false;
            }
        });

        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
