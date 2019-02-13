package com.shariq.service_lafusion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);
    }
    public  void  home(View view)

    {
        Intent intent = new Intent(ForgotPasswordActivity.this,CreateQueryActivity.class);
        startActivity(intent);
    }



}

//public class ForgotPasswordActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_forgot_password);
//    }
//}
