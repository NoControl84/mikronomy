package com.map.mikronomy.modelo.helpers;

import android.content.Context;

import com.map.mikronomy.helper.ExceptionHelper;
import com.map.mikronomy.modelo.entidades.Tienda;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikel on 31/07/2014.
 */
public class TiendaLoaderHelper {
    public static List<Tienda> getList(Context pContext) {
        List<Tienda> tiendaList = new ArrayList<Tienda>();

        try {
            String data = null;

            if (pContext != null) {

                InputStream input = pContext.getAssets().open("tiendas.json");
                if (input != null) {

                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    if (reader != null) {
                        data =  reader.readLine();
                        reader.close();
                    }

                    input.close();
                }

                if (data != null && !data.trim().equals("")) {
                    JSONArray dataParser = new JSONArray(data);
                    if (dataParser != null && dataParser.length() > 0) {
                        for (int index = 0; index < dataParser.length(); index++) {
                            tiendaList.add(new Tienda(dataParser.getString(index)));
                        }
                    }
                }
            }

        } catch (Exception e) {
            ExceptionHelper.manage(e);
        }

        return tiendaList;
    }
}
