package com.example.beer_recipes_koin.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beer_recipes_koin.domain.model.Beer
import com.example.beer_recipes_koin.domain.useCase.BeerUseCase
import kotlinx.coroutines.launch

class BeerViewModel(private val beerUseCase: BeerUseCase):ViewModel() {


    val details: LiveData<List<Beer>> get()= _details
    private val _details = MutableLiveData<List<Beer>>()

    val error: LiveData<String> get()= _error
    private val _error = MutableLiveData<String>()

    fun getBeerRecipe(){

        viewModelScope.launch {
            var response= beerUseCase.invoke()

            if (response.isSuccessful){
                _details.value=response.body()
            }else{
                _error.value=response.errorBody().toString()
            }
        }
    }

}