package com.soporteurbano.grupar.terminal;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ulises.terminal.R;

import java.util.Map;

/**
 * Created by Ulises on 29/08/2015.
 */
public class Progress extends Fragment {


    private FragmentManager fm;
    private OM client;
    AppContext context;
    private String customerNumber;
    private Map<String, String> customer;
    String operation;

    public Progress(String type) {
        operation = type;
    }
    public Progress() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.progress, container, false);
        context = (AppContext) getActivity().getApplicationContext();
        customerNumber = context.getCustomerNumber();
        client = context.getNewOM();
        fm = getActivity().getSupportFragmentManager();
        new GetSaldos().execute();
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
        {   if(!customer.containsKey("error")) {
                DataSheet one = new DataSheet(customer, operation);
                fm.beginTransaction().replace(R.id.botonera, one, "datasheet").commit();
            }
            else{
                Error one = new Error(customer);
                fm.beginTransaction().replace(R.id.botonera, one, "datasheet").commit();
            }

        }
    }










    //
    //
    //
    //
    //


    ///
    //
    //
    //
    //



}
