package com.map.mikronomy.modelo.entidades;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "ProductoTienda")
public class ProductoTienda extends Entity{
    @TableField(name = "Precio", datatype = DATATYPE_DOUBLE)
    private double precio;
    @TableField(name = "Medida", datatype = DATATYPE_STRING)
    private String medida;
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY_LINK)
    private Producto producto;
    @TableField(name = "Tienda", datatype = DATATYPE_ENTITY_LINK)
    private Tienda tienda;


}
