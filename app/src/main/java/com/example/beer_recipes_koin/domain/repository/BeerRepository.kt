package com.example.beer_recipes_koin.domain.repository

import com.example.beer_recipes_koin.domain.model.Beer
import retrofit2.Response

interface BeerRepository {

    suspend fun getBeerReceipes():Response<List<Beer>>
}