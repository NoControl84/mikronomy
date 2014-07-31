package com.map.mikronomy.modelo.entidades;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "Seccion")
public class Seccion extends Entity{
    @TableField(name = "Descripcion", datatype = DATATYPE_STRING, required = true, unique = true)
    private String descripcion;
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY_LINK)
    private Producto producto;


}
