package com.lihan.foodapplihan.data

import androidx.lifecycle.LiveData
import retrofit2.http.GET


interface FoodApi {

    @GET("foodRandom")
    suspend fun getRandomFood() : Food

    companion object{
        const val BASE_URL = "http://cf6c-160-237-147-77.ngrok.io/"
    }
}