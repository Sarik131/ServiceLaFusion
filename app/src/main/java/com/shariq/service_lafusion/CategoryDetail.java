package com.shariq.service_lafusion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.shariq.service_lafusion.adapter.SpAdapter;

public class CategoryDetail extends AppCompatActivity {
 private TextView tvcategory,tvdesc;
 private ImageView imageView;
    SpAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);

        tvcategory=(TextView)findViewById(R.id.tvcategoryName);

        String cname=getIntent().getStringExtra("Carpenter");
        tvcategory.setText(cname);

//initialization
        recyclerView = (RecyclerView) findViewById(R.id.spListRecyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new SpAdapter();
        recyclerView.setAdapter(adapter);

/*
<<<<<<< Updated upstream
=======
        String desc=getIntent().getStringExtra("desc");
        tvdesc.setText(desc);

        Intent intent=new Intent();
        intent.putExtra("category",cname);
>>>>>>> Stashed changes
    */}
}
