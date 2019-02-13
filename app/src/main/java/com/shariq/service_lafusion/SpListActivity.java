package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.shariq.service_lafusion.adapter.SpListAdapter;
import com.shariq.service_lafusion.model.LoginPost;
import com.shariq.service_lafusion.model.SpList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  SpListActivity extends AppCompatActivity {
    SpListAdapter adapter;
    private ArrayList<SpList> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_list);


        ArrayList<SpList> data = new ArrayList<>();
        data.add(new SpList(R.drawable.plumbing, getString(R.string.plumbing),5));
        data.add(new SpList(R.drawable.appliances, getString(R.string.appliances),4));
        data.add(new SpList(R.drawable.appliances, getString(R.string.appliances),3));


        RecyclerView spList = findViewById(R.id.rvSpList);

        spList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SpListAdapter(this, data);
        spList.setAdapter(adapter);


        Intent intent = new Intent(SpListActivity.this,Homepage.class);
        startActivity(intent);



//        //Starting of retrofit
//
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
//
//        // Sending param
//        Map<String, String> params = new HashMap<>();
//
//        //params.put("category", spSpinner.getTransitionName().toString());
//
//        //Toast.makeText(CRegisterActivity.this, edtName.getText().toString(), Toast.LENGTH_SHORT).show();
//
//        // Initializing APIManager
//        APIManager api = retrofit.create(APIManager.class);
//
//        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
//        Call<Map<String, Object>> call = api.getSpList(params);
//
//        final ProgressDialog progressDialog = new ProgressDialog(SpListActivity.this);
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
//                        Toast.makeText(SpListActivity.this, "Success", Toast.LENGTH_SHORT).show();
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
//                    ArrayList<SpList> mySpList = gson.fromJson(content.get("splist").getAsJsonArray().toString(),
//                    	new TypeToken<ArrayList<SpList>>(){}.getType());
//                    } else {
//                        Toast.makeText(SpListActivity.this, "No response available.", Toast.LENGTH_SHORT).show();
//
//                        Log.d("Error", "No response available");
//                    }
//                } catch (Exception e) {
//                    Toast.makeText(SpListActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();
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
//                Toast.makeText(SpListActivity.this, "Failed", Toast.LENGTH_SHORT).show();
//
//                Log.d("Error", "onFailure: " + t.getMessage());
//            }
//        });

//        RecyclerView spList = findViewById(R.id.rvSpList);
//        spList.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new SpListAdapter(this,mySpList );
//        spList.setAdapter(adapter);
//

    }

}
