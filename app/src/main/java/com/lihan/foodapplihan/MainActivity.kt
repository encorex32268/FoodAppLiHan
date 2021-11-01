package com.lihan.foodapplihan

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.bumptech.glide.Glide
import com.lihan.foodapplihan.databinding.ActivityMainBinding
import com.lihan.foodapplihan.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            viewModel.food.observe(this@MainActivity) { food ->
                food?.let {
                    foodAddressTextView.text = food.address
                    foodNameTextView.text = food.name
                    foodPriceTextView.text = food.price.toString()
                    Glide.with(this@MainActivity).load(food.image).into(foodImageView);
                }
            }
            randomButton.setOnClickListener {
                viewModel.getRandomFood()
            }
        }

    }
}