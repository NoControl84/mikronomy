package com.map.mikronomy.modelo.datacontexts;

import android.content.Context;

import com.map.mikronomy.modelo.entidades.Categoria;
import com.map.mikronomy.modelo.entidades.Marca;
import com.map.mikronomy.modelo.entidades.Producto;
import com.map.mikronomy.modelo.entidades.ProductoTienda;
import com.map.mikronomy.modelo.entidades.Tienda;
import com.mobandme.ada.ObjectContext;
import com.mobandme.ada.ObjectSet;
import com.mobandme.ada.exceptions.AdaFrameworkException;

/**
 * Created by Mikel on 21/07/2014.
 */
public class MikronomyDataContext extends ObjectContext{

    public ObjectSet<Marca> marcaEntitySet;
    public ObjectSet<Categoria> categoriaEntitySet;
    public ObjectSet<Producto> productoEntitySet;
    public ObjectSet<Tienda> tiendaEntitySet;
    public ObjectSet<ProductoTienda> productoTiendaEntitySet;

    public MikronomyDataContext(Context pContext) throws AdaFrameworkException {
        super(pContext);

        this.marcaEntitySet = new ObjectSet<Marca>(Marca.class, this);
        this.categoriaEntitySet = new ObjectSet<Categoria>(Categoria.class, this);
        this.productoEntitySet = new ObjectSet<Producto>(Producto.class, this);

        this.tiendaEntitySet = new ObjectSet<Tienda>(Tienda.class, this);
        this.productoTiendaEntitySet = new ObjectSet<ProductoTienda>(ProductoTienda.class, this);

    }

}
