package com.soporteurbano.grupar.terminal;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Build;
import android.os.Environment;
import android.util.Log;

public class LocalConfig {
    private static final String TAG = "LocalConfig";

    private JSONObject data;

    JSONObject getJSON() {
        return data;
    }

    public LocalConfig(String data) {
        try {
            this.data = new JSONObject(data);
            setMissing();
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public LocalConfig(JSONObject data) {
        this.data = data;
        setMissing();
    }

    public String getPath() {
        return getString("path");
    }
    public void setPath(String value) {
        set("path", value);
    }

    public String getPathVideo() {
        return getString("pathVideo");
    }
    public void setPathVideo(String value) {
        set("pathVideo", value);
    }

    public Boolean isOnline() {
        return is("isOnline");
    }
    public void setIsOnline(Boolean value) {
        set("isOnline", value);
    }

    public Boolean isSaldo() {
        return is("isSaldo");
    }
    public void setIsSaldo(Boolean value) {
        set("isSaldo", value);
    }

    public Boolean isResumen() {
        return is("isResumen");
    }
    public void setIsResumen(Boolean value) {
        set("isResumen", value);
    }

    public String getPrinterIp() {
        return getString("printerIp");
    }
    public void setPrinterIp(String value) {
        set("printerIp", value);
    }

    public String getAsk() {
        return getString("ask");
    }
    public void setAsk(String value) {
        set("ask", value);
    }

    public String getRemotePath() {
        return getString("remotePath");
    }
    public void setRemotePath(String value) {
        set("remotePath", value);
    }

    public String getRemoteDb() {
        return getString("remoteDb");
    }
    public void setRemoteDb(String value) {
        set("remoteDb", value);
    }

    public String getDeviceOwnName() {
        return getString("deviceOwnName");
    }
    public void setDeviceOwnName(String value) {
        set("deviceOwnName", value);
    }


    private String getString(String field) {
        String result = "";
        try {
            if(data.has(field)) {
                result = data.getString(field);
            }
            else {
                return "";
            }
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }
        return result;
    }
    private void set(String field, Object value) {
        try {
            this.data.put(field, value);
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private boolean is(String field) {
        boolean result = false;
        try {
            result = data.getBoolean(field);
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }
        return result;
    }

    private void setMissing() {
        if(!data.has("deviceName")) {
            set("deviceName", getDeviceName() );
        }
        if(!data.has("deviceOwnName")) {
            set("deviceOwnName", getDeviceName() );
        }
        if(!data.has("path")) {
            set("path", Environment.getExternalStorageDirectory().getAbsolutePath()+"/Grupar" );
            //String tempDir = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Grupar";
            //String internalDir = Environment.getDataDirectory().getAbsolutePath()+"/Grupar";
        }
        if(!data.has("pathVideo")) {
            set("pathVideo", Environment.getExternalStorageDirectory().getAbsolutePath()+"/Video" );
        }
        if(!data.has("isResumen")) {
            set("isResumen", true);
        }
        if(!data.has("isSaldo")) {
            set("isSaldo", true);
        }
        if(!data.has("isOnline")) {
            set("isOnline", true);
        }
        if(!data.has("printerIp")) {
            set("printerIp", "192.168.2.30");
        }
        if(!data.has("remotePath")) {
            set("remotePath", "http://186.125.171.82:81/resumenesweb/Grupar");
        }
        if(!data.has("remoteDb")) {
            set("remoteDb", "190.225.247.215:82");
        }
        if(!data.has("ask")) {
            set("ask", "phone");
        }
        if(!data.has("fileType")) {
            set("fileType", "pdf");
        }
        if(!data.has("serverType")) {
            set("serverType", "sql");
        }
        if(!data.has("endDate")) {
            set("endDate", "20");
        }
    }

    private String[] asks = new String[] { "phone", "recepcion" };
    public String[] getAsks() {
        return asks;
    }

    public String getConn() {
        String result = "jdbc:sqlserver://[0];databaseName=TarjetasOM_DB;encrypt=false;".replace("[0]", getRemoteDb());
        return result;
    }

    public String getDownloadPath() {
        String remotePath = getString("remotePath");
        if(!remotePath.endsWith("/")) {
            remotePath = remotePath +"/";
        }
        return remotePath + "pdf_%s_1." + getFiletype();
    }

    public String getDriver() {
        return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    }

    public String getUserName() {
        return "arturito";
    }

    public String getPassword() {
        return "SoporteUrbano4883";
    }

    private String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return model;
        } else {
            return manufacturer + " " + model;
        }
    }

    private String[] filetypes = new String[] { "pdf", "pcl" };
    public String[] getFiletypes() {
        return filetypes;
    }

    public String getFiletype() {
        return getString("fileType");
    }
    public void setFiletype(String value) {
        set("fileType", value);
    }

    public String getEndDate() {
        return getString("endDate");
    }
    public void setEndDate(String value) {
        set("endDate", value);
    }

    private String[] servertypes = new String[] { "sql", "web" };
    public String[] getServertypes() {
        return servertypes;
    }

    public String getServertype() {
        return getString("serverType");
    }
    public void setServertype(String value) {
        set("serverType", value);
    }


}