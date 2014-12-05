package com.map.mikronomy.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.map.mikronomy.R;
import com.map.mikronomy.exceptions.ExceptionHelper;
import com.map.mikronomy.modelo.datacontexts.MikronomyDataContext;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.map.mikronomy.modelo.setters.TiendaObjectSet;
import com.mobandme.ada.ObjectSet;

import java.util.List;


public class TiendaPopUpFragment extends DialogFragment {
    EditText editTextTienda;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            // Get the layout inflater
            LayoutInflater inflater = getActivity().getLayoutInflater();

            final View dialogView = inflater.inflate(R.layout.popup_add_tienda, null);

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(dialogView)
                    // Add action buttons
                    .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            try {
                                //Añadir tienda
                                MikronomyDataContext dataContext = MikronomyDataContext.getInstance(getActivity().getBaseContext());
                                Tienda tienda = new Tienda();

                                editTextTienda = (EditText) dialogView.findViewById(R.id.TXT_Tienda);
                                tienda.setNombreTienda(editTextTienda.getText().toString());

                                if (tienda.getNombreTienda() != null && !tienda.getNombreTienda().trim().isEmpty()) {
                                    dataContext.tiendaEntitySet.add(tienda);
                                    dataContext.tiendaEntitySet.save();

                                }


                            } catch (Exception e) {
                                ExceptionHelper.manage(e);
                            }
                        }
                    })
                    .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            TiendaPopUpFragment.this.getDialog().cancel();
                        }
                    });
        return builder.create();
    }

}
