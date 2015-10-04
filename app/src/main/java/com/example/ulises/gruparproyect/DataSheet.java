package com.example.ulises.gruparproyect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ulises on 29/08/2015.
 */
public class DataSheet extends Fragment {


    public DataSheet() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.ver_saldo, container, false);
        return view;
    }
}
