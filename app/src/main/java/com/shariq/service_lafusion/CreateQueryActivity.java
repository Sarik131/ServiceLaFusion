package com.shariq.service_lafusion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class CreateQueryActivity extends AppCompatActivity {
 ImageView imageView1,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_quert_activity);
        imageView1=(ImageView)findViewById(R.id.photo1);
        imageView2=(ImageView)findViewById(R.id.photo2);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,9999);
            }
        });
       imageView2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(intent,9999);
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap photoo1=(Bitmap)data.getExtras().get("data");
        imageView1.setImageBitmap(photoo1);
        Bitmap photoo2=(Bitmap)data.getExtras().get("data");
        imageView2.setImageBitmap(photoo2);

    }

}
