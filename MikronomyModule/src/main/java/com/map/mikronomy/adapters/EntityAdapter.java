package com.map.mikronomy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.map.mikronomy.exceptions.ExceptionHelper;
import com.mobandme.ada.Entity;

import java.util.List;

/**
 * Created by Mikel on 11/08/2014.
 */
public class EntityAdapter extends ArrayAdapter<Entity>{

    List<? extends Entity> list;
    Context context;

    public List<? extends Entity> getList() {
        return list;
    }

    @SuppressWarnings("unchecked")
    public EntityAdapter(Context context, List<? extends Entity> list) {
        super(context, android.R.layout.simple_spinner_dropdown_item, (List<Entity>) list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {   // Ordinary view in Spinner, we use android.R.layout.simple_spinner_item
        return super.getView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {   // This view starts when we click the spinner.
        View row = convertView;

        try {

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
            }

            Entity item = getItem(position);

            ((TextView)row).setText(item.toString());

        } catch (Exception e) {
            ExceptionHelper.manage(e);
        }

        return row;
    }



}
