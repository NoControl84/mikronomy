package com.map.mikronomy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.map.mikronomy.exceptions.ExceptionHelper;

import java.util.List;

/**
 * Created by Mikel on 11/08/2014. as
 */
public class StringAdapter extends ArrayAdapter<String>{

    List<String> list;
    Context context;

    public StringAdapter(Context context, List<String> list) {
        super(context, android.R.layout.simple_spinner_dropdown_item, list);
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

            row = getRow(parent, row);

            CharSequence item = getItem(position);

            ((TextView)row).setText(item);

        } catch (Exception e) {
            ExceptionHelper.manage(e);
        }

        return row;
    }

    private View getRow(ViewGroup parent, View row) {
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }
        return row;
    }

}
