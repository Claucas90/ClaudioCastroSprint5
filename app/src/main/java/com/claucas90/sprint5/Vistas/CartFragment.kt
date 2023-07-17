package com.claucas90.sprint5.Vistas

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.claucas90.sprint5.R
import com.claucas90.sprint5.databinding.FragmentCartBinding
import com.claucas90.sprint5.modelo.AdapterCart
import com.claucas90.sprint5.modelo.AdapterView
import com.claucas90.sprint5.modelo.Producto
import com.claucas90.sprint5.Presentacion.AdapterViewPresenter
import com.claucas90.sprint5.Presentacion.ItemPresenter


class CartFragment : Fragment() {
    private lateinit var cartBinding: FragmentCartBinding
    private lateinit var navController: NavController
    private lateinit var itemPresenter: ItemPresenter
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: AdapterCart
    private val lista:MutableList<Producto> = mutableListOf()
    private val listaFinal:MutableList<Producto> = mutableListOf()
    val llenadoLista= AdapterViewPresenter()
    var total=0
    lateinit var textoTotal:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        cartBinding= FragmentCartBinding.inflate(inflater, container, false)
        textoTotal=cartBinding.textTotal
        cargarRecicler(cartBinding.root)
        val botoncito=cartBinding.botonItemVolver
        val botonFinal=cartBinding.botonPagar

        botonFinal.setOnClickListener{view->
            val alertDialog = AlertDialog.Builder(this.requireContext())
                .setTitle("Pago de Compra")
                .setMessage("Gracias por su compra")
                .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
                .create()

            alertDialog.show()
            vaciarCarro()
            volverMain()

        }
        botoncito.setOnClickListener { view->
            volverMain()
        }
        return cartBinding.root
    }

    fun cargarRecicler(view:View){
        recyclerView = view.findViewById(R.id.recyclerViewCart)
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        lista.addAll(llenadoLista.llenarLista(this.requireContext()))
        for (objeto in lista){

            if(objeto.cantidad>0){
                total += (objeto.precio * objeto.cantidad)
                listaFinal.add(objeto)
            }
        }
        textoTotal.text=total.toString()
        itemAdapter = AdapterCart(listaFinal)

        recyclerView.adapter = itemAdapter
    }

    fun volverMain(){
        navController = requireActivity().findNavController(R.id.navHostFragmentView)

        navController.navigate(R.id.action_cartFragment_to_viewFragment)

    }
    fun vaciarCarro(){
        val producto1= Producto("https://static.dafiti.cl/p/adidas-performance-3235-5291051-1-zoom.jpg","zapato 1",1990,0)
        val producto2= Producto("https://static.dafiti.cl/p/tommy-hilfiger-8770-5052102-1-catalog-new.jpg","Zapato 2",2990,0)
        val producto3= Producto("https://static.dafiti.cl/p/the-hills-8601-7984251-1-catalog-new.jpg","Zapato 3",3990,0)
        val producto4= Producto("https://static.dafiti.cl/p/gotta-9594-443287-1-catalog-new.jpg","Zapato 4",4990,0)
        val producto6= Producto("https://static.dafiti.cl/p/danicolle-8713-0528702-1-catalog-new.jpg","Zapato 6",6990,0)
        val producto7= Producto("https://static.dafiti.cl/p/azaleia-8177-9755202-1-catalog-new.jpg","Zapato 7",7990,0)
        val producto8= Producto("https://static.dafiti.cl/p/the-hills-4983-3984251-1-catalog-new.jpg","Zapato 8",8990,0)
        val producto9= Producto("https://static.dafiti.cl/p/the-hills-4925-5984251-1-catalog-new.jpg","Zapato 9",9990,0)
        val producto10= Producto("https://static.dafiti.cl/p/adidas-sportswear-3371-8907591-1-catalog-new.jpg","Zapato 10",10990,0)
        guardardatos(producto1)
        guardardatos(producto2)
        guardardatos(producto3)
        guardardatos(producto4)
        guardardatos(producto6)
        guardardatos(producto7)
        guardardatos(producto8)
        guardardatos(producto9)
        guardardatos(producto10)
    }

    fun guardardatos(objeto:Producto){
        itemPresenter= ItemPresenter(this.requireContext().getSharedPreferences(objeto.nombre,AppCompatActivity.MODE_PRIVATE))
        val bundle=Bundle()
        bundle.putString("url",objeto.urlImagen)
        bundle.putString("nombre",objeto.nombre)
        bundle.putInt("precio",objeto.precio)
        bundle.putInt("cantidad",objeto.cantidad)
        itemPresenter.guardarItem(bundle)
    }


}