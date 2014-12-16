package com.map.mikronomy.modelo.entidades;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;
import com.mobandme.ada.annotations.TableIndex;

/**
 * Created by Mikel on 16/07/2014. Entidad de modelo de BBDD Tienda
 */
@Table(name = "Tienda")
public class Tienda extends Entity{

    public static final String COL_NOMBRE_TIENDA = "NombreTienda";

    public final static String TIENDA_DEFAULT = "Otra";

    @TableField(name = "NombreTienda", datatype = DATATYPE_STRING, required = true, unique = true)
    @TableIndex(name = "INX_NombreTienda")
    private String nombreTienda;

    public Tienda() {
        setNombreTienda(TIENDA_DEFAULT);
    }

    public Tienda(String nombreTienda) {
        nombreTienda = nombreTienda == null ? TIENDA_DEFAULT : nombreTienda;
        setNombreTienda(nombreTienda);
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    @Override
    public String toString() {
        return getNombreTienda();
    }
}
