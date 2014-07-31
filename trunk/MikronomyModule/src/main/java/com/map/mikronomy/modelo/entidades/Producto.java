package com.map.mikronomy.modelo.entidades;

import com.map.mikronomy.R;
import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Databinding;
import com.mobandme.ada.annotations.RequiredFieldValidation;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "Producto")
public class Producto extends Entity{

    public static final String COL_NOMBRE_PRODUCTO = "NombreProducto";

    @TableField(name = "NombreProducto", datatype = DATATYPE_STRING, required = true, unique = true)
    @Databinding(ViewId = R.id.TXT_NombreProducto)
    @RequiredFieldValidation(messageResourceId = R.string.campo_obligatorio_producto)
    private String nombreProducto;

    public Producto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
