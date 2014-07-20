package com.map.mikronomy.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mikel on 16/07/2014.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "ComprasMikronomy.s3db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_MULTIPLE_TABLES_QUERY =
            //Tabla MARCA
            "CREATE TABLE IF NOT EXISTS Marca (" +
                    "IDMarca INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "NombreMarca NVARCHAR(30)  UNIQUE NOT NULL" +
                    ")" +
             //Tabla CATEGORIA
             "CREATE TABLE IF NOT EXISTS Categoria (" +
                    "IDCategoria INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "Descripcion NVARCHAR(50)  UNIQUE NOT NULL" +
                    ")" +
             //Tabla PRODUCTO
             "CREATE TABLE IF NOT EXISTS Producto (" +
                    "IDProducto INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "NombreProducto NVARCHAR(50)  UNIQUE NOT NULL" +
                    ", IDMarca INTEGER REFERENCES Marca(IDMarca), IDCategoria INTEGER REFERENCES Categoria(IDCategoria))" +
             //Tabla TIENDA
             "CREATE TABLE IF NOT EXISTS Tienda (" +
                    "IDTienda INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "NombreTienda NVARCHAR(30)  UNIQUE NOT NULL" +
                    ")" +
             //Tabla PRODUCTO_TIENDA
            "CREATE TABLE IF NOT EXISTS Producto_Tienda (" +
                    "IDProductoTienda INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "Precio NUMERIC DEFAULT \'0\' NULL," +
                    "IDProducto INTEGER  NULL," +
                    "IDTienda INTEGER  NULL," +
                    "Medida NVARCHAR(10) DEFAULT \'Unidad\' NULL" +
                    ")";

    private static final String DROP_MULTIPLE_TABLES_QUERY =
            "DROP TABLE IF EXISTS Marca" +
            "DROP TABLE IF EXISTS Categoria" +
            "DROP TABLE IF EXISTS Producto" +
            "DROP TABLE IF EXISTS Tienda" +
            "DROP TABLE IF EXISTS Producto_Tienda";




    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MULTIPLE_TABLES_QUERY);
        db = getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_MULTIPLE_TABLES_QUERY);
        onCreate(db);
    }
}
