package com.shariq.service_lafusion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvRegister;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mappingViews();
        addListener();

    }

    void mappingViews() {
        tvRegister = findViewById(R.id.tvRegister);
    }

    void addListener() {
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvRegister:
                Intent intent = new Intent(this, CRegisterActivity.class);
                startActivity(intent);
                break;

        }

    }
}
