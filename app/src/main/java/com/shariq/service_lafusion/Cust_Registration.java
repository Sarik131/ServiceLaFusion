package com.shariq.service_lafusion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cust_Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust__registration);
    }
//    public void onSubmit (View view)
//    {
//        Intent intent = new Intent(Cust_Registration.this,ARactivity.class);
//        startActivity(intent);
//    }

    public void spRegister(View view){
        Intent intent = new Intent(Cust_Registration.this,SpregisterrActivity.class);
        startActivity(intent);
    }

    public void cSubmit(View view){
        Intent intent = new Intent(Cust_Registration.this,ARactivity.class);
        startActivity(intent);
    }
}
