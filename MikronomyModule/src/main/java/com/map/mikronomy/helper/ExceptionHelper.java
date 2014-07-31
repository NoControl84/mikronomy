package com.map.mikronomy.helper;

import android.content.Context;
import android.widget.Toast;

public class ExceptionHelper {

    public static void manage(Exception pException) {
        manage(null, pException);
    }

    public static void manage(Context pContext, Exception pException) {
        if (pException != null) {
            pException.printStackTrace();

            if (pContext != null) {
                Toast.makeText(pContext, pException.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
