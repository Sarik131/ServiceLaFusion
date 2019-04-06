package com.shariq.service_lafusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RemoveIt2 extends AppCompatActivity {
    TextView txttitle, txtdesc;
    EditText Reply, Amount;
    ImageView photo;
    Button submit, map, ar;
    LinearLayout lllayout, maplayout;
//    SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_it2);
        txttitle = (TextView) findViewById(R.id.fTitle);
        txtdesc = (TextView) findViewById(R.id.fQsDesc);
//        Reply = (EditText) findViewById(R.id.fedtQsReply);
//        Amount = (EditText) findViewById(R.id.fedtQsAmount);
//        submit = (Button) findViewById(R.id.fbtnSpSubmit);
        photo = (ImageView) findViewById(R.id.fivQsPhoto1);
//        lllayout = (LinearLayout) findViewById(R.id.llayout);
//        map = (Button) findViewById(R.id.mapBtn);
//        ar = (Button) findViewById(R.id.arBtn);
//        maplayout = (LinearLayout) findViewById(R.id.maplayout);
//        String check=data.getString("user","null");

        photo.setImageResource(R.drawable.ac);
        txttitle.setText("For Repairing AC at my home (Electrician)");
        String desc = "the ac in my room was not working from last few days may be some minor issues it have also there is leackage in pipe so check that also";
        txtdesc.setText(desc);




        }
    }

