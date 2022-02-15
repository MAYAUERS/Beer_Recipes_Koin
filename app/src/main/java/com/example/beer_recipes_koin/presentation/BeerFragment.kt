package com.example.beer_recipes_koin.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beer_recipes_koin.R
import com.example.beer_recipes_koin.databinding.FragmentBeerBinding
import com.example.beer_recipes_koin.domain.model.Beer
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerFragment : Fragment() {

    val beerViewModel:BeerViewModel by viewModel()

    private var _binding : FragmentBeerBinding? =null
    private val binding get() =_binding
    var beerAdapter=BeerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentBeerBinding.inflate(inflater,container,false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLayout()
        obserBeerViewModel()

    }

    private fun obserBeerViewModel() {
       beerViewModel.details.observe(viewLifecycleOwner){


           if (it != null) {
               beerAdapter.beer=it
               beerAdapter.notifyDataSetChanged()
           }else{
               Toast.makeText(activity,"Error Occured",Toast.LENGTH_SHORT).show()
           }
       }
        beerViewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
        }
    }

    private fun setLayout() {
       binding?.beerRecycler?.apply {
           setHasFixedSize(true)
           layoutManager=LinearLayoutManager(context)
           adapter=beerAdapter

           beerViewModel.getBeerRecipe()
       }
    }
}