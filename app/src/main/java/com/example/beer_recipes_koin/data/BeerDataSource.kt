package com.example.beer_recipes_koin.data

import com.example.beer_recipes_koin.domain.model.Beer
import com.example.beer_recipes_koin.domain.repository.BeerRepository
import retrofit2.Response

class BeerDataSource(private val beerApi: BeerApi):BeerRepository {

    override suspend fun getBeerReceipes(): Response<List<Beer>> {
      return beerApi.getBeerRecipes()
    }
}