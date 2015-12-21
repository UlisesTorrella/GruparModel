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
 * Created by Ulises on 29/08/2015.
 */
public class DataSheet extends Fragment {



    private TextView saldo_name;
    private TextView data1;
    private TextView data2;
    private TextView data3;
    private TextView data4;

    private TextView tag1;
    private TextView tag2;
    private TextView tag3;
    private TextView tag4;

    private AppContext context;
    private FragmentManager fm;

    private TextView saldo_message;
    private String operation;
    private  Map<String, String> customer;

    public DataSheet( Map<String, String> client, String type) {
        customer = client;
        operation = type;
    }
    public DataSheet( ) {
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

        //text views to show the data
        saldo_name = (TextView) view.findViewById(R.id.DataName);
        data1 = (TextView) view.findViewById(R.id.Data1);
        data2 = (TextView) view.findViewById(R.id.Data2);
        data3 = (TextView) view.findViewById(R.id.Data3);
        data4 = (TextView) view.findViewById(R.id.Data4);

        //text view to tag the data
        tag1 = (TextView) view.findViewById(R.id.DataTag1);
        tag2 = (TextView) view.findViewById(R.id.DataTag2);
        tag3 = (TextView) view.findViewById(R.id.DataTag3);
        tag4 = (TextView) view.findViewById(R.id.DataTag4);

        switch(operation) {
            case "saldo":
                saldo_name.setText(customer.get("name"));
                tag1.setText("LimiteComprasMensual");
                data1.setText(customer.get("LimiteComprasMensual"));
                tag2.setText("LimiteComprasTotal");
                data2.setText(customer.get("LimiteComprasTotal")); // customer.get("LimiteComprasTotal")
                tag3.setText("DisponibleMensual");
                data3.setText(customer.get("DisponibleMensual"));
                tag4.setText("DisponibleTotal");
                data4.setText(customer.get("DisponibleTotal")); // customer.get("DisponibleTotal")
                break;
            case "resumen_online":
                saldo_name.setText(customer.get("name"));
                tag1.setText("FechaVencimiento");
                String dueDate = customer.get("FechaVencimiento1").substring(0, 10);
                data1.setText(dueDate );
                tag2.setText("ImporteVencimiento");
                data2.setText(customer.get("ImporteVencimiento1"));
                tag3.setText("ImportePagoMinimo");
                data3.setText(customer.get("ImportePagoMinimo"));
                tag4.setVisibility(View.INVISIBLE);
                data4.setVisibility(View.INVISIBLE);
                break;
            case "resumen_offline":
                break;
            default:
                break;
        }

        context = (AppContext) getActivity().getApplicationContext();
        fm = getActivity().getSupportFragmentManager();
        context.waitforme(fm);


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
