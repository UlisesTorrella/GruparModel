package com.example.ulises.gruparproyect;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Ulises on 29/08/2015.
 */
public class DataSheet extends Fragment {


    public DataSheet() {

    }
    Wait wait_task;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.data_sheet, container, false);

        Button button_back = (Button) view.findViewById(R.id.datasheet_button_back);
        Button button_print = (Button) view.findViewById(R.id.datasheet_button_print);
        wait_task = new Wait();
        wait_task.execute("");
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
                goToDni();
            }
        });
        return view;
    }

    public void goToDni(){
        wait_task.validez=false;
        DniPad one = new DniPad();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.botonera, one, "dni_pad").commit();
    }

    private class Wait extends AsyncTask<String, Integer, Long> {

        //Esta variable sirve para verificar si el cliente no salio por su cuenta de datasheet y no ejecutar goToDni()
        boolean validez;
        protected Long doInBackground(String... urls) {
            Long a= 00l;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return a;
        }

        protected void onPostExecute(Long result) {
            if(validez==true){
                goToDni();
            }

        }
    }
}
