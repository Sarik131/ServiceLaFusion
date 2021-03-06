package com.shariq.service_lafusion;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AfterRemoveActivity extends AppCompatActivity {
    ImageView imageView1;
    EditText edtCqWriteHere;
    Toolbar toolbar;
    TextView txtTitle;
    ImageView backBtn;
    EditText edtCatTitle;
    Button sButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_query);
        edtCatTitle = findViewById(R.id.edtCatTitle);
    sButton=(Button)findViewById(R.id.btnCreateQuery);
    sButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(AfterRemoveActivity.this,Start.class);
        intent.putExtra("catName","done");
        startActivity(intent);
    }
});
//        imageView1 = (ImageView) findViewById(R.id.ivCqPhoto1);
//        edtCqWriteHere = (EditText) findViewById(R.id.edtCqWriteHere);
//        imageView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkandroidversion();
//            }
//        });
//        initToolbar();
    }

//    private void initToolbar() {
//        toolbar=(Toolbar)findViewById(R.id.toolbar);
//        txtTitle=(TextView)findViewById(R.id.toolBarTitle);
//        txtTitle.setText("Create Query");
//        backBtn=(ImageView)findViewById(R.id.backBtn);
//        backBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }

//    public void checkandroidversion() {
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            try {
//                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 555);
//            } catch (Exception e) {
//
//            }
//        } else {
//            pickImage();
//        }
//    }

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
    public void cSubmit(View view) {

    }

}