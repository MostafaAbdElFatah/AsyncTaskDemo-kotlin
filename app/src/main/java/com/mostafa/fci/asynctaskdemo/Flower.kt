package com.mostafa.fci.asynctaskdemo

import android.graphics.Bitmap



class Flower(){

    var id: Int = 0
    var name: String? = null
    var category: String? = null
    var instructions: String? = null
    var price: String? = null
    var photo: String? = null
    var bitmap: Bitmap? = null

    constructor(id: Int, name: String, category: String, instructions: String, price: String
                , photo: String, bitmap: Bitmap) : this(){
        this.id = id
        this.name = name
        this.category = category
        this.instructions = instructions
        this.price = price
        this.photo = photo
        this.bitmap = bitmap
    }

    override fun toString(): String {
        return "Flower id:$id\nFlower Name:$name\nFlower Category:$category\n" +
                "Flower instructions:$instructions\nFlower price:$price\n" +
                "Flower URL:$photo\n"
    }

}
