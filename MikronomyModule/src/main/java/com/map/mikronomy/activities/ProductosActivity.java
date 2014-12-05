package com.map.mikronomy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.map.mikronomy.R;

public class ProductosActivity extends MikronomyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
    }

    public void onClick(View pView) {
        try{
            if (pView != null) {
                switch (pView.getId()) {
                    case R.id.BUT_FormProducto:
                        Intent formularioProductoIntent = new Intent(this, ProductosFormActivity.class);
                        this.startActivity(formularioProductoIntent);
                        break;

                }
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}
