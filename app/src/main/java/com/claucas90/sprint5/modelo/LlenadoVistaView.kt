package com.claucas90.sprint5.modelo

import android.content.Context
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.claucas90.sprint5.Presentacion.ItemPresenter


open class llenadoListaView {
    val lista:MutableList<Producto> = mutableListOf()


    open fun llenarLista(context: Context):List<Producto>{
        lista.clear()
        var itemPresenter= ItemPresenter(context.getSharedPreferences("zapato varón", Context.MODE_PRIVATE))
        var bundle=itemPresenter.cargarItem()
        var producto=Producto(bundle.getString("url").toString(),bundle.getString("nombre").toString(),bundle.getInt("precio"))
        lista.add(producto)
        itemPresenter= ItemPresenter(context.getSharedPreferences("Zapato Varón Casual", Context.MODE_PRIVATE))
        bundle=itemPresenter.cargarItem()
        producto=Producto(bundle.getString("url").toString(),bundle.getString("nombre").toString(),bundle.getInt("precio"))
        lista.add(producto)
        itemPresenter= ItemPresenter(context.getSharedPreferences("Zapato Dama Casual", Context.MODE_PRIVATE))
        bundle=itemPresenter.cargarItem()
        producto=Producto(bundle.getString("url").toString(),bundle.getString("nombre").toString(),bundle.getInt("precio"))
        lista.add(producto)
        itemPresenter= ItemPresenter(context.getSharedPreferences("Zapato Mujer Elegante", Context.MODE_PRIVATE))
        bundle=itemPresenter.cargarItem()
        producto=Producto(bundle.getString("url").toString(),bundle.getString("nombre").toString(),bundle.getInt("precio"))
        lista.add(producto)
        return lista
    }

    open fun recuperarBundle(item:Producto):Bundle{
        val bundle = Bundle()
        bundle.putString("url", item.urlImagen)
        bundle.putString("nombre", item.nombre)
        bundle.putInt("precio", item.precio)
        return bundle
    }
}