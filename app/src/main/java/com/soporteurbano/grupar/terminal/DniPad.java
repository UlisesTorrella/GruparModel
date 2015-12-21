package com.soporteurbano.grupar.terminal;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ulises.terminal.R;

import java.util.Map;

/**
 * Created by Ulises on 27/08/2015.
 */
public class DniPad extends Fragment {


    private TextView screen;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button button_clear;
    private Button button_resumen;
    private Button button_saldo;
    private Button button_reclamo;

    private int lockCounter;
    private AsyncTask<String, String, String> currentAsyncTask;
    private boolean isOnline = true;

    private AppContext context;

    private FragmentManager fm;

    private String customerNumber;
    private Map<String, String> customer;

    public DniPad() {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.dni_pad, container, false);
        screen= (TextView)view.findViewById(R.id.statement_dni);
        button1 = (Button) view.findViewById(R.id.dni_1);
        button2 = (Button) view.findViewById(R.id.dni_2);
        button3 = (Button) view.findViewById(R.id.dni_3);
        button4 = (Button) view.findViewById(R.id.dni_4);
        button5 = (Button) view.findViewById(R.id.dni_5);
        button6 = (Button) view.findViewById(R.id.dni_6);
        button7 = (Button) view.findViewById(R.id.dni_7);
        button8 = (Button) view.findViewById(R.id.dni_8);
        button9 = (Button) view.findViewById(R.id.dni_9);
        button0 = (Button) view.findViewById(R.id.dni_0);
        button_clear = (Button) view.findViewById(R.id.dni_clear);
        button_resumen = (Button) view.findViewById(R.id.dni_resumen);
        button_saldo = (Button) view.findViewById(R.id.dni_saldo);
        button_reclamo = (Button) view.findViewById(R.id.dni_reclamo);



        fm = getActivity().getSupportFragmentManager();

        context = (AppContext) getActivity().getApplicationContext();
        context.setIsTimerCanceled(true);

        //isOnline = context.getLocalConfig().isOnline();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("2");            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("3");            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("4");            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("5");            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("6");            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("7");            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("8");            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("9");            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick("0");            }
        });


        button_clear = (Button) view.findViewById(R.id.dni_clear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lockCounter++;
                screen.setText("");
            }
        });


        button_saldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Progress one = new Progress("saldo");

                customerNumber = screen.getText().toString();
                context.setCustomerNumber(customerNumber);
                //setViewSaldo(viewSaldoSaldo);
                if (customerNumber.length() > 0) {
                    if ((customerNumber.equals("2301") || customerNumber.equals("4883")) && lockCounter == 3) {
                        //a configuracion

                        //finish();
                    } else {
                        Log.i("SaldoActivity", "saldo click");
                        waitMeFor(resetDefault);
                        if (isOnline) {
                            //new GetCustomer().execute(customerNumber);

                            fm.beginTransaction().replace(R.id.botonera, one, "progress").commit();

                            //new GetSaldos().execute();
                        } else {
                            //nothing yet

                        }
                    }
                    lockCounter = 0;
                    screen.setText("");
                }
            }
        });


        button_resumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerNumber = screen.getText().toString();
                context.setCustomerNumber(customerNumber);
                if (customerNumber.length() > 0) {
                    if ((customerNumber.equals("2301") || customerNumber.equals("4883")) && lockCounter == 3) {
                        //startActivity(new Intent(context, ConfigActivity.class));
                        //finish();
                    } else {
                        if(isOnline) {
                            Progress one = new Progress("resumen_online");
                            fm.beginTransaction().replace(R.id.botonera, one, "progress").commit();
                        }
                        else {
                            Progress one = new Progress("resumen_offline");
                            fm.beginTransaction().replace(R.id.botonera, one, "progress").commit();
                        }
                    }
                    lockCounter = 0;
                    screen.setText("");
                }
            }
        });
        button_reclamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerNumber = screen.getText().toString();
                context.setCustomerNumber(customerNumber);
                if (customerNumber.length() > 0) {
                    if ((customerNumber.equals("2301") || customerNumber.equals("4883")) && lockCounter == 3) {
                        //startActivity(new Intent(context, ConfigActivity.class));
                        //finish();
                    } else {
                        Form one = new Form();
                        fm.beginTransaction().replace(R.id.botonera, one, "form").commit();
                    }
                    lockCounter = 0;
                    screen.setText("");
                }
            }
        });





        return view;
    }
    public void onButtonClick(String character) {
        waitMeFor(resetDefault);
        screen.setText(screen.getText().toString() + character);
    }

    // Auto reset handling
    long resetDefault = 55;
    long resetCheckEvery = 5000;
    long resetLong = 65;
    long resetShort = 45;
    long resetStatus = 45;
    boolean isOffline = false;

    long nextResetTime = 0;
    private void waitMeFor(long segs) {
        nextResetTime = System.currentTimeMillis() + (segs * 1000);
    }

    private void moveOn() {
        nextResetTime = System.currentTimeMillis();
    }







}