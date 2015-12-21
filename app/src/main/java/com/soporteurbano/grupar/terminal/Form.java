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
 * Created by Ulises on 03/10/2015.
 */
public class Form extends Fragment {


    private FragmentManager fm;
    private OM client;
    AppContext context;
    private String customerNumber;
    private Map<String, String> customer;
    String operation;
    TextView name;

    public Form() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.form, container, false);


        context = (AppContext) getActivity().getApplicationContext();
        customerNumber = context.getCustomerNumber();
        client = context.getNewOM();
        fm = getActivity().getSupportFragmentManager();
        name = (TextView) view.findViewById(R.id.reclamo_name);
        new GetSaldos().execute();
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



    public class GetSaldos extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... arg0) {
            Map<String, String> result = client.getCustomerByDni(customerNumber);
            customer = result;

            String counterNote = "ok";
            if(customer.size() == 0) {
                customer.put("error", "getCustomerByDni failed");
            }

            return null;
        }

        @Override
        protected void onPostExecute(String arg0)
        {
            if(!customer.containsKey("error")) {
            name.setText(customer.get("name"));
        }
        else{

        }

        }
    }

}
