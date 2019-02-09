package com.shariq.service_lafusion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryDetail extends AppCompatActivity {
 private TextView tvcategory;
 private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        tvcategory=(TextView)findViewById(R.id.tvcategoryName);
        imageView=(ImageView)findViewById(R.id.ivCategoryImage);
        int imageid=getIntent().getIntExtra("pics",1);
        imageView.setImageResource(imageid);
        String cname=getIntent().getStringExtra("Carpenter");
        Log.d("here","is :"+cname);
        tvcategory.setText(cname);
    }
}
