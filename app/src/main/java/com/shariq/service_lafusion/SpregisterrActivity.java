package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public  class SpregisterrActivity extends AppCompatActivity  {
    EditText edtName, edtEmail, edtPhoneNumber, edtPassword, edtRetype_Pass, edtExperirnce;
    Spinner spCategory;
    Button btnSubmit;

    EditText edtSpName;
    EditText edtSpEmail;
    EditText edtSpPhoneNumber;
    EditText edtSpPassword;
    EditText edtSpExperience;
    //Spinner spSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_register_activity);
        Spinner spinner =findViewById(R.id.spSpinner);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        edtSpName=(EditText) findViewById(R.id.edtSpName);
        edtSpPassword=(EditText) findViewById(R.id.edtSpPassword);
        edtSpEmail=(EditText) findViewById(R.id.edtSpEmail);
        edtSpPhoneNumber=(EditText) findViewById(R.id.edtSpPhoneNumber);
        edtSpExperience=(EditText) findViewById(R.id.edtSpExperience);
        //spSpinner=(Spinner) findViewById(R.id.spSpinner);

    }
    public void onSubmit(View view)
    {

        Intent intent = new Intent(SpregisterrActivity.this,Homepage.class);
        startActivity(intent);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Sending param
        Map<String, String> params = new HashMap<>();

        params.put("name", edtSpName.getText().toString());
        params.put("password", edtSpPassword.getText().toString());
        params.put("email", edtSpEmail.getText().toString());
        params.put("phoneno", edtSpPhoneNumber.getText().toString());
        params.put("experience", edtSpExperience.getText().toString());
        //params.put("category", spSpinner.getTransitionName().toString());

        //Toast.makeText(CRegisterActivity.this, edtName.getText().toString(), Toast.LENGTH_SHORT).show();

        // Initializing APIManager
        APIManager api = retrofit.create(APIManager.class);

        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
        Call<Map<String, Object>> call = api.register(params);

        final ProgressDialog progressDialog = new ProgressDialog(SpregisterrActivity.this);
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
                        Toast.makeText(SpregisterrActivity.this, "Success", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "onResponse: body: " + response.body());

                        // Read response as follow
                        Map<String, Object> map = response.body();

                        // Converting response map to JsonObject
                        Gson gson = new Gson();
                        String jsonString = gson.toJson(map);

                        Log.d("error", "jsonString: " + jsonString);

                        JsonObject content = gson.fromJson(jsonString, JsonObject.class);

                        // TODO: Read response here
                        //content.get("email").getAsString();
                        //content.get("password").getAsString();

                        // Convert JsonArray to your custom model class list as follow
//                    ArrayList<LoginPost> myModelList = gson.fromJson(content.get(array_name).getAsJsonArray().toString(),
//                    	new TypeToken<ArrayList<LoginPost>>(){}.getType());
                    } else {
                        Toast.makeText(SpregisterrActivity.this, "No response available.", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "No response available");
                    }
                } catch (Exception e) {
                    Toast.makeText(SpregisterrActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();

                    Log.d("Error", "Error in reading response: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                Toast.makeText(SpregisterrActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                Log.d("Error", "onFailure: " + t.getMessage());
            }
        });

    }



}