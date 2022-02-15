package com.example.beer_recipes_koin.data

import com.example.beer_recipes_koin.domain.model.Beer
import retrofit2.Response
import retrofit2.http.GET

interface BeerApi {

    //https://api.punkapi.com/v2/beers
    @GET("v2/beers")
    suspend fun getBeerRecipes() :Response<List<Beer>>
}