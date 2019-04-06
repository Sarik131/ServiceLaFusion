package com.shariq.service_lafusion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class QueryStatusActivity extends AppCompatActivity {
    TextView tvDesc;
    ImageView imageView;
    EditText edtReply,edtAmount;
    Button submit;
    String title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_status);
        tvDesc=(TextView)findViewById(R.id.tvQsDesc);
        imageView=(ImageView)findViewById(R.id.ivQsPhoto1);
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        edtReply=(EditText)findViewById(R.id.edtQsReply);
        edtAmount=(EditText)findViewById(R.id.edtQsAmount);
        submit=(Button)findViewById(R.id.btnSpSubmit);

        Bundle bundle=getIntent().getExtras();
        String check= bundle.getString("check");

        if(check == "visible"){
            edtAmount.setVisibility(View.VISIBLE);
            edtReply.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QueryStatusActivity.this, "Request Send.", Toast.LENGTH_SHORT).show();
            }
        });

        String descStr=getIntent().getStringExtra("WriteHere");
        tvDesc.setText(descStr);

        int img=getIntent().getIntExtra("Image",1);
        imageView.setImageResource(img);

    }
}
