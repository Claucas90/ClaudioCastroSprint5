package com.claucas90.sprint5.Vistas

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.claucas90.sprint5.R
import com.claucas90.sprint5.databinding.FragmentItemBinding

import com.claucas90.sprint5.Presentacion.ItemPresenter


class ItemFragment : Fragment() {
    private lateinit var itemBinding: FragmentItemBinding
    private lateinit var navController: NavController
    private lateinit var itemPresenter: ItemPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        itemBinding= FragmentItemBinding.inflate(inflater, container, false)
        val textoNombre=itemBinding.textNombre
        val bundle=Bundle()
        val argument = arguments
        if(argument!=null){
            val url=argument.getString("url")
            val name=argument.getString("nombre")
            val price=argument.getInt("precio")
            textoNombre.text=name
            itemBinding.textPrecio.text=price.toString()
            Glide.with(this).load(url).into(itemBinding.imageViewItem)


            bundle.putString("url",url)
            bundle.putString("nombre",name)
            bundle.putInt("precio",price)
        }
        val botonVolver=itemBinding.botonItemVolver
        botonVolver.setOnClickListener { view->
            navController = requireActivity().findNavController(R.id.navHostFragmentView)
            navController.navigateUp()
        }

        val boton=itemBinding.botonAgregar
        boton.setOnClickListener{view->
            itemPresenter= ItemPresenter(requireContext().getSharedPreferences(textoNombre.text.toString(), MODE_PRIVATE))
            itemPresenter.guardarItem(bundle)
            llamarSiguienteFrag()
        }
        return itemBinding.root
    }

    fun llamarSiguienteFrag(){
        navController = requireActivity().findNavController(R.id.navHostFragmentView)

        navController.navigate(R.id.action_itemFragment_to_cartFragment)
    }
}