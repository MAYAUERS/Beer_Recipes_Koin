package com.example.beer_recipes_koin.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.beer_recipes_koin.databinding.BeerListBinding
import com.example.beer_recipes_koin.domain.model.Beer

class BeerAdapter :RecyclerView.Adapter<BeerAdapter.BeerViewHolder>() {
    var beer :List<Beer> =ArrayList<Beer>()
    class BeerViewHolder(var binding: BeerListBinding) :RecyclerView.ViewHolder(binding.root){

        fun bindViews(beer :Beer){
            binding.tvId.text=beer.id.toString()
            binding.tvName.text=beer.name
            binding.tvTangile.text=beer.tagline
            val imageUrl= beer.image_url
            binding.imageBeer.load(imageUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerAdapter.BeerViewHolder {
      var binding = BeerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BeerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BeerAdapter.BeerViewHolder, position: Int) {
        holder.bindViews(beer[position])
    }

    override fun getItemCount(): Int {
       return beer.size
    }
}