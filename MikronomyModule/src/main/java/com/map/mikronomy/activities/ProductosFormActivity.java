package com.map.mikronomy.activities;

import android.app.DialogFragment;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.map.mikronomy.R;
import com.map.mikronomy.adapters.CustomSpinnerAdapter;
import com.map.mikronomy.exceptions.ExceptionHelper;
import com.map.mikronomy.fragments.TiendaDialogFragment;
import com.map.mikronomy.modelo.datacontexts.MikronomyDataContext;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.mobandme.ada.ObjectSet;
import com.mobandme.ada.exceptions.AdaFrameworkException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductosFormActivity extends MikronomyBaseActivity implements TiendaDialogFragment.TiendaDialogListener{

    private MikronomyDataContext mikronomyDataContext;
    TiendaDialogFragment tiendaPopUp;
    private SparseArray<Spinner> mappedSpinners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            tiendaPopUp = tiendaPopUp == null ? new TiendaDialogFragment() : this.tiendaPopUp;

            setContentView(R.layout.activity_productos_form);

            List<String> listaTienda = getListNameTienda();
            List<String> listaSeccion = Arrays.asList(getResources().getStringArray(R.array.seccion_array));
            List<String> listaUdMedida = Arrays.asList(getResources().getStringArray(R.array.medida_array));

            createSpinnerWithAdapter(listaTienda, R.id.SPI_Tienda);
            createSpinnerWithAdapter(listaSeccion, R.id.SPI_Secciones);
            createSpinnerWithAdapter(listaUdMedida, R.id.SPI_UdMedida);

        } catch (Exception e) {
            ExceptionHelper.manage(this, e);
        }
    }

    public void onClick(View view) {
        try {
            if (view != null) {
               switch (view.getId()){
                   case R.id.BUT_AddTienda:
                       tiendaPopUp.show(getFragmentManager(), "Añada el nombre de la tienda");
                       break;
               }

            }
        } catch (Exception e) {
            ExceptionHelper.manage(this, e);
        }
    }

    private List<String> getListNameTienda() throws AdaFrameworkException {
        List<Tienda> tiendaList;
        List<String> listaNombresTienda = new ArrayList<>();

        mikronomyDataContext = MikronomyDataContext.getInstance(this);
        ObjectSet<Tienda> tiendaSet =  mikronomyDataContext.tiendaEntitySet;

        tiendaList = tiendaSet.search(true, null, null, Tienda.COL_NOMBRE_TIENDA, null, null, null, null);

        for (Tienda tienda : tiendaList) {
            listaNombresTienda.add(tienda.getNombreTienda());
        }

        return listaNombresTienda;
    }

    private void createSpinnerWithAdapter(List<String> itemList, int spinnerID) {
        CustomSpinnerAdapter adapter =
                CustomSpinnerAdapter.getSpinnerAdapter(this, itemList);
        Spinner spinner = (Spinner)findViewById(spinnerID);
        spinner.setAdapter(adapter);

        //registerAdapter(spinnerID, spinner);
    }

    private void registerAdapter(int spinnerID, Spinner spinner) {
        if (mappedSpinners == null)
            mappedSpinners = new SparseArray<>();

        mappedSpinners.put(spinnerID, spinner);
    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}
