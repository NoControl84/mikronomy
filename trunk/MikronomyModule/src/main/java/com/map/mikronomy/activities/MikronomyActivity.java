package com.map.mikronomy.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.map.mikronomy.modelo.datacontexts.MikronomyDataContext;


public class MikronomyActivity extends MikronomyBaseActivity {

    private MikronomyDataContext mikronomyDataContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(com.map.mikronomy.R.layout.activity_mikronomy);
            mikronomyDataContext = new MikronomyDataContext(this);

        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }



}
