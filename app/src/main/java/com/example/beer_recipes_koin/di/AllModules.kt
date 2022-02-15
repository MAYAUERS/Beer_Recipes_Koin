package com.example.beer_recipes_koin.di

import com.example.beer_recipes_koin.data.BeerDataSource
import com.example.beer_recipes_koin.domain.repository.BeerRepository
import com.example.beer_recipes_koin.domain.useCase.BeerUseCase
import com.example.beer_recipes_koin.presentation.BeerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule= module {

    single <BeerRepository> {BeerDataSource(beerApi = get())}
}

val domainModule= module {
        factory { BeerUseCase(beerRepository = get()) }
}
val presentationModule= module {

    viewModel {
        BeerViewModel(beerUseCase = get())
    }
}