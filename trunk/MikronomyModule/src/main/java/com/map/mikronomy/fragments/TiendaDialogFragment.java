package com.map.mikronomy.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.map.mikronomy.R;


public class TiendaDialogFragment extends DialogFragment {

    public interface TiendaDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, String nombreTienda);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    EditText editTextTienda;

    TiendaDialogListener mListener;

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
                            editTextTienda = (EditText) dialogView.findViewById(R.id.TXT_Tienda);
                            String nombreTienda = editTextTienda.getText().toString().trim();
                            mListener.onDialogPositiveClick(TiendaDialogFragment.this,  nombreTienda);

                        }
                    })
                    .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //TiendaDialogFragment.this.getDialog().cancel();
                            mListener.onDialogNegativeClick(TiendaDialogFragment.this);
                        }
                    });
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener =  (TiendaDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }


}
