package com.map.mikronomy.modelo.datacontexts;

import android.content.Context;
import android.os.Environment;

import com.map.mikronomy.helper.ExceptionHelper;
import com.map.mikronomy.modelo.entidades.Seccion;
import com.map.mikronomy.modelo.entidades.Marca;
import com.map.mikronomy.modelo.entidades.Producto;
import com.map.mikronomy.modelo.entidades.ProductoTienda;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.mobandme.ada.ObjectContext;
import com.mobandme.ada.ObjectSet;
import com.mobandme.ada.exceptions.AdaFrameworkException;


import java.io.File;

public class MikronomyDataContext extends ObjectContext{

    final static String DATABASE_FOLDER  = "%s/Mikronomy/DB";
    final static String DATABASE_NAME    = "MikronomyDB.db";
    final static int    DATABASE_VERSION = 1;

    public ObjectSet<Marca> marcaEntitySet;
    public ObjectSet<Seccion> seccionEntitySet;
    public ObjectSet<Producto> productoEntitySet;
    public ObjectSet<Tienda> tiendaEntitySet;
    public ObjectSet<ProductoTienda> productoTiendaEntitySet;

    public MikronomyDataContext(Context pContext) throws AdaFrameworkException {
        super(pContext, String.format("%s%s", getDataBaseFolder(), DATABASE_NAME), DATABASE_VERSION);

        inicializarContexto();
    }

    private void inicializarContexto() throws AdaFrameworkException {
        marcaEntitySet =
                marcaEntitySet == null ? new ObjectSet<Marca>(Marca.class, this) : marcaEntitySet;
        seccionEntitySet =
                seccionEntitySet == null ? new ObjectSet<Seccion>(Seccion.class, this) : seccionEntitySet;
        productoEntitySet =
                productoEntitySet == null ? new ObjectSet<Producto>(Producto.class, this) : productoEntitySet;
        tiendaEntitySet =
                tiendaEntitySet == null ? new ObjectSet<Tienda>(Tienda.class, this) : tiendaEntitySet;
        productoTiendaEntitySet =
                productoTiendaEntitySet == null ? new ObjectSet<ProductoTienda>(ProductoTienda.class, this) : productoTiendaEntitySet;
    }

    private static String getDataBaseFolder() {
        String folderPath = "";
        try {

            folderPath = String.format(DATABASE_FOLDER, Environment.getExternalStorageDirectory().getAbsolutePath());

            File dbFolder = new File(folderPath);
            if (!dbFolder.exists()) {
                dbFolder.mkdirs();
            }

        } catch (Exception e) {
            ExceptionHelper.manage(e);
        }

        return folderPath;
    }

}
