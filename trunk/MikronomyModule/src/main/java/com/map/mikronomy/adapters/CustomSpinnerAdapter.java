package com.map.mikronomy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.map.mikronomy.exceptions.ExceptionHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mikel on 11/08/2014. as
 */
public class CustomSpinnerAdapter extends ArrayAdapter<CharSequence>{

    List<CharSequence> list;
    Context context;

    public List<CharSequence> getList() {
        return list;
    }

    public CustomSpinnerAdapter(Context context, List<CharSequence> list) {
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

            CharSequence item = getItem(position);

            ((TextView)row).setText(item);

        } catch (Exception e) {
            ExceptionHelper.manage(e);
        }

        return row;
    }

    public static CustomSpinnerAdapter getSpinnerAdapter(Context context, List<String> list) {
        List<CharSequence> csList = new ArrayList<>();

        if (list != null) {
            CharSequence[] csArray = list.toArray(new CharSequence[list.size()]);
            csList = Arrays.asList(csArray);
        }
        return new CustomSpinnerAdapter(context, csList);
    }

}
