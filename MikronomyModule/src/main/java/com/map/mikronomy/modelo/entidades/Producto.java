package com.map.mikronomy.modelo.entidades;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "Producto")
public class Producto extends Entity{

    @TableField(name = "NombreProducto", datatype = DATATYPE_STRING, required = true, unique = true)
    private String nombreProducto;


}
