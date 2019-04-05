package com.shariq.service_lafusion;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MyMapActivity extends AppCompatActivity implements OnMapReadyCallback,LocationListener {

    private GoogleMap mMap;
    LocationManager man;
    Location loc;
    double lati = 0, longi = 0;
    Address address;
    Geocoder geo = null;
    String soc, area, city, state, country, pin, dno;
    boolean isGps, isNet;
    boolean first = true;
    LatLng prev = null, current = null;
    SupportMapFragment mapFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_map);


        man = (LocationManager) getSystemService(LOCATION_SERVICE);
        isNet = man.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        isGps = man.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (isNet || isGps) {
            if (isNet) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                man.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10, this);

                if (man != null) {
                    loc = man.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if (loc != null) {
                        lati = loc.getLatitude();
                        longi = loc.getLongitude();
                    }
                }
            }
            if (isGps) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                man.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);

                if (man != null) {
                    loc = man.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (loc != null) {
                        lati = loc.getLatitude();
                        longi = loc.getLongitude();
                    }
                }
            }
        }
        Toast.makeText(getApplicationContext(), "LATI :" + lati + "LONGI:" + longi, Toast.LENGTH_LONG).show();
        try {

            geo = new Geocoder(this, Locale.getDefault());
            List<Address> list = geo.getFromLocation(lati, longi, 1);

            address = list.get(0);

            soc = address.getAddressLine(0);
            area = address.getAddressLine(1);
            city = address.getLocality();
            state = address.getAdminArea();
            country = address.getCountryName();
            pin = address.getPostalCode();

            Toast.makeText(getApplicationContext(), soc + "," + area + "'" + city + "," + state + "," + country + "," + pin, Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "ERROR:" + e.getMessage(), Toast.LENGTH_LONG);
        }


        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onLocationChanged(Location location)
    {

        isNet = man.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        isGps = man.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if (isNet || isGps) {
            if (isNet) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                man.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10, this);

                if(man!=null)
                {
                    loc=man.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    if(loc!=null)
                    {
                        lati=loc.getLatitude();
                        longi=loc.getLongitude();
                    }
                }
            }
            if(isGps)
            {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                man.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);

                if(man!=null)
                {
                    loc=man.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if(loc!=null)
                    {
                        lati=loc.getLatitude();
                        longi=loc.getLongitude();
                    }
                }
            }
        }
        mapFragment.getMapAsync(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Toast.makeText(getApplicationContext(),"IN MAP",Toast.LENGTH_LONG).show();
        if(first)
        {
            prev=new LatLng(lati,longi);
            first=false;
        }

        // Add a marker in Sydney and move the camera
        current = new LatLng(lati,longi);
        mMap.clear();
        mMap.addMarker(new MarkerOptions().position(current).title("Marker in India "));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(20),2000,null);

        Polyline line=mMap.addPolyline(new PolylineOptions().add(prev,current).width(5).color(Color.BLUE));
        prev=current;
    }
}
