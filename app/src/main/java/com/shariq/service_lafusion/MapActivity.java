package com.shariq.service_lafusion;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    // TODO: Step-3: Enable 'Maps SDK for Android' and 'Directions API' in Google APIs console. (if it is not automatically enabled)
    // Google APIs Console Link: https://console.developers.google.com/apis/dashboard

    // TODO: Step-6: Create object of Google Map and list of locations.
    private GoogleMap map;
    private ArrayList<LatLng> locationList = new ArrayList<>();

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // TODO: Step-7: Set up Google Map fragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // TODO: Step-9: Prepare list of locations for getting route.
        // First location will be starting point, last location will be destination & intermediate locations will be way points.
        locationList.add(new LatLng(22.332770, 73.217033));
        locationList.add(new LatLng(22.311784, 73.191386));
        locationList.add(new LatLng(22.298150, 73.197092));
        locationList.add(new LatLng(22.311093, 73.180872));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // TODO: Step-8: Override onMapReady method and handle loaded map here
        map = googleMap;

        // TODO: Step-10: Show markers of locations on map and set zoom level in such a way that all markers can be visible in screen
        showMarkers();

        // TODO: Step-12: Call API from button click or in similar other way
        findViewById(R.id.fabDirections).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (locationList.size() >= 2) {
                    String url = getDirectionsUrl(locationList.get(0), locationList.get(locationList.size() - 1),
                            locationList.size()>2   ?   locationList.subList(1, locationList.size() - 1)    :    new ArrayList<LatLng>());

                    DownloadTask downloadTask = new DownloadTask();

                    // Start downloading json data from Google Directions API
                    downloadTask.execute(url);
                } else {
                    Toast.makeText(MapActivity.this, "At least two locations are required for drawing route", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // TODO: Step-11: Add following methods and async tasks
    /**
     * Get direction url for Google Direction API.
     */
    private String getDirectionsUrl(LatLng origin, LatLng dest, List<LatLng> wayPointList) {
        // Building the parameters
        String parameters = "key=" + getString(R.string.google_api_key1)
                + "&" + "origin=" + origin.latitude + "," + origin.longitude
                + "&" + "destination=" + dest.latitude + "," + dest.longitude
                + "&" + "sensor=false";

        String wayPointLatLngs = "";

        if (wayPointList.size() > 0) {
            StringBuilder wayPointLatLngBuilder = new StringBuilder();

            for (LatLng wayPoint : wayPointList) {
                wayPointLatLngBuilder.append(wayPoint.latitude).append(",").append(wayPoint.longitude).append("|");
            }

            if (wayPointLatLngBuilder.toString().length() > 1) {
                wayPointLatLngs = wayPointLatLngBuilder.toString()
                        .substring(0, wayPointLatLngBuilder.toString().length() - 1);
            }
        }

        if (!wayPointLatLngs.isEmpty()) {
            parameters += "&" + "waypoints=" + wayPointLatLngs;
        }

        // Building the url to the web service
        return "https://maps.googleapis.com/maps/api/directions/json?" + parameters;
    }

    /**
     * Adds markers in map.
     */
    private void showMarkers() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        for (int i = 0; i < locationList.size(); i++) {
            map.addMarker(new MarkerOptions().position(locationList.get(i)));

            // Adding location in bounds
            builder.include(locationList.get(i));
        }

        final LatLngBounds bounds = builder.build();

        // Waiting for map to be loaded properly
        map.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds,
                        getResources().getDimensionPixelSize(R.dimen.map_bounds_padding))); // Padding for markers
            }
        });
    }

    /**
     * Downloads json data from url.
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuilder stringBuilder = new StringBuilder();

            String line = "";
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }

            data = stringBuilder.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Error", "Exception while downloading url: " + e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }

        Log.d("Error", "downloadUrl: " + data);

        return data;
    }
    //AsyncTask<input parameter,void`on progress change,Post execution>
    private class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            if (progressDialog == null) {
                progressDialog = new ProgressDialog(MapActivity.this);
            }

            progressDialog.setMessage(getString(R.string.please_wait_));
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
        //4th method onProgressChange()
    }

    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();
            String distance = "";
            String duration = "";

            if (result.size() < 1) {
                Toast.makeText(getBaseContext(), "No Points", Toast.LENGTH_SHORT).show();
                return;
            }

            if (map == null) {
                return;
            }

            map.clear();

            showMarkers();

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    if (j == 0) {    // Get distance from the list
                        distance = (String) point.get("distance");
                        continue;
                    } else if (j == 1) { // Get duration from the list
                        duration = (String) point.get("duration");
                        continue;
                    }

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(getResources().getDimension(R.dimen.route_thickness));
                lineOptions.color(Color.BLACK);
            }

            // Drawing polyline in the Google Map for the i-th route
            map.addPolyline(lineOptions);
        }
    }
}
