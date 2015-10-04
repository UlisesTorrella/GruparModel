package com.example.ulises.gruparproyect;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Botonera one = new Botonera();
        Propaganda two = new Propaganda();

        //FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FragmentManager fm = getSupportFragmentManager();
        //ft.add(R.id.botonera, one, "botonera");
        //ft.add(R.id.propaganda, two, "propaganda");
        //ft.commit();
        fm.beginTransaction().replace(R.id.botonera, one, "botonera").commit();
        fm.beginTransaction().replace(R.id.propaganda, two, "propaganda").commit();
    }

    public void click(View v){
        Botonera one = new Botonera();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.propaganda, one, "propaganda").commit();
    }

    public void show_botonera(View v){
        Botonera one = new Botonera();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.botonera, one, "botonera").commit();
    }
    public void show_reclamos(View v){
        Reclamos one = new Reclamos();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.botonera, one, "reclamos").commit();
    }
    public void show_progress(View v){
        Progress one = new Progress();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.botonera, one, "progress").commit();
    }
    public void show_ver_saldo(View v){
        DataSheet one = new DataSheet();
        FragmentManager fm = getSupportFragmentManager();

        fm.beginTransaction().replace(R.id.botonera, one, "datasheet").commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void number_1(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString() + "1");
    }
    public void number_2(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"2");
    }
    public void number_3(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"3");
    }
    public void number_4(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"4");
    }
    public void number_5(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"5");
    }
    public void number_6(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"6");
    }
    public void number_7(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"7");
    }
    public void number_8(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"8");
    }
    public void number_9(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"9");
    }
    public void number_0(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText(screen.getText().toString()+"0");
    }
    public void btn_borrar(View v){
        TextView screen= (TextView)findViewById(R.id.statement_dni);
        screen.setText("");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
