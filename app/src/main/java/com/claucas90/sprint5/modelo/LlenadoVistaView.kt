package com.claucas90.sprint5.modelo

import android.content.Context
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.claucas90.sprint5.Presentacion.ItemPresenter

open class LlenadoListaView {
    val lista: MutableList<Producto> = mutableListOf()

    open fun llenarLista(context: Context): List<Producto> {
        lista.clear()
        var itemPresenter = ItemPresenter(context.getSharedPreferences("zapato 1", Context.MODE_PRIVATE))
        var bundle = itemPresenter.cargarItem()
        var producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 2", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 3", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 4", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 6", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 7", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 8", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 9", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 10", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        itemPresenter = ItemPresenter(context.getSharedPreferences("Zapato 5", Context.MODE_PRIVATE))
        bundle = itemPresenter.cargarItem()
        producto = Producto(bundle.getString("url").toString(), bundle.getString("nombre").toString(), bundle.getInt("precio"), bundle.getInt("cantidad"))
        lista.add(producto)
        return lista
    }

    open fun recuperarBundle(item: Producto): Bundle {
        val bundle = Bundle()
        bundle.putString("url", item.urlImagen)
        bundle.putString("nombre", item.nombre)
        bundle.putInt("precio", item.precio)
        bundle.putInt("cantidad", item.cantidad)
        return bundle
    }
}
