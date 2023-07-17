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
        val producto1= Producto("https://static.dafiti.cl/p/adidas-performance-3235-5291051-1-zoom.jpg","zapato 1",1990,0)
        val producto2= Producto("https://static.dafiti.cl/p/tommy-hilfiger-8770-5052102-1-catalog-new.jpg","Zapato 2",2990,0)
        val producto3= Producto("https://static.dafiti.cl/p/the-hills-8601-7984251-1-catalog-new.jpg","Zapato 3",3990,0)
        val producto4= Producto("https://static.dafiti.cl/p/gotta-9594-443287-1-catalog-new.jpg","Zapato 4",4990,0)
        val producto6= Producto("https://static.dafiti.cl/p/danicolle-8713-0528702-1-catalog-new.jpg","Zapato 5",6990,0)
        val producto5= Producto("https://static.dafiti.cl/p/adidas-sportswear-3371-8907591-1-catalog-new.jpg","Zapato 6",10990,0)
        val producto7= Producto("https://static.dafiti.cl/p/azaleia-8177-9755202-1-catalog-new.jpg","Zapato 7",7990,0)
        val producto8= Producto("https://static.dafiti.cl/p/the-hills-4983-3984251-1-catalog-new.jpg","Zapato 8",8990,0)
        val producto9= Producto("https://static.dafiti.cl/p/the-hills-4925-5984251-1-catalog-new.jpg","Zapato 9",9990,0)
        val producto10= Producto("https://static.dafiti.cl/p/adidas-sportswear-3371-8907591-1-catalog-new.jpg","Zapato 10",10990,0)
        val producto11= Producto("https://static.dafiti.cl/p/adidas-sportswear-3371-8907591-1-catalog-new.jpg","Zapato 11",10990,0)
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
        guardardatos(producto11)
    }

    fun guardardatos(objeto:Producto){
        itemPresenter= ItemPresenter(this.getSharedPreferences(objeto.nombre, MODE_PRIVATE))
        val bundle=Bundle()
        bundle.putString("url",objeto.urlImagen)
        bundle.putString("nombre",objeto.nombre)
        bundle.putInt("precio",objeto.precio)
        bundle.putInt("cantidad",objeto.cantidad)
        itemPresenter.guardarItem(bundle)
    }
}