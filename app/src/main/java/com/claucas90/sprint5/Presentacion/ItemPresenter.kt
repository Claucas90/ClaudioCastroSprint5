package com.claucas90.sprint5.Presentacion


import android.content.SharedPreferences
import android.os.Bundle
import com.claucas90.sprint5.modelo.PreferenceManager

open class ItemPresenter(indice:SharedPreferences):PreferenceManager(indice) {
    override fun cargarItem(): Bundle {
        return super.cargarItem()
    }

    override fun guardarItem(bundle: Bundle) {
        super.guardarItem(bundle)
    }

    override fun deletePreferences() {
        super.deletePreferences()
    }
}