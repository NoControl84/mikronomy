package com.map.mikronomy.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.map.mikronomy.R;

public class ProductosFormActivity extends MikronomyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_form);

        Spinner seccionSpinner = getSimpleDropdownSpinnerByID(R.id.SPI_Secciones, R.array.seccion_array);
        Spinner unidadMedidaSpinner = getSimpleDropdownSpinnerByID (R.id.SPI_UdMedida, R.array.medida_array);

    }

    private Spinner getSimpleDropdownSpinnerByID(int spinnerID, int resArrayID) {
        // Create an ArrayAdapter using the string array and a default spinner layout
        Spinner spinner = (Spinner) findViewById(spinnerID);
        ArrayAdapter<CharSequence> seccionAdapter = ArrayAdapter.createFromResource(this,
                resArrayID, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        seccionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(seccionAdapter);

        return spinner;
    }


}
