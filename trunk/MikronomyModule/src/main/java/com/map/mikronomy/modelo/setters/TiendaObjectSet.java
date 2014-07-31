package com.map.mikronomy.modelo.setters;

import com.map.mikronomy.helper.ExceptionHelper;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.mobandme.ada.ObjectContext;
import com.mobandme.ada.ObjectSet;
import com.mobandme.ada.exceptions.AdaFrameworkException;

import java.util.List;

/**
 * Created by Mikel on 31/07/2014.
 */
public class TiendaObjectSet extends ObjectSet<Tienda>{
    public TiendaObjectSet(ObjectContext pContext) throws AdaFrameworkException {
        super(Tienda.class, pContext);
    }

    public Tienda getByName(String nombre) {
        return getByName(nombre, true);
    }

    public Tienda getByName(String nombre, boolean addIfNotExists) {
        Tienda tienda = null;

        try {
            if (nombre != null && !nombre.trim().isEmpty()) {
                String wherePattern = String.format("%s = ?", getDataTableFieldName("NombreTienda"));
                String[] whereValues = new String[]{nombre};
                //Limitar a un resultado
                List<Tienda> listaTiendas = search(true, wherePattern, whereValues, null, null, null, 0, 1);
                if (listaTiendas != null && listaTiendas.size() > 1) {
                    tienda = listaTiendas.get(0);
                } else if (addIfNotExists) {
                    tienda = new Tienda(nombre);
                    //Salvar en la BBDD
                    save(tienda);
                    //Añadirla al ObjectSet
                    add(tienda);
                }

            }
        } catch(AdaFrameworkException e) {
            ExceptionHelper.manage(e);
        }

        return tienda;

    }

}
