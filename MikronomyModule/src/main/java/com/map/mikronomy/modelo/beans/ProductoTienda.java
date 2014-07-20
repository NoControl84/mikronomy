package com.map.mikronomy.modelo.beans;

/**
 * Created by Mikel on 16/07/2014.
 */
public class ProductoTienda {
    private double productoTienda;
    private int idProducto;
    private int idTienda;
    private String medida;

    public double getProductoTienda() {
        return productoTienda;
    }

    public void setProductoTienda(double productoTienda) {
        this.productoTienda = productoTienda;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
