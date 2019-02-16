package com.shariq.service_lafusion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;

import java.io.File;

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
               openGallery(v);
            }
        });

    }

    public  void openGallery(View view)
    {
        Crop.pickImage(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_OK )
        {
            if(requestCode == Crop.REQUEST_PICK)
            {
                Uri source=data.getData();
                Uri destination=Uri.fromFile(new File(getCacheDir(),"cropped"));

                Crop.of(source,destination).asSquare().start(this);
                imageView1.setImageURI(Crop.getOutput(data));
            }
            else if(requestCode == Crop.REQUEST_CROP)
            {
                handle(requestCode,data);
            }

        }
    }

    private void handle(int Code, Intent data) {
        if(Code==RESULT_OK)
        {
            imageView1.setImageURI(Crop.getOutput(data));
        }
        else if(Code == Crop.RESULT_ERROR)
        {
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT);
        }
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
