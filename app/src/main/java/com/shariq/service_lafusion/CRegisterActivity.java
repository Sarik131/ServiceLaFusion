package com.shariq.service_lafusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CRegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvSPRegister;

//    String txtcname;
//    String txtrepassword;
//    String txtpassword;
//    String txtuserid;
//    String cemail;
//    String caddress;
//    String cphone;

//    public void onRegister(View view)
//    {
////        txtcname=findViewById(R.id.txtcname).toString();
////        txtrepassword=findViewById(R.id.txtrepassword).toString();
////        txtpassword=findViewById(R.id.txtpassword).toString();
////        txtuserid=findViewById(R.id.txtuserid).toString();
////        cemail=findViewById(R.id.cemail).toString();
////        caddress=findViewById(R.id.caddress).toString();
////        cphone=findViewById(R.id.cphone).toString();
////        Log.d("On register", ""+txtcname+txtpassword+txtrepassword+txtuserid+cemail+caddress+cphone);
//    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cregister);

        mappingViews();
        addListener();

    }

    void mappingViews() {
        tvSPRegister = findViewById(R.id.tvSPRegister);
    }

    void addListener() {
        tvSPRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSPRegister:
                Intent intent = new Intent(this, SpRegisterActivity.class);
                startActivity(intent);
                break;
        }

    }
}
