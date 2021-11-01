package com.lihan.foodapplihan.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lihan.foodapplihan.data.Food
import com.lihan.foodapplihan.data.FoodApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(
  private val api : FoodApi
) : ViewModel() {

    val food  = MutableLiveData<Food>()
    init {
        getRandomFood()
    }
    fun getRandomFood(){
        viewModelScope.launch {
            val apiFood = api.getRandomFood()
            food.postValue(apiFood)
            Log.d("MainViewModel", "getRandomFood:  ${apiFood.toString()}")

        }
    }


}