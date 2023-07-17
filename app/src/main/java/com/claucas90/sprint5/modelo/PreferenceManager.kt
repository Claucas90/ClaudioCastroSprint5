package com.claucas90.sprint5.modelo

import android.content.SharedPreferences
import android.os.Bundle

open class PreferenceManager(private val sharedPreferences: SharedPreferences) {

    var precio:Int=0

    open fun guardarItem(bundle: Bundle){
        val url= bundle.getString("url").toString()
        val nombre=bundle.getString("nombre").toString()
        precio=bundle.getInt("precio")
        var cantidad=bundle.getInt("cantidad")
        saveUrl(url)
        saveName(nombre)
        saveprice(precio)
        savecant(cantidad)
    }

    open fun cargarItem():Bundle{
        val bundle=Bundle()
        bundle.putString("url",getUrl())
        bundle.putString("nombre",getName())
        bundle.putInt("precio",getPrice())
        bundle.putInt("cantidad",getCant())
        return bundle
    }

    //Guardar datos
    fun saveUrl(value: String) {
        sharedPreferences.edit().putString("URL_VALUE", value).apply()
    }

    fun saveName(value: String) {
        sharedPreferences.edit().putString("NAME_VALUE", value).apply()
    }

     fun saveprice(value: Int) {
        sharedPreferences.edit().putInt("PRICE_VALUE", value).apply()
    }

    fun savecant(value: Int) {
        sharedPreferences.edit().putInt("CANT_VALUE", value).apply()
    }

    //Recuperar datos
    fun getUrl(): String {
        return sharedPreferences.getString("URL_VALUE", "") ?: ""
    }

    fun getName(): String {
        return sharedPreferences.getString("NAME_VALUE", "") ?: ""
    }

    fun getPrice(): Int {
        return sharedPreferences.getInt("PRICE_VALUE", 0)
    }

    fun getCant(): Int {
        return sharedPreferences.getInt("CANT_VALUE", 0)
    }
    //Limpiar todo
    open fun deletePreferences() {
        sharedPreferences.edit().clear().apply()
    }
}