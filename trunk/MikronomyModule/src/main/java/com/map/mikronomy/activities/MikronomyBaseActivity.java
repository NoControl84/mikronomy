package com.map.mikronomy.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.map.mikronomy.R;

/**
 * Created by Mikel on 23/07/2014.
 */
public abstract class MikronomyBaseActivity extends ActionBarActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflator = getMenuInflater();
        inflator.inflate(com.map.mikronomy.R.menu.mikronomy_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will

        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        try {
            switch (item.getItemId()) {
                case R.id.ABM_Productos:
                    Intent productoIntent = new Intent(this, ProductosActivity.class);
                    this.startActivity(productoIntent);
                    break;

                case R.id.ABM_CarroCompra:
                    Intent carritoIntent = new Intent(this, CarroCompraActivity.class);
                    this.startActivity(carritoIntent);
                    break;
            }
        } catch(Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
