package com.soporteurbano.grupar.terminal;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import android.util.Log;

public class OMClient implements OM {
    //http://localhost:57789/api/om?i=809022
    private static final String TAG = "OMClient";

    private String url;

    public OMClient () {
        this.url = "http://10.0.2.2/api/om?i=%s";
    }

    public OMClient (String url) {
        this.url = "http://" + url + "/api/om?i=%s";
    }

    public Map<String, String> getCustomerByPan(String pan) {
        Map<String, String> resultData = new HashMap<String, String>();
        try {
            if(pan.length() < 9) {
                pan = "60630100" + pan;
            }
        }
        catch(Exception e)
        {
            resultData.put("error",  e.getMessage());
            Log.e(TAG, "getCustomerByPan", e);
        }
        return resultData;
    }

    public Map<String, String> getCustomerByDni(String dni) {
        Map<String, String> resultData = new HashMap<String, String>();
        try {
            String result = restClientGet(String.format(url, dni));
            Log.i(TAG, result);

            JSONObject resultJson = new JSONObject(result);
            Iterator<?> keys = resultJson.keys();
            while( keys.hasNext() ) {
                String key = (String)keys.next();
                resultData.put(key, resultJson.getString(key));
            }
        }
        catch(Exception e)
        {
            resultData.put("error",  e.getMessage());
            Log.e(TAG, "getCustomerByDni", e);
        }
        return resultData;
    }

    protected String restClientGet(String url) {
        System.out.println(url);
        String response = "";
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, 50000);
        HttpConnectionParams.setSoTimeout(httpParameters, 50000);

        DefaultHttpClient client = new DefaultHttpClient(httpParameters);
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/json");
        try {
            HttpResponse execute = client.execute(httpGet);
            InputStream content = execute.getEntity().getContent();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
            String s = "";
            while ((s = buffer.readLine()) != null) {
                response += s;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}