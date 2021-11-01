package com.lihan.foodapplihan.data


data class Food(
    val name : String ,
    val price : Int ,
    val address : String ,
    val image : String
){
    override fun toString(): String {
        return "name $name"
    }
}
