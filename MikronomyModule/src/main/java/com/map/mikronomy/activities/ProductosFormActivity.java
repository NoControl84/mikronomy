package com.map.mikronomy.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.map.mikronomy.R;
import com.map.mikronomy.helper.ExceptionHelper;
import com.map.mikronomy.modelo.datacontexts.MikronomyDataContext;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.map.mikronomy.modelo.helpers.DBHelper;
import com.map.mikronomy.modelo.setters.TiendaObjectSet;
import com.mobandme.ada.ObjectSet;
import com.mobandme.ada.exceptions.AdaFrameworkException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductosFormActivity extends MikronomyBaseActivity {

    private MikronomyDataContext mikronomyDataContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_productos_form);

            List<String> listaTienda = getListNameTienda();
            ArrayAdapter<String> tiendaArrayAdapter = getArrayAdapter(android.R.layout.simple_spinner_dropdown_item, listaTienda);
            Spinner tiendaSpinner = (Spinner)findViewById(R.id.SPI_Tienda);
            tiendaSpinner.setAdapter(tiendaArrayAdapter);

            Spinner seccionSpinner = getSimpleDropdownSpinnerByID(R.id.SPI_Secciones, R.array.seccion_array);
            Spinner unidadMedidaSpinner = getSimpleDropdownSpinnerByID(R.id.SPI_UdMedida, R.array.medida_array);


            //ArrayAdapter<String> tiendaArrayAdapter = getArrayAdapter(android.R.layout.simple_spinner_dropdown_item);
            //Spinner tiendaSpinner =
        } catch (Exception e) {
            ExceptionHelper.manage(this, e);
        }
    }

    private List<String> getListNameTienda() throws AdaFrameworkException {
        List<Tienda> tiendaList;
        List<String> listaNombresTienda = new ArrayList<String>();

        mikronomyDataContext = MikronomyDataContext.getInstance(this);
        ObjectSet<Tienda> tiendaSet =  mikronomyDataContext.tiendaEntitySet;

        tiendaList = tiendaSet.search(true, null, null, Tienda.COL_NOMBRE_TIENDA, null, null, null, null);

        for (Tienda tienda : tiendaList) {
            listaNombresTienda.add(tienda.getNombreTienda());
        }

        return listaNombresTienda;
    }

    private Spinner getSimpleDropdownSpinnerByID(int spinnerID, int resArrayID) {
        // Create an ArrayAdapter using the string array and a default spinner layout
        Spinner spinner = (Spinner) findViewById(spinnerID);
        ArrayAdapter<CharSequence> seccionAdapter = ArrayAdapter.createFromResource(this,
                resArrayID, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        //seccionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(seccionAdapter);

        return spinner;
    }

    private ArrayAdapter<CharSequence> getArrayAdapter(int spinnerItemTypeID, int resArrayID) {
        ArrayAdapter<CharSequence> arrayAdapter =
                ArrayAdapter.createFromResource(this, resArrayID, spinnerItemTypeID);
        return arrayAdapter;
    }

    private  ArrayAdapter<String> getArrayAdapter (int spinnerItemTypeID, List<String> list) {
        ArrayAdapter<String> arrayAdapter =
            new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        return arrayAdapter;
    }


}
