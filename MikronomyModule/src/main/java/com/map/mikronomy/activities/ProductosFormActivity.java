package com.map.mikronomy.activities;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

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

    private List<String> getListNameTienda() throws AdaFrameworkException {
        List<Tienda> tiendaList;
        List<String> listaNombresTienda = new ArrayList<>();

        mikronomyDataContext = MikronomyDataContext.getInstance(this);
        ObjectSet<Tienda> tiendaSet =  mikronomyDataContext.tiendaEntitySet;

        tiendaList = tiendaSet.search(true, null, null, Tienda.COL_NOMBRE_TIENDA, null, null, null, null);

        for (Tienda tienda : tiendaList) {
            listaNombresTienda.add(tienda.toString());
        }

        return listaNombresTienda;
    }

    private void createSpinnerWithAdapter(List<String> itemList, int spinnerID) {
        CustomSpinnerAdapter adapter =
                CustomSpinnerAdapter.getSpinnerAdapter(this, itemList);
        Spinner spinner = (Spinner)findViewById(spinnerID);
        spinner.setAdapter(adapter);

    }



    public void onClick(View view) {
        try {
            if (view != null) {
               switch (view.getId()){
                   case R.id.BUT_AddTienda:
                       showNoticeDialog();
                       break;
               }

            }
        } catch (Exception e) {
            ExceptionHelper.manage(this, e);
        }
    }

    public void showNoticeDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new TiendaDialogFragment();
        dialog.show(getSupportFragmentManager(), "TiendaDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String nombreTienda) {
        Tienda tienda = null;
        if (nombreTienda != null) {
            try {
                tienda = new Tienda(nombreTienda);
                if (tienda.toString() != null && !tienda.toString().trim().isEmpty()) {
                    Spinner tiendaSpinner = (Spinner) this.findViewById(R.id.SPI_Tienda);
                    CustomSpinnerAdapter spinnerAdapter = (CustomSpinnerAdapter) tiendaSpinner.getAdapter();

                    ArrayList<CharSequence> listaTiendas = new ArrayList<>(spinnerAdapter.getList());
                    listaTiendas.add(tienda.toString());

                    spinnerAdapter = new CustomSpinnerAdapter(this, listaTiendas);
                    tiendaSpinner.setAdapter(spinnerAdapter);
                    spinnerAdapter.notifyDataSetChanged();

                    mikronomyDataContext.tiendaEntitySet.add(tienda);
                    mikronomyDataContext.tiendaEntitySet.save();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
    }
}
