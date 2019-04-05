package com.shariq.service_lafusion;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.shariq.service_lafusion.adapter.SPAdapter1;
import com.shariq.service_lafusion.adapter.ServiceProviderAdapter;
import com.shariq.service_lafusion.adapter.SpAdapter;
import com.shariq.service_lafusion.model.DummySpData;

import java.util.ArrayList;
import java.util.List;

public class ServiceProvider extends AppCompatActivity {
    private ArrayList<DummySpData> modelList=new ArrayList<>();
    private RecyclerView recyclerView;
    private SPAdapter1 adapter;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider);
        init();
    }

    private void init() {

        modelList.add(new DummySpData("For Repairing AC at my home"));
        modelList.add(new DummySpData("pest control at my office"));
        modelList.add(new DummySpData("Planning a birthday party event"));
        modelList.add(new DummySpData("Want to make furniture for my new house"));
        initRecyclerView();

    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.spRecyclerView);

        Log.d("Data", "modelList :" + modelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SPAdapter1(modelList, this);
        Log.d("Data","BEfore rv");
        recyclerView.setAdapter(adapter);
        Log.d("Data","after rv");
    }


}
