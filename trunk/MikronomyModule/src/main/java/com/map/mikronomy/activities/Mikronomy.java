package com.map.mikronomy.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.map.mikronomy.R;


public class Mikronomy extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.map.mikronomy.R.layout.activity_mikronomy);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(com.map.mikronomy.R.menu.mikronomy_main_menu, menu);
        return super.onCreateOptionsMenu(menu);

        //getMenuInflater().inflate(com.map.mikronomy.R.menu.mikronomy_main_menu, menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will

        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.ABM_Productos) {
            return true;
        }
        if (id == R.id.ABM_CarroCompra) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}