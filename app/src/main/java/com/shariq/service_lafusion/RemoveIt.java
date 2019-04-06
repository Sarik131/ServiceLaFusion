package com.shariq.service_lafusion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RemoveIt extends AppCompatActivity {
    TextView txttitle, txtdesc;
    EditText Reply, Amount;
    ImageView photo;
    Button submit, map, ar;
    LinearLayout lllayout, maplayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_it);
        txttitle = (TextView) findViewById(R.id.fTitle);
        txtdesc = (TextView) findViewById(R.id.fQsDesc);
        Reply = (EditText) findViewById(R.id.fedtQsReply);
        Amount = (EditText) findViewById(R.id.fedtQsAmount);
        submit = (Button) findViewById(R.id.fbtnSpSubmit);
        photo = (ImageView) findViewById(R.id.fivQsPhoto1);
        lllayout = (LinearLayout) findViewById(R.id.llayout);
        map = (Button) findViewById(R.id.mapBtn);
        ar = (Button) findViewById(R.id.arBtn);
        maplayout = (LinearLayout) findViewById(R.id.maplayout);


        photo.setImageResource(R.drawable.ac);
        txttitle.setText("For Repairing AC at my home (Electrician)");
        String desc = "the ac in my room was not working from last few days may be some minor issues it have also there is leackage in pipe so check that also";
        txtdesc.setText(desc);

        String cData = "";
        cData = getIntent().getStringExtra("catName");

        if (cData == "done") {
            lllayout.setVisibility(View.GONE);
            maplayout.setVisibility(View.GONE);
        } else {
            ar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RemoveIt.this,ARactivity.class);
                    startActivity(intent);

                }
            });


            map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(RemoveIt.this,MapActivity.class);
                    startActivity(intent);

                }
            });

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
