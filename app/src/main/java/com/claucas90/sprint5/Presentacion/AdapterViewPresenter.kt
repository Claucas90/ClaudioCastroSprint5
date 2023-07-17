package com.claucas90.sprint5.Presentacion

import android.content.Context
import android.os.Bundle
import com.claucas90.sprint5.modelo.Producto
import com.claucas90.sprint5.modelo.LlenadoListaView


open class AdapterViewPresenter:LlenadoListaView() {
    override fun llenarLista(context:Context): List<Producto> {
        return super.llenarLista(context)
    }

    override fun recuperarBundle(item: Producto): Bundle {
        return super.recuperarBundle(item)
    }

}