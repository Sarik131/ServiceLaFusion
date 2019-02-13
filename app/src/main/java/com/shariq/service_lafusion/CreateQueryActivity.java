package com.shariq.service_lafusion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class CreateQueryActivity extends AppCompatActivity {
 ImageView imageView1;
 EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_query);
        imageView1=(ImageView)findViewById(R.id.ivCqPhoto1);
        editText=(EditText)findViewById(R.id.edtCqWriteHere);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,9999);
                String category=getIntent().getStringExtra("category");
                Log.d("category"," in create query"+category);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap photoo1=(Bitmap)data.getExtras().get("data");
        imageView1.setImageBitmap(photoo1);

    }
    public void clickIt(View view)
    {
         String writeHere;
         int image;
         writeHere=editText.toString();
         image=imageView1.getId();
         Intent intent = new Intent(CreateQueryActivity.this, QueryStatusActivity.class);
         intent.putExtra("WriteHere",writeHere);
         intent.putExtra("Image",image);
         startActivity(intent);
    }

}
