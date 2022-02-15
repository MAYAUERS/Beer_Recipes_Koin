package com.example.beer_recipes_koin.domain.useCase

import com.example.beer_recipes_koin.domain.model.Beer
import com.example.beer_recipes_koin.domain.repository.BeerRepository
import retrofit2.Response

class BeerUseCase(private val beerRepository: BeerRepository){

    suspend operator fun invoke() :Response<List<Beer>>{
        return beerRepository.getBeerReceipes()
    }
}