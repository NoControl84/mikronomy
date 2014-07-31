package com.map.mikronomy.modelo.datacontexts;

import android.content.Context;
import android.os.Environment;

import com.map.mikronomy.helper.ExceptionHelper;
import com.map.mikronomy.modelo.entidades.Seccion;
import com.map.mikronomy.modelo.entidades.Marca;
import com.map.mikronomy.modelo.entidades.Producto;
import com.map.mikronomy.modelo.entidades.ProductoTienda;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.map.mikronomy.modelo.helpers.DBHelper;
import com.map.mikronomy.modelo.setters.TiendaObjectSet;
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

        //Enable DataBase Transactions to be used by the Save process.
        this.setUseTransactions(true);

        //Enable the creation of DataBase table indexes.
        this.setUseTableIndexes(true);

        //Enable LazyLoading capabilities.
        //this.useLazyLoading(true);

        //Set a custom encryption algorithm.
        this.setEncryptionAlgorithm("AES");

        //Set a custom encryption master pass phrase.
        this.setMasterEncryptionKey("com.mikronomy.secure");

        marcaEntitySet = marcaEntitySet == null ? new ObjectSet<Marca>(Marca.class, this) : marcaEntitySet;
        seccionEntitySet = seccionEntitySet == null ? new ObjectSet<Seccion>(Seccion.class, this) : seccionEntitySet;
        productoEntitySet = productoEntitySet == null ? new ObjectSet<Producto>(Producto.class, this) : productoEntitySet;
        tiendaEntitySet = tiendaEntitySet == null ? new TiendaObjectSet(this) : tiendaEntitySet;
        productoTiendaEntitySet = productoTiendaEntitySet == null ? new ObjectSet<ProductoTienda>(ProductoTienda.class, this) : productoTiendaEntitySet;

        marcaEntitySet.fill(DBHelper.orderByColumn(Marca.COL_NOMBRE_MARCA, DBHelper.ASCENDING_SORT));
        seccionEntitySet.fill(DBHelper.orderByColumn(Seccion.COL_DESCRIPCION, DBHelper.ASCENDING_SORT));
        productoEntitySet.fill(DBHelper.orderByColumn(Producto.COL_NOMBRE_PRODUCTO, DBHelper.ASCENDING_SORT));
        tiendaEntitySet.fill(DBHelper.orderByColumn(Tienda.COL_NOMBRE_TIENDA, DBHelper.ASCENDING_SORT));
        productoTiendaEntitySet.fill(DBHelper.orderByColumn(ProductoTienda.COL_PRECIO, DBHelper.ASCENDING_SORT));
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

    @Override
    protected void onError(Exception pException) {
        ExceptionHelper.manage(getContext(), pException);
    }

}
