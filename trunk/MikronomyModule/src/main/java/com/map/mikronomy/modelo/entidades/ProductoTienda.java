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
    @TableField(name = "Producto", datatype = DATATYPE_ENTITY)
    private List productos;
    @TableField(name = "Tienda", datatype = DATATYPE_ENTITY)
    private List tiendas;

    public ProductoTienda() {
        this.precio = 0D;
        this.medida = Medida.UNIDAD.toString();
        this.productos = new ArrayList<Producto>();
        this.tiendas = new ArrayList<Tienda>();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public List getProductos() {
        return productos;
    }

    public void setProductos(List productos) {
        this.productos = productos;
    }

    public List getTiendas() {
        return tiendas;
    }

    public void setTiendas(List tiendas) {
        this.tiendas = tiendas;
    }

}
