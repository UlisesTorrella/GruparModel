package com.soporteurbano.grupar.terminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import android.util.Log;

public class JSONFile {
    private static final String TAG = "JSONFile";

    public static JSONObject Read(String path) throws IOException {
        JSONObject result = new JSONObject();
        File file = new File(path);
        file.createNewFile();

        String content = "";
        try {
            FileReader inputFile = new FileReader(path);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line;
            while ((line = bufferReader.readLine()) != null)   {
                content += line;
            }
            bufferReader.close();

            result = new JSONObject(content);
        }
        catch(Exception e){
            Log.e(TAG, e.getMessage());
        }
        return result;
    }

    public static void Write(String path, JSONObject data) throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write(data.toString());
        fw.close();
    }

    public static void WritePartial(String path, JSONObject data) throws IOException {
        boolean isFirst = false;
        File file = new File(path);
        isFirst = file.createNewFile();

        FileWriter fw = new FileWriter(path, true);
        if(!isFirst) {
            fw.write(",\n");
        }
        fw.write(data.toString());
        fw.close();
    }

}
