package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class Cust_Registration extends AppCompatActivity {

    EditText edtCName;
    EditText edtCEmail;
    EditText edtCPhoneNumber;
    EditText edtCPassword;
    EditText edtCAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust__registration);

        edtCName=(EditText) findViewById(R.id.edtCName);
        edtCPassword=(EditText) findViewById(R.id.edtCPassword);
        edtCEmail=(EditText) findViewById(R.id.edtCEmail);
        edtCPhoneNumber=(EditText) findViewById(R.id.edtCPhoneNumber);
        edtCAddress=(EditText) findViewById(R.id.edtCAddress);
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

Log.d("MyLog","onSubmit");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Sending param
        Map<String, String> params = new HashMap<>();

        params.put("name", edtCName.getText().toString());
        params.put("password", edtCPassword.getText().toString());
        params.put("email", edtCEmail.getText().toString());
        params.put("phoneno", edtCPhoneNumber.getText().toString());
        params.put("address", edtCAddress.getText().toString());

        //params.put("category", spinner.getSelectedItem().toString());

        //Toast.makeText(CRegisterActivity.this, edtName.getText().toString(), Toast.LENGTH_SHORT).show();

        // Initializing APIManager
        APIManager api = retrofit.create(APIManager.class);

        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
        Call<Map<String, Object>> call = api.custRegister(params);

        final ProgressDialog progressDialog = new ProgressDialog(Cust_Registration.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                try {
                    // Read response as follow
                    if (response != null && response.body() != null) {
                        Toast.makeText(Cust_Registration.this, "Success", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "onResponse: body: " + response.body());

                        // Read response as follow
                        Map<String, Object> map = response.body();

                        // Converting response map to JsonObject
                        Gson gson = new Gson();
                        String jsonString = gson.toJson(map);

                        Log.d("error", "jsonString: " + jsonString);

                        JsonObject content = gson.fromJson(jsonString, JsonObject.class);
                        Toast.makeText(Cust_Registration.this, "Customer Registered!", Toast.LENGTH_SHORT).show();
                        // TODO: Read response here
                        //content.get("email").getAsString();
                        //content.get("password").getAsString();

                        // Convert JsonArray to your custom model class list as follow
//                    ArrayList<LoginPost> myModelList = gson.fromJson(content.get(array_name).getAsJsonArray().toString(),
//                    	new TypeToken<ArrayList<LoginPost>>(){}.getType());
                    } else {
                        Toast.makeText(Cust_Registration.this, "No response available.", Toast.LENGTH_SHORT).show();
                        Log.d("Error", "No response available");
                    }
                } catch (Exception e) {
                    Toast.makeText(Cust_Registration.this, "Error occurred.", Toast.LENGTH_SHORT).show();

                    Log.d("Error", "Error in reading response: " + e.getMessage());
                }
            }
            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                Toast.makeText(Cust_Registration.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.d("Error", "onFailure: " + t.getMessage());
            }
        });

        Intent intent = new Intent(Cust_Registration.this,Homepage.class);
        startActivity(intent);
    }

    public void cAr(View view){
        Intent intent = new Intent(Cust_Registration.this,ARactivity.class);
        startActivity(intent);
    }
}
