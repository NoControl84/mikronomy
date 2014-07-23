package com.map.mikronomy.modelo.entidades;

import com.map.mikronomy.activities.ProductosActivity;
import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "Marca")
public class Marca extends Entity {
    @TableField(name = "NombreMarca", datatype = DATATYPE_STRING, required = true, unique = true)
    private String nombreMarca;
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY)
    private List productos;

    public Marca() {
        this.nombreMarca = "Marca blanca";
        this.productos = new ArrayList<ProductosActivity>();
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public List getProductos() {
        return productos;
    }

    public void setProductos(List productos) {
        this.productos = productos;
    }
}
