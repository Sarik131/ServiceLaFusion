package com.shariq.service_lafusion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class QueryStatusActivity extends AppCompatActivity {
    TextView tvDesc;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_status);
        tvDesc=(TextView)findViewById(R.id.tvQsDesc);
        imageView=(ImageView)findViewById(R.id.ivQsPhoto1);

        String descStr=getIntent().getStringExtra("WriteHere");
        tvDesc.setText(descStr);

        int img=getIntent().getIntExtra("Image",1);
        imageView.setImageResource(img);
    }
}
