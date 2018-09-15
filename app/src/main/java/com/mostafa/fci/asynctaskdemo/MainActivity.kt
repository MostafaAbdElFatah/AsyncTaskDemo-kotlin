package com.mostafa.fci.asynctaskdemo

import android.app.ProgressDialog
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DownloadData().execute()

    }

    internal inner class DownloadData :AsyncTask<Void,Void,String>(){

        private lateinit var progessDialog: ProgressDialog

        override fun onPreExecute() {
            progessDialog = ProgressDialog(this@MainActivity)
            progessDialog.setTitle("Downloading")
            progessDialog.setMessage("Please wait until Downloading Finish")
            progessDialog.setCancelable(false)
            progessDialog.show()
        }

        override fun doInBackground(vararg p0: Void?): String? {
            return NetworkManager
                    .getJSON("${URLs.mainURL}${URLs.feedURL}${URLs.jsonFlowersURL}")

        }

        override fun onPostExecute(result: String?) {
            var list:ArrayList<Flower> = JSONParser.parse(result) as ArrayList<Flower>

            val text = StringBuilder()
            for (flower in list){
                text.append(flower.toString())
                text.append("\n============\n")
            }

            text_view.text = text.toString()

            progessDialog.dismiss()
        }
    }

}
