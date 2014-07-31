package com.map.mikronomy.modelo.entidades;

import com.map.mikronomy.R;
import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Databinding;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "Seccion")
public class Seccion extends Entity{

    public static final String COL_DESCRIPCION = "Descripcion";

    @TableField(name = "Descripcion", datatype = DATATYPE_STRING, required = true, unique = true)
    @Databinding(ViewId = R.id.SPI_Secciones)
    private String descripcion;
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY_LINK)
    private Producto producto;

    public Seccion(String descripcion, Producto producto) {
        this.descripcion = descripcion;
        this.producto = producto;
    }
}
