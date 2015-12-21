package com.soporteurbano.grupar.terminal;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.*;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.ulises.terminal.R;

public class AppContext extends Application {

    //private boolean isConfigLoaded = false;

    private LocalConfig localConfig;
    public LocalConfig getLocalConfig() {
        if (null == localConfig) {
            SharedPreferences settings = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE );
            localConfig = new LocalConfig(settings.getString("LocalConfig", "{}"));
            saveLocalConfig();
        }
        return localConfig;
    }
    public void saveLocalConfig() {
        if (null == localConfig) {
            localConfig = new LocalConfig("{}");
        }
        SharedPreferences settings = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE );
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("LocalConfig", localConfig.getJSON().toString());
        editor.commit();
    }

    public int getVersion() {
        int v = 0;
        try {
            v = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            // Huh? Really?
        }
        return v;
    }

    static String join(Collection<?> s, String delimiter) {
        StringBuilder builder = new StringBuilder();
        Iterator<?> iter = s.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (!iter.hasNext()) {
                break;
            }
            builder.append(delimiter);
        }
        return builder.toString();
    }

    private String customerNumber;
    public String getCustomerNumber(){
        return customerNumber;
    }

    public void setCustomerNumber(String number){
        customerNumber = number;
    }

    private boolean isConnected;
    public boolean isConnected() {
        return isConnected;
        //return false;
    }
    public void setConnected(boolean newStatus) {
        this.isConnected = newStatus;
    }

    public boolean hasTelephony() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
    }

    public boolean hasNetwork() {
        ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return (activeNetwork != null);
    }


    OM omClient = null;
    public OM getOM() {
        if(omClient == null) {
            if(getLocalConfig().getServertype().equalsIgnoreCase("web")) {
                omClient = new OMClient(getLocalConfig().getRemoteDb());
            }
            else {
                String driver = getLocalConfig().getDriver();
                String userName = getLocalConfig().getUserName();
                String password = getLocalConfig().getPassword();
                String url = getLocalConfig().getConn();
                omClient = new OMClient(getLocalConfig().getRemoteDb());
            }
        }
        return omClient;
    }
    public OM getNewOM() {
        omClient = null;
        return getOM();
    }


    private boolean isTimerCanceled = false;

    public void setIsTimerCanceled(boolean a){
        isTimerCanceled = a;
    }
    public boolean getIsTimerCanceled(){
        return isTimerCanceled;
    }

    public void waitforme(FragmentManager fm){
        final FragmentManager fragmentmanager = fm;
        setIsTimerCanceled(false);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(!getIsTimerCanceled()){
                    DniPad one = new DniPad();
                    fragmentmanager.beginTransaction().replace(R.id.botonera, one, "dni_pad").commit();
                }
                else{
                    setIsTimerCanceled(false);
                }
            }
        }, 5000);
    }

}