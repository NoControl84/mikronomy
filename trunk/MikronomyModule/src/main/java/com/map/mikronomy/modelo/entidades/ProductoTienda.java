package com.map.mikronomy.modelo.entidades;

import com.map.mikronomy.R;
import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Databinding;
import com.mobandme.ada.annotations.RequiredFieldValidation;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikel on 16/07/2014.
 */
@Table(name = "ProductoTienda")
public class ProductoTienda extends Entity{

    public static final String COL_PRECIO = "Precio";


    @TableField(name = "Precio", datatype = DATATYPE_REAL)
    @Databinding(ViewId = R.id.DecTXT_Precio)
    private float precio;
    @TableField(name = "Medida", datatype = DATATYPE_STRING)
    @Databinding(ViewId = R.id.SPI_UdMedida)
    private String medida;
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY_LINK)
    private Producto producto;
    @TableField(name = "Tienda", datatype = DATATYPE_ENTITY_LINK)
    private Tienda tienda;

    public ProductoTienda(float precio, String medida, Producto producto, Tienda tienda) {
        this.precio = precio;
        this.medida = medida;
        this.producto = producto;
        this.tienda = tienda;
    }
}
