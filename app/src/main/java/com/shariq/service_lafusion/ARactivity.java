package com.shariq.service_lafusion;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.widget.Toast;

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.view.OnClickBeyondarObjectListener;
import com.beyondar.android.world.BeyondarObject;
import com.beyondar.android.world.GeoObject;
import com.beyondar.android.world.World;
import com.shariq.service_lafusion.model.MyGeoObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        world.setGeoPosition(22.188512, 73.188100);
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
        go1.setGeoPosition(22.188432, 73.188107);
        go1.setImageResource(R.drawable.red);
        go1.setName("Creature 1");
        world.addBeyondarObject(go1);

        go1 = new GeoObject(2l);
        go1.setGeoPosition(22.188526, 73.187938);
        go1.setImageResource(R.drawable.red);
        go1.setName("Creature 1");
        world.addBeyondarObject(go1);


        go1 = new GeoObject(3l);
        go1.setGeoPosition(22.188608, 73.188086);
        go1.setImageResource(R.drawable.g);
        go1.setName("Creature 1");
        world.addBeyondarObject(go1);


        go1 = new GeoObject(4l);
        go1.setGeoPosition(22.188556, 73.188257);
        go1.setImageResource(R.drawable.red);
        go1.setName("Creature 1");
        world.addBeyondarObject(go1);



        Log.d("Error", "createGeoObjectsList: Object added");
    }

    @Override
    public void onClickBeyondarObject(ArrayList<BeyondarObject> arrayList) {

    }
//
//    @Override
//    public AssetManager getAssets() {
//        return null;
//    }
//
//    @Override
//    public Resources getResources() {
//        return null;
//    }
//
//    @Override
//    public PackageManager getPackageManager() {
//        return null;
//    }
//
//    @Override
//    public ContentResolver getContentResolver() {
//        return null;
//    }
//
//    @Override
//    public Looper getMainLooper() {
//        return null;
//    }
//
//    @Override
//    public Context getApplicationContext() {
//        return null;
//    }
//
//    @Override
//    public void setTheme(int resid) {
//
//    }
//
//    @Override
//    public Resources.Theme getTheme() {
//        return null;
//    }
//
//    @Override
//    public ClassLoader getClassLoader() {
//        return null;
//    }
//
//    @Override
//    public String getPackageName() {
//        return null;
//    }
//
//    @Override
//    public ApplicationInfo getApplicationInfo() {
//        return null;
//    }
//
//    @Override
//    public String getPackageResourcePath() {
//        return null;
//    }
//
//    @Override
//    public String getPackageCodePath() {
//        return null;
//    }
//
//    @Override
//    public SharedPreferences getSharedPreferences(String name, int mode) {
//        return null;
//    }
//
//    @Override
//    public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteSharedPreferences(String name) {
//        return false;
//    }
//
//    @Override
//    public FileInputStream openFileInput(String name) throws FileNotFoundException {
//        return null;
//    }
//
//    @Override
//    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean deleteFile(String name) {
//        return false;
//    }
//
//    @Override
//    public File getFileStreamPath(String name) {
//        return null;
//    }
//
//    @Override
//    public File getDataDir() {
//        return null;
//    }
//
//    @Override
//    public File getFilesDir() {
//        return null;
//    }
//
//    @Override
//    public File getNoBackupFilesDir() {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public File getExternalFilesDir(@Nullable String type) {
//        return null;
//    }
//
//    @Override
//    public File[] getExternalFilesDirs(String type) {
//        return new File[0];
//    }
//
//    @Override
//    public File getObbDir() {
//        return null;
//    }
//
//    @Override
//    public File[] getObbDirs() {
//        return new File[0];
//    }
//
//    @Override
//    public File getCacheDir() {
//        return null;
//    }
//
//    @Override
//    public File getCodeCacheDir() {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public File getExternalCacheDir() {
//        return null;
//    }
//
//    @Override
//    public File[] getExternalCacheDirs() {
//        return new File[0];
//    }
//
//    @Override
//    public File[] getExternalMediaDirs() {
//        return new File[0];
//    }
//
//    @Override
//    public String[] fileList() {
//        return new String[0];
//    }
//
//    @Override
//    public File getDir(String name, int mode) {
//        return null;
//    }
//
//    @Override
//    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
//        return null;
//    }
//
//    @Override
//    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, @Nullable DatabaseErrorHandler errorHandler) {
//        return null;
//    }
//
//    @Override
//    public boolean moveDatabaseFrom(Context sourceContext, String name) {
//        return false;
//    }
//
//    @Override
//    public boolean deleteDatabase(String name) {
//        return false;
//    }
//
//    @Override
//    public File getDatabasePath(String name) {
//        return null;
//    }
//
//    @Override
//    public String[] databaseList() {
//        return new String[0];
//    }
//
//    @Override
//    public Drawable getWallpaper() {
//        return null;
//    }
//
//    @Override
//    public Drawable peekWallpaper() {
//        return null;
//    }
//
//    @Override
//    public int getWallpaperDesiredMinimumWidth() {
//        return 0;
//    }
//
//    @Override
//    public int getWallpaperDesiredMinimumHeight() {
//        return 0;
//    }
//
//    @Override
//    public void setWallpaper(Bitmap bitmap) throws IOException {
//
//    }
//
//    @Override
//    public void setWallpaper(InputStream data) throws IOException {
//
//    }
//
//    @Override
//    public void clearWallpaper() throws IOException {
//
//    }
//
//    @Override
//    public void startActivity(Intent intent) {
//
//    }
//
//    @Override
//    public void startActivity(Intent intent, @Nullable Bundle options) {
//
//    }
//
//    @Override
//    public void startActivities(Intent[] intents) {
//
//    }
//
//    @Override
//    public void startActivities(Intent[] intents, Bundle options) {
//
//    }
//
//    @Override
//    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
//
//    }
//
//    @Override
//    public void startIntentSender(IntentSender intent, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, @Nullable Bundle options) throws IntentSender.SendIntentException {
//
//    }
//
//    @Override
//    public void sendBroadcast(Intent intent) {
//
//    }
//
//    @Override
//    public void sendBroadcast(Intent intent, @Nullable String receiverPermission) {
//
//    }
//
//    @Override
//    public void sendOrderedBroadcast(Intent intent, @Nullable String receiverPermission) {
//
//    }
//
//    @Override
//    public void sendOrderedBroadcast(@NonNull Intent intent, @Nullable String receiverPermission, @Nullable BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//    }
//
//    @Override
//    public void sendBroadcastAsUser(Intent intent, UserHandle user) {
//
//    }
//
//    @Override
//    public void sendBroadcastAsUser(Intent intent, UserHandle user, @Nullable String receiverPermission) {
//
//    }
//
//    @Override
//    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, @Nullable String receiverPermission, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//    }
//
//    @Override
//    public void sendStickyBroadcast(Intent intent) {
//
//    }
//
//    @Override
//    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//    }
//
//    @Override
//    public void removeStickyBroadcast(Intent intent) {
//
//    }
//
//    @Override
//    public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
//
//    }
//
//    @Override
//    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, @Nullable Handler scheduler, int initialCode, @Nullable String initialData, @Nullable Bundle initialExtras) {
//
//    }
//
//    @Override
//    public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
//
//    }
//
//    @Nullable
//    @Override
//    public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter) {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public Intent registerReceiver(@Nullable BroadcastReceiver receiver, IntentFilter filter, int flags) {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler) {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, @Nullable String broadcastPermission, @Nullable Handler scheduler, int flags) {
//        return null;
//    }
//
//    @Override
//    public void unregisterReceiver(BroadcastReceiver receiver) {
//
//    }
//
//    @Nullable
//    @Override
//    public ComponentName startService(Intent service) {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public ComponentName startForegroundService(Intent service) {
//        return null;
//    }
//
//    @Override
//    public boolean stopService(Intent service) {
//        return false;
//    }
//
//    @Override
//    public boolean bindService(Intent service, @NonNull ServiceConnection conn, int flags) {
//        return false;
//    }
//
//    @Override
//    public void unbindService(@NonNull ServiceConnection conn) {
//
//    }
//
//    @Override
//    public boolean startInstrumentation(@NonNull ComponentName className, @Nullable String profileFile, @Nullable Bundle arguments) {
//        return false;
//    }
//
//    @Nullable
//    @Override
//    public Object getSystemService(@NonNull String name) {
//        return null;
//    }
//
//    @Nullable
//    @Override
//    public String getSystemServiceName(@NonNull Class<?> serviceClass) {
//        return null;
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkPermission(@NonNull String permission, int pid, int uid) {
//        return 0;
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkCallingPermission(@NonNull String permission) {
//        return 0;
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkCallingOrSelfPermission(@NonNull String permission) {
//        return 0;
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkSelfPermission(@NonNull String permission) {
//        return 0;
//    }
//
//    @Override
//    public void enforcePermission(@NonNull String permission, int pid, int uid, @Nullable String message) {
//
//    }
//
//    @Override
//    public void enforceCallingPermission(@NonNull String permission, @Nullable String message) {
//
//    }
//
//    @Override
//    public void enforceCallingOrSelfPermission(@NonNull String permission, @Nullable String message) {
//
//    }
//
//    @Override
//    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
//
//    }
//
//    @Override
//    public void revokeUriPermission(Uri uri, int modeFlags) {
//
//    }
//
//    @Override
//    public void revokeUriPermission(String toPackage, Uri uri, int modeFlags) {
//
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
//        return 0;
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkCallingUriPermission(Uri uri, int modeFlags) {
//        return 0;
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
//        return 0;
//    }
//
//    @SuppressLint("WrongConstant")
//    @Override
//    public int checkUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags) {
//        return 0;
//    }
//
//    @Override
//    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
//
//    }
//
//    @Override
//    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
//
//    }
//
//    @Override
//    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
//
//    }
//
//    @Override
//    public void enforceUriPermission(@Nullable Uri uri, @Nullable String readPermission, @Nullable String writePermission, int pid, int uid, int modeFlags, @Nullable String message) {
//
//    }
//
//    @Override
//    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Context createContextForSplit(String splitName) throws PackageManager.NameNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Context createConfigurationContext(@NonNull Configuration overrideConfiguration) {
//        return null;
//    }
//
//    @Override
//    public Context createDisplayContext(@NonNull Display display) {
//        return null;
//    }
//
//    @Override
//    public Context createDeviceProtectedStorageContext() {
//        return null;
//    }
//
//    @Override
//    public boolean isDeviceProtectedStorage() {
//        return false;
//    }
}