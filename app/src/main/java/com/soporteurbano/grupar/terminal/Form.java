package com.soporteurbano.grupar.terminal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ulises.terminal.R;

/**
 * Created by Ulises on 03/10/2015.
 */
public class Form extends Fragment {
    public Form() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.form, container, false);
        Button back = (Button)view.findViewById(R.id.button_form_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DniPad one = new DniPad();
                FragmentManager fm = getActivity().getSupportFragmentManager();

                fm.beginTransaction().replace(R.id.botonera, one, "dni_pad").commit();
            }
        });
        Button print = (Button)view.findViewById(R.id.button_form_send);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DniPad one = new DniPad();
                FragmentManager fm = getActivity().getSupportFragmentManager();

                fm.beginTransaction().replace(R.id.botonera, one, "dni_pad").commit();
                /////////////////COSOSOOSOSOSOSSO
            }
        });
        return view;
    }

}
