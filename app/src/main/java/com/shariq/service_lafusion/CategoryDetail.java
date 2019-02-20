package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.shariq.service_lafusion.adapter.SpAdapter;
import com.shariq.service_lafusion.model.Category;
import com.shariq.service_lafusion.model.LoginPost;
import com.shariq.service_lafusion.model.SpDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryDetail extends AppCompatActivity {
    SpAdapter adapter;
    RecyclerView recyclerView;
    private TextView tvcategory, tvdesc;
    private ImageView imageView;
    List<SpDetail> myModelList=new ArrayList<SpDetail>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        //String cData=getIntent().getStringExtra("categoryName");

        String cData = "";
        cData = getIntent().getStringExtra("catName");

//        if (extras != null) {
//            cData = extras.getString("catName");
//        }

        Log.d("cData", "category :- " + cData);
        // cname = getIntent().getStringExtra("Carpenter");


//        String cname=getIntent().getStringExtra("Carpenter");
//        if (extras != null) {
//            cname = extras.getString("Carpenter");
//        }
//        Log.d("cData","Why nothing is coming :"+cname);
        tvcategory = (TextView) findViewById(R.id.tvcategoryName);
        //      tvcategory.setText(cname);
        //    Log.d("cData","wtf small"+cname);
        recyclerView = (RecyclerView) findViewById(R.id.spListRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        getList(cData);

//initialization

/*
<<<<<<< Updated upstream
=======
        String desc=getIntent().getStringExtra("desc");
        tvdesc.setText(desc);

        Intent intent=new Intent();
        intent.putExtra("category",cname);
>>>>>>> Stashed changes
    */
    }


    public void getList(String name) {
        String category = name;
        Log.d("getList", "karte rehhhh" + category);

//
//        switch (pos) {
//            case 1:
//                category = "carpenter";
//                break;
//
//            case 2:
//                category = "painter";
//                break;
//
//            case 3:
//                category = "cleaning";
//                break;
//
//            case 4:
//                category = "appliances";
//                break;
//
//            case 5:
//                category = "electricain";
//                break;
//
//            case 6:
//                category = "pakers";
//                break;
//
//            case 7:
//                category = "carpenter";
//                break;
//
//            case 8:
//                category = "photographer";
//                break;
//
//            case 9:
//                category = "eventmanagement";
//                break;
//
//            case 10:
//                category = "fitnesstrainer";
//                break;
//
//            case 11:
//                category = "pestcontroller";
//                break;
//
//            case 12:
//                category = "parlour";
//                break;
//
//            case 13:
//                category = "gardener";
//                break;
//
//            case 14:
//                category = "astrologer";
//                break;
//
//            case 15:
//                category = "plumber";
//                break;
//
//        }
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Sending param
        Map<String, String> params = new HashMap<>();
//        params.put("email", email.toString());
        params.put("category", category);

        // Initializing APIManager
        APIManager api = retrofit.create(APIManager.class);

        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
        Call<Map<String, Object>> call = api.getSpList(params);

        final ProgressDialog progressDialog = new ProgressDialog(CategoryDetail.this);
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
                  if (response != null && response.body() != null)
    {
                        Toast.makeText(CategoryDetail.this, "Success", Toast.LENGTH_SHORT).show();

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
                        Log.d("MyLog","Inside try");
                        // Convert JsonArray to your custom model class list as follow
                        myModelList = gson.fromJson(content.get("splist").getAsJsonArray().toString(),
                                new TypeToken<List<SpDetail>>() {
                                }.getType());

                        if(myModelList!=null)
                            Log.d("MyLog","not null");

        adapter = new SpAdapter(myModelList);

        recyclerView.setAdapter(adapter);

                    }
                    else
                        {
                        Toast.makeText(CategoryDetail.this, "No response available.", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "No response available");
                    }
                } catch (Exception e) {
                    Toast.makeText(CategoryDetail.this, "Error occurred.", Toast.LENGTH_SHORT).show();

                    Log.d("Error", "Error in reading response: " + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                Toast.makeText(CategoryDetail.this, "Failed", Toast.LENGTH_SHORT).show();

                Log.d("Error", "onFailure: " + t.getMessage());
            }
        });
        //
        if(myModelList!=null)
        for (SpDetail str : myModelList) {
            Log.d("arrayList", str.getName() + "  " + str.getExperience());


        }

    }
}
