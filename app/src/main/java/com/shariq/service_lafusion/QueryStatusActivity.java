package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.shariq.service_lafusion.adapter.SpAdapter;
import com.shariq.service_lafusion.model.SpDetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class QueryStatusActivity extends AppCompatActivity {
    TextView tvDesc,tvTitle;
    ImageView imageView;
    EditText edtReply,edtAmount;
    Button submit;
    String title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_status);
        tvDesc=(TextView)findViewById(R.id.tvQsDesc);
        tvTitle=(TextView) findViewById(R.id.tvTitle);
        imageView=(ImageView)findViewById(R.id.ivQsPhoto1);
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        edtReply=(EditText)findViewById(R.id.edtQsReply);
        edtAmount=(EditText)findViewById(R.id.edtQsAmount);
        submit=(Button)findViewById(R.id.btnSpSubmit);

        Bundle bundle=getIntent().getExtras();
        String check= bundle.getString("check");

        String query_id=bundle.getString("query_id");
        Log.d("In query status",query_id);
        if(check == "visible"){
            edtAmount.setVisibility(View.VISIBLE);
            edtReply.setVisibility(View.VISIBLE);
            submit.setVisibility(View.VISIBLE);
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QueryStatusActivity.this, "Request Send.", Toast.LENGTH_SHORT).show();
            }
        });


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Sending param
        Map<String, String> params = new HashMap<>();
        params.put("query_id",query_id);


        // Initializing APIManager
        APIManager api = retrofit.create(APIManager.class);

        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
        Call<Map<String, Object>> call = api.queryStatus(params);

        final ProgressDialog progressDialog = new ProgressDialog(QueryStatusActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                try {
//                     Read response as follow
                    if (response != null && response.body() != null) {
                        Toast.makeText(QueryStatusActivity.this, "Success", Toast.LENGTH_SHORT).show();

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
                        Log.d("MyLog", "Inside try");
                        // Convert JsonArray to your custom model class list as follow
                    } else {
                        Toast.makeText(QueryStatusActivity.this, "No response available.", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "No response available");
                    }
                } catch (Exception e) {
                    Toast.makeText(QueryStatusActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();

                    Log.d("Error", "Error in reading response: " + e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                Toast.makeText(QueryStatusActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                Log.d("Error", "onFailure: " + t.getMessage());
            }
        });
        }
    }
