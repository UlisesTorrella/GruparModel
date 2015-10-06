package com.example.ulises.gruparproyect;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ulises on 27/08/2015.
 */
public class DniPad extends Fragment {


    public DniPad() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.dni_pad, container, false);
        final TextView screen= (TextView)view.findViewById(R.id.statement_dni);
        Button button1 = (Button) view.findViewById(R.id.dni_1);
        Button button2 = (Button) view.findViewById(R.id.dni_2);
        Button button3 = (Button) view.findViewById(R.id.dni_3);
        Button button4 = (Button) view.findViewById(R.id.dni_4);
        Button button5 = (Button) view.findViewById(R.id.dni_5);
        Button button6 = (Button) view.findViewById(R.id.dni_6);
        Button button7 = (Button) view.findViewById(R.id.dni_7);
        Button button8 = (Button) view.findViewById(R.id.dni_8);
        Button button9 = (Button) view.findViewById(R.id.dni_9);
        Button button0 = (Button) view.findViewById(R.id.dni_0);
        Button button_borrar = (Button) view.findViewById(R.id.dni_clear);
        Button button_resumen = (Button) view.findViewById(R.id.dni_resumen);
        Button button_saldo = (Button) view.findViewById(R.id.dni_saldo);
        Button button_reclamo = (Button) view.findViewById(R.id.dni_reclamo);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + "0");
            }
        });
        button_borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
            }
        });
        button_saldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSheet one = new DataSheet();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                //
                //
                //
                fm.beginTransaction().replace(R.id.botonera, one, "datasheet").commit();
            }
        });
        button_resumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSheet one = new DataSheet();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                //
                //
                //
                fm.beginTransaction().replace(R.id.botonera, one, "datasheet").commit();
            }
        });
        button_reclamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Form one = new Form();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                //
                //
                //
                fm.beginTransaction().replace(R.id.botonera, one, "form").commit();
            }
        });





        return view;
    }
}