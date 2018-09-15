package com.mostafa.fci.asynctaskdemo

import org.json.JSONArray

object JSONParser {

     fun parse(content:String?) :List<Flower>? {

         if (content.equals(""))
             return null

         val flowersList = ArrayList<Flower>()

         content?.let {

             try {
                 val jsonArray = JSONArray(content)
                 for (i in 0 until jsonArray.length()) {

                     val jsonObject = jsonArray.getJSONObject(i)

                     val flower = Flower()
                     flower.id = jsonObject.getInt(ObjectsNames.ID)
                     flower.name = jsonObject.getString(ObjectsNames.NAME)
                     flower.category = jsonObject.getString(ObjectsNames.CATEGORY)
                     flower.price = jsonObject.getString(ObjectsNames.PRICE)
                     flower.instructions = jsonObject.getString(ObjectsNames.INSTRUCTIONS)
                     flower.photo = jsonObject.getString(ObjectsNames.PHOTO)

                     flowersList.add(flower)

                 }
             } catch (e: Exception) {
                 e.printStackTrace()
                 return null
             }
         }
         return flowersList
    }
}