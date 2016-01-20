package com.soporteurbano.grupar.terminal;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ulises.terminal.R;

import java.util.Map;

/**
 * Created by Ulises on 21/12/2015.
 */
public class Error extends Fragment {


    private FragmentManager fm;
    AppContext context;
    private  Map<String, String> customer;
    private String mssg = "";

    public Error(Map<String, String> client) {
        customer = client;
    }
    public Error() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.error, container, false);
        context = (AppContext) getActivity().getApplicationContext();
        fm = getActivity().getSupportFragmentManager();
        mssg = customer.get("error");
        Button back = (Button) view.findViewById(R.id.error_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DniPad one = new DniPad();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.botonera, one, "dni_pad").commit();
            }
        });
        context.waitforme(fm);
        return view;
    }





}
