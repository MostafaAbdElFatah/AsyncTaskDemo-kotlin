package com.mostafa.fci.asynctaskdemo

import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL


object NetworkManager {
    fun getJSON(uri:String):String?{
        var reader: BufferedReader? = null
        try {

            val url = URL(uri)
            val con = url.openConnection() as HttpURLConnection

            return con.inputStream.bufferedReader().use(BufferedReader::readText)

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally { }
    }
}