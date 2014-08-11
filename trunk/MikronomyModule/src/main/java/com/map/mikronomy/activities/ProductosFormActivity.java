package com.map.mikronomy.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.map.mikronomy.R;
import com.map.mikronomy.adapters.CustomSpinnerAdapter;
import com.map.mikronomy.exception.ExceptionHelper;
import com.map.mikronomy.modelo.datacontexts.MikronomyDataContext;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.mobandme.ada.ObjectSet;
import com.mobandme.ada.exceptions.AdaFrameworkException;

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
            List<String> listaSeccion = Arrays.asList(getResources().getStringArray(R.array.seccion_array));
            List<String> listaUdMedida = Arrays.asList(getResources().getStringArray(R.array.medida_array));

            Spinner tiendaSpinner = getSpinnerWithAdapter(listaTienda, R.id.SPI_Tienda);
            Spinner seccionSpinner = getSpinnerWithAdapter(listaSeccion, R.id.SPI_Secciones);
            Spinner udMedidaSpinner = getSpinnerWithAdapter(listaUdMedida, R.id.SPI_UdMedida);


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

    private Spinner getSpinnerWithAdapter(List<String> itemList, int spinnerID) {
        CustomSpinnerAdapter adapter =
                CustomSpinnerAdapter.getSpinnerAdapter(this, itemList);
        Spinner spinner = (Spinner)findViewById(spinnerID);
        spinner.setAdapter(adapter);

        return spinner;
    }


}
