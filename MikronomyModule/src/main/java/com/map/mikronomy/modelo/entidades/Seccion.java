package com.map.mikronomy.modelo.entidades;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

import java.util.List;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "Seccion")
public class Seccion extends Entity{
    @TableField(name = "Descripcion", datatype = DATATYPE_STRING, required = true, unique = true)
    private String descripcion;
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY)
    private List productos;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List getProductos() {
        return productos;
    }

    public void setProductos(List productos) {
        this.productos = productos;
    }
}
