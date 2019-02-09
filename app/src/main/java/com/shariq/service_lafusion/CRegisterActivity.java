package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CRegisterActivity extends AppCompatActivity  {
    TextView tvSPRegister;

    TextView edtName;
    TextView txtpassword;
    TextView cemail;
    TextView caddress;
    TextView cphone;

//    public void onRegister(View view)
//    {


//    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cregister);


//        edtName =(TextView) findViewById(R.id.edtSpName);
//        txtpassword=(TextView) findViewById(R.id.edtSpPassword);
//        cemail=(TextView) findViewById(R.id.cemail);
//        caddress=(TextView) findViewById(R.id.caddress);
//        cphone=(TextView) findViewById(R.id.cphone);

        Log.d("On register", ""+ edtName +txtpassword+cemail+caddress+cphone);
       // mappingViews();
        //addListener();

    }

   //
//    void addListener() {
//        tvSPRegister.setOnClickListener(this);
//    }

//    public void onRegister(View v) {
////        switch (v.getId()) {
////            case R.id.tvSPRegister:
////                Intent intent = new Intent(this, SpRegisterActivity.class);
////                startActivity(intent);
////                break;
////        }
//
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
//
//        // Sending param
//        Map<String, String> params = new HashMap<>();
//
//       params.put("name", edtName.getText().toString());
//       params.put("password", txtpassword.getText().toString());
//       params.put("email", cemail.getText().toString());
//       params.put("phoneno", cphone.getText().toString());
//       params.put("address", caddress.getText().toString());
//        //Toast.makeText(CRegisterActivity.this, edtName.getText().toString(), Toast.LENGTH_SHORT).show();
//
//        // Initializing APIManager
//        APIManager api = retrofit.create(APIManager.class);
//
//        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
//        Call<Map<String, Object>> call = api.register(params);
//
//        final ProgressDialog progressDialog = new ProgressDialog(CRegisterActivity.this);
//        progressDialog.setMessage("Please Wait...");
//        progressDialog.show();
//
//        call.enqueue(new Callback<Map<String, Object>>() {
//            @Override
//            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
//                if (progressDialog != null && progressDialog.isShowing()) {
//                    progressDialog.dismiss();
//                }
//
//                try {
//                    // Read response as follow
//                    if (response != null && response.body() != null) {
//                        Toast.makeText(CRegisterActivity.this, "Success", Toast.LENGTH_SHORT).show();
//
//                        Log.d("Error", "onResponse: body: " + response.body());
//
//                        // Read response as follow
//                        Map<String, Object> map = response.body();
//
//                        // Converting response map to JsonObject
//                        Gson gson = new Gson();
//                        String jsonString = gson.toJson(map);
//
//                        Log.d("error", "jsonString: " + jsonString);
//
//                        JsonObject content = gson.fromJson(jsonString, JsonObject.class);
//
//                        // TODO: Read response here
//                        //content.get("email").getAsString();
//                        //content.get("password").getAsString();
//
//                        // Convert JsonArray to your custom model class list as follow
////                    ArrayList<LoginPost> myModelList = gson.fromJson(content.get(array_name).getAsJsonArray().toString(),
////                    	new TypeToken<ArrayList<LoginPost>>(){}.getType());
//                    } else {
//                        Toast.makeText(CRegisterActivity.this, "No response available.", Toast.LENGTH_SHORT).show();
//
//                        Log.d("Error", "No response available");
//                    }
//                } catch (Exception e) {
//                    Toast.makeText(CRegisterActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();
//
//                    Log.d("Error", "Error in reading response: " + e.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
//                if (progressDialog != null && progressDialog.isShowing()) {
//                    progressDialog.dismiss();
//                }
//
//                Toast.makeText(CRegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//
//                Log.d("Error", "onFailure: " + t.getMessage());
//            }
//        });
//
//
//    }
}
