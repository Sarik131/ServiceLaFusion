package com.shariq.service_lafusion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shariq.service_lafusion.adapter.SpListAdapter;
import com.shariq.service_lafusion.model.SpList;

import java.util.ArrayList;

public class SpListActivity extends AppCompatActivity {
    SpListAdapter adapter;
    private ArrayList<SpList> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_list);


        ArrayList<SpList> data = new ArrayList<>();
        data.add(new SpList(R.drawable.plumbing, getString(R.string.plumbing),5));
        data.add(new SpList(R.drawable.appliances, getString(R.string.appliances),4));
        data.add(new SpList(R.drawable.appliances, getString(R.string.appliances),3));


        RecyclerView spList = findViewById(R.id.rvSpList);

        spList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SpListAdapter(this, data);
        spList.setAdapter(adapter);
    }
}
