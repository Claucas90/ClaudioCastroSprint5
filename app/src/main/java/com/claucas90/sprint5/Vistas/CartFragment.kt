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

       fun volverMain(){
        navController = requireActivity().findNavController(R.id.navHostFragmentView)

        navController.navigate(R.id.action_cartFragment_to_viewFragment)

    }
    fun vaciarCarro(){
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
        itemPresenter= ItemPresenter(this.requireContext().getSharedPreferences(objeto.nombre,AppCompatActivity.MODE_PRIVATE))
        val bundle=Bundle()
        bundle.putString("url",objeto.urlImagen)
        bundle.putString("nombre",objeto.nombre)
        bundle.putInt("precio",objeto.precio)
        itemPresenter.guardarItem(bundle)
    }


}