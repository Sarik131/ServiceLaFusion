package com.shariq.service_lafusion;

import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;
import com.shariq.service_lafusion.model.MyGeoObject;

import java.util.ArrayList;

public class ARactivity extends AppCompatActivity implements OnClickBeyondarObjectListener {

    private BeyondarFragmentSupport beyondArFragment;
    ArrayList<MyGeoObject> myGeoObjList = new ArrayList<>();
    // TODO: 10/26/2018 1) Check that AR code   2) Add location code    3) Check for permission.
int i;

    World world;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aractivity);

        Log.d("Error", "oncreate");
            SensorManager mSensorManager =(SensorManager)getSystemService(SENSOR_SERVICE);
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA) // Checking for Camera
                && mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null // Checking for Accelerometer
                && mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) // Checking for Magnetic Sensor
        {
            // Supported
            Log.d("Error", "supported");
        } else {
            Log.d("Error", "not supported");
            // Not supported
            // Toast with proper message
            Toast.makeText(this, "AR is not supported on your device.", Toast.LENGTH_SHORT).show();
            finish();

        }

        beyondArFragment = (BeyondarFragmentSupport) getSupportFragmentManager().findFragmentById(R.id.beyondarFragment);
        createWorld();
    }


    void createWorld() {
        Log.d("Error", "creating world");
        //--------------------------
        // This distance will set icons away from users as the value increases.
        beyondArFragment.setPushAwayDistance(10);


        // Creating a world where all objects will be put.
        world = new World(ARactivity.this);

        // Default icon.
        // This is useful if you are loading images from Internet and the connection get lost.
        world.setDefaultBitmap(R.drawable.car, World.LIST_TYPE_DEFAULT);

        // Setting user's position in the World.
        world.setGeoPosition(22.311851, 73.197290);
        //world.setLocation();

        createGeoObjectsList();

        // Adding Wold data in to beyondArFragment.
        beyondArFragment.setWorld(world);


        // Setting Click Event Listener and callbacks will be received in 'onClickBeyondarObject'.
        beyondArFragment.setOnClickBeyondarObjectListener(this);
        //--------------------------
    }


    void createGeoObjectsList() {
        // myGeoObjList.clear();

        //Log.d("Error", "my latlng: " + myLocation.latitude + " " + myLocation.longitude);

        MyGeoObject myGeoObject;

//        //------------------
//        myGeoObject = new MyGeoObject();
//
//        myGeoObject.setGeoPosition(22.311797, 73.196928);
//
//        // Drawable is available
//        myGeoObject.setImageResource(R.drawable.car);
//
//
//        myGeoObject.setName("Test icon");
//
//        myGeoObjList.add(myGeoObject);
//        //------------------
//
//
//        // Adding GeoObjects to the world
//        for (MyGeoObject geoObject : myGeoObjList) {
//            world.addBeyondarObject(geoObject);
//        }

        GeoObject go1 = new GeoObject(1l);
        go1.setGeoPosition(22.311797, 73.196928);
        go1.setImageResource(R.drawable.car);
        go1.setName("Creature 1");
        world.addBeyondarObject(go1);

        Log.d("Error", "createGeoObjectsList: Object added");
    }

    @Override
    public void onClickBeyondarObject(ArrayList<BeyondarObject> arrayList) {

    }
}