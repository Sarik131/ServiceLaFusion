package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class Start extends AppCompatActivity {
    public TextView email;
    public TextView password;
    public String check="";
    public RadioGroup radioGroupUser;
    public RadioButton radioButtonUser;
    private String c_address="",sp_id="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.edtSpEmail);
        password = findViewById(R.id.edtSpPassword);
        radioGroupUser = findViewById(R.id.radioGroupUser);

        Log.d("email", String.valueOf(email.getText()));
        Log.d("email", String.valueOf(password.getText()));

      /*  sbg.setOnClickedButtonPosition(new SegmentedButtonGroup.OnClickedButtonPosition() {
            @Override
            public void onClickedButtonPosition(int position) {
                if(position ==0)
                {
                  Toast.makeText(Start.this,"Customer Login",Toast.LENGTH_SHORT).show();
                }
            }
        });*/

    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(Start.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    public void createAccount(View view) {
        Intent intent = new Intent(Start.this, Cust_Registration.class);
        startActivity(intent);
    }

    public void onLogin(View view) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        if(radioGroupUser.getCheckedRadioButtonId() == -1 ) {
            Toast.makeText(Start.this,"Please select the user!!!",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            radioButtonUser = (RadioButton) findViewById(radioGroupUser.getCheckedRadioButtonId());
        }


        // Sending param
        Map<String, String> params = new HashMap<>();
        params.put("email", email.getText().toString());
        params.put("password", password.getText().toString());
        params.put("user", radioButtonUser.getText().toString());

        // Initializing APIManager
        APIManager api = retrofit.create(APIManager.class);

        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
        Call<Map<String, Object>> call = api.login(params);

        final ProgressDialog progressDialog = new ProgressDialog(Start.this);
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
                        //Toast.makeText(Start.this, "Success", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "onResponse: body: " + response.body());

                        // Read response as follow
                        Map<String, Object> map = response.body();

                        // Converting response map to JsonObject
                        Gson gson = new Gson();
                        String jsonString = gson.toJson(map);

                        Log.d("error", "jsonString: " + jsonString);

                        JsonObject content = gson.fromJson(jsonString, JsonObject.class);

                        // TODO: Read response here
                        if(radioButtonUser.getText().toString().equalsIgnoreCase("Customer")) {
                            check = content.get("checkLogin").getAsString();
                            c_address = content.get("c_address").getAsString();
                        }
                        else
                        {
                            check = content.get("checkLogin").getAsString();
                            sp_id = content.get("sp_id").getAsString();
                        }
                        //content.get("password").getAsString();
                        Log.d("checkLogin", check);
                        Log.d("c_address : ", c_address);
                        Log.d("sp_id : ", sp_id);


                        if (check.equals("true")) {

                            SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());


                                if(radioButtonUser.getText().toString().equals("Customer")) {
                                    Intent intent = new Intent(Start.this, Homepage.class);
                                    Log.d("start.user", radioButtonUser.getText().toString());
                                    //intent.putExtra("user",user.getTextAlignment());
                                    data.edit().putString("c_address", c_address).commit();
                                    data.edit().putString("user", radioButtonUser.getText().toString()).commit();
                                    intent.putExtra("c_address",c_address);
                                    startActivity(intent);
                                }
                                else
                                {
                                    Intent intent = new Intent(Start.this, QueryStatusActivity.class);
                                    Log.d("start.user", radioButtonUser.getText().toString());
                                    //intent.putExtra("user",user.getTextAlignment());
                                    data.edit().putString("sp_id", sp_id).commit();
                                    data.edit().putString("user", radioButtonUser.getText().toString()).commit();
                                    startActivity(intent);
                                }

                        }
                        else {
                            Toast.makeText(Start.this, "Email or Password is wrong.", Toast.LENGTH_SHORT).show();
                        }
                        // Convert JsonArray to your custom model class list as follow
//                    ArrayList<LoginPost> myModelList = gson.fromJson(content.get(array_name).getAsJsonArray().toString(),
//                    	new TypeToken<ArrayList<LoginPost>>(){}.getType());
                    } else {
                        Toast.makeText(Start.this, "No response available.", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "No response available");
                    }
                } catch (Exception e) {
                    Toast.makeText(Start.this, "Error occurred.", Toast.LENGTH_SHORT).show();

                    Log.d("Start.Error",   e.toString());
//                    Log.d("Start.Error", "Error in reading response: " +  e.printStackTrace());
                    Log.d("Error", "Error in reading response: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                Toast.makeText(Start.this, "Failed", Toast.LENGTH_SHORT).show();

                Log.d("Error", "onFailure: " + t.getMessage());
            }
        });


    }
}
