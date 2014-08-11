package com.map.mikronomy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.map.mikronomy.R;
import com.map.mikronomy.helper.ExceptionHelper;

import java.util.List;

import static android.R.layout.simple_spinner_dropdown_item;

/**
 * Created by Mikel on 11/08/2014.
 */
public class SpinnerAdapter extends ArrayAdapter<String>{

    List<String> list;
    Context context;

    public SpinnerAdapter(Context context, List<String> list) {
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

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
            }

            String item = getItem(position);

            ((TextView)row).setText(item);

        } catch (Exception e) {
            ExceptionHelper.manage(e);
        }

        return row;
    }

    public static SpinnerAdapter getSpinnerAdapter(Context context, List<String> list) {
        SpinnerAdapter adapter = new SpinnerAdapter(context, list);

        return adapter;
    }


}
