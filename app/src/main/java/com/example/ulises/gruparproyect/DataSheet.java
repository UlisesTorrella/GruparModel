package com.example.ulises.gruparproyect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ulises on 29/08/2015.
 */
public class DataSheet extends Fragment {


    public DataSheet() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.data_sheet, container, false);

        Button button_back = (Button) view.findViewById(R.id.datasheet_button_back);
        Button button_print = (Button) view.findViewById(R.id.datasheet_button_print);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DniPad one = new DniPad();
                FragmentManager fm = getActivity().getSupportFragmentManager();

                fm.beginTransaction().replace(R.id.botonera, one, "dni_pad").commit();
            }
        });
        button_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DniPad one = new DniPad();
                FragmentManager fm = getActivity().getSupportFragmentManager();

                fm.beginTransaction().replace(R.id.botonera, one, "dni_pad").commit();
            }
        });
        return view;
    }
}