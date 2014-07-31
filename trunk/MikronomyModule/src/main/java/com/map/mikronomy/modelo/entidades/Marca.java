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
@Table(name = "Marca")
public class Marca extends Entity {

    public static final String COL_NOMBRE_MARCA = "NombreMarca";

    @TableField(name = "NombreMarca", datatype = DATATYPE_STRING, required = true, unique = true)
    @Databinding(ViewId = R.id.TXT_Marca)
    @RequiredFieldValidation(messageResourceId = R.string.campo_obligatorio_marca)
    private String nombreMarca;
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY_LINK)
    private Producto producto;

    public Marca(String nombreMarca, Producto producto) {
        this.nombreMarca = nombreMarca;
        this.producto = producto;
    }

}
