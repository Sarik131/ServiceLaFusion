package com.shariq.service_lafusion;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateQueryActivity extends AppCompatActivity {
    ImageView imageView1;
    EditText edtCqWriteHere;
    Toolbar toolbar;
    TextView txtTitle;
    ImageView backBtn;
    EditText edtCatTitle;
    Button sButton;
    String query_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_query);
        edtCatTitle = findViewById(R.id.edtCatTitle);
        sButton=(Button)findViewById(R.id.btnCreateQuery);
        sButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});
        imageView1 = (ImageView) findViewById(R.id.ivCqPhoto1);
        edtCqWriteHere = (EditText) findViewById(R.id.edtCqWriteHere);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkandroidversion();
            }
        });
        initToolbar();
    }

    private void initToolbar() {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        txtTitle=(TextView)findViewById(R.id.toolBarTitle);
        txtTitle.setText("Create Query");
        backBtn=(ImageView)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void checkandroidversion() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 555);
            } catch (Exception e) {

            }
        } else {
            pickImage();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 555 ) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                pickImage();
            } else {
                Toast.makeText(this, "Permission not granted.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void pickImage() {

        CropImage.startPickImageActivity(this);
    }

    private void croprequest(Uri imageUri) {

        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .start(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //RESULZT FROM SELECTED IMAGE
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri imageUri = CropImage.getPickImageResultUri(this, data);
            croprequest(imageUri);
        }

        //RESULT FROM CROPPING IMAGE
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {


                    imageView1.setImageURI(result.getUri());   //use this uri for uploading image at serveru


                    }
        }

    }
    public void cSubmit(View view)
    {
        Log.d("MyLog","onSubmit");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        // Sending param
        Map<String, String> params = new HashMap<>();
        SharedPreferences data = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String c_address = data.getString("c_address", "THIS IS DEFAULT VALUE");

//        Bundle bundle = getIntent().getExtras();
//        String c_address ="";
//        if(bundle!=null){
//            c_address= bundle.getString("c_address");
//        }
        Log.d("createquery address:",c_address);
        params.put("catTitle", edtCatTitle.getText().toString());
        params.put("description", edtCqWriteHere.getText().toString());
        params.put("c_address",c_address );


        //params.put("category", spinner.getSelectedItem().toString());

        //Toast.makeText(CRegisterActivity.this, edtName.getText().toString(), Toast.LENGTH_SHORT).show();

        // Initializing APIManager
        APIManager api = retrofit.create(APIManager.class);

        // TODO: Note: Replace 'getDetails(param)' API method for every new API here
        Call<Map<String, Object>> call = api.createQuery(params);

        final ProgressDialog progressDialog = new ProgressDialog(CreateQueryActivity.this);
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
                        Toast.makeText(CreateQueryActivity.this, "Success", Toast.LENGTH_SHORT).show();

                        Log.d("Error", "onResponse: body: " + response.body());

                        // Read response as follow
                        Map<String, Object> map = response.body();

                        // Converting response map to JsonObject
                        Gson gson = new Gson();
                        String jsonString = gson.toJson(map);

                        Log.d("error", "jsonString: " + jsonString);

                        JsonObject content = gson.fromJson(jsonString, JsonObject.class);
                        query_id=content.get("query_id").getAsString();

                        Intent intent=new Intent(CreateQueryActivity.this,RemoveIt2.class);
                        intent.putExtra("catName","done");
                        intent.putExtra("query_id",query_id);
                        startActivity(intent);
                        // TODO: Read response here
                        //content.get("email").getAsString();
                        //content.get("password").getAsString();
                        // Convert JsonArray to your custom model class list as follow
//                    ArrayList<LoginPost> myModelList = gson.fromJson(content.get(array_name).getAsJsonArray().toString(),
//                    	new TypeToken<ArrayList<LoginPost>>(){}.getType());
                    } else {
                        Toast.makeText(CreateQueryActivity.this, "No response available.", Toast.LENGTH_SHORT).show();
                        Log.d("Error", "No response available");
                    }
                } catch (Exception e) {
                    Toast.makeText(CreateQueryActivity.this, "Error occurred.", Toast.LENGTH_SHORT).show();

                    Log.d("Error", "Error in reading response: " + e.getMessage());
                }
            }
                @Override
                public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                    if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    Toast.makeText(CreateQueryActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    Log.d("Error", "onFailure: " + t.getMessage());
                }
            });
    }

}