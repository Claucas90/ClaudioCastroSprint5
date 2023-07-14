package com.claucas90.sprint5.Vistas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.claucas90.sprint5.R
import com.claucas90.sprint5.modelo.Producto
import com.claucas90.sprint5.Presentacion.ItemPresenter

class MainActivity : AppCompatActivity() {
    private lateinit var itemPresenter: ItemPresenter
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragmentView) as NavHostFragment
        navController = navHostFragment.navController
        val producto1= Producto("https://example.com/zapato1.jpg","zapato 1",9999)
        val producto2= Producto("https://example.com/zapato2.jpg","Zapato 2",7999)
        val producto3= Producto("https://example.com/zapato3.jpg","Zapato 3",14999)
        val producto4= Producto("https://example.com/zapato4.jpg","Zapato 4",12999)
        val producto5= Producto("https://example.com/zapato5.jpg","zapato 5",10999)
        val producto6= Producto("https://example.com/zapato6.jpg","Zapato 6",8999)
        val producto7= Producto("https://example.com/zapato7.jpg","Zapato 7",19999)
        val producto8= Producto("https://example.com/zapato8.jpg","Zapato 8",16999)
        val producto9= Producto("https://example.com/zapato9.jpg","Zapato 9",11999)
        val producto10= Producto("https://example.com/zapato10.jpg","Zapato 10",14999)
        guardardatos(producto1)
        guardardatos(producto2)
        guardardatos(producto3)
        guardardatos(producto4)
        guardardatos(producto5)
        guardardatos(producto6)
        guardardatos(producto7)
        guardardatos(producto8)
        guardardatos(producto9)
        guardardatos(producto10)
    }

    fun guardardatos(objeto:Producto){
        itemPresenter= ItemPresenter(this.getSharedPreferences(objeto.nombre, MODE_PRIVATE))
        val bundle=Bundle()
        bundle.putString("url",objeto.urlImagen)
        bundle.putString("nombre",objeto.nombre)
        bundle.putInt("precio",objeto.precio)
        itemPresenter.guardarItem(bundle)
    }
}