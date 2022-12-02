package com.example.maximus

import com.example.maximus.RetrofitInterface.data
import com.example.maximus.ResponseModel.fact
import com.example.maximus.ResponseModel.length
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import com.example.maximus.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.maximus.RetrofitInterface
import com.example.maximus.ResponseModel
import android.content.DialogInterface
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var data = ""
    var textview: TextView? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview = findViewById(R.id.textview)
        button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener { FetchingDat() })
    }

    private fun FetchingDat() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://catfact.ninja")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitInterface = retrofit.create(
            RetrofitInterface::class.java
        )
        val call = retrofitInterface.data
        call!!.enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                if (response.code() != 200) {
                    textview!!.text = "check the connection"
                }
                var jsony = ""
                jsony = """
                    fact${response.body()!!.fact}
                    length${response.body()!!.length}
                    """.trimIndent()
                textview!!.text = jsony
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {}
        })
    }

    override fun onBackPressed() {
        val alertdialog = AlertDialog.Builder(this@MainActivity)
        alertdialog.setTitle("Exit")
        alertdialog.setMessage("Are you sure you want to Exit ?")
        alertdialog.setPositiveButton("Yes") { dialogInterface, i -> finishAffinity() }
        alertdialog.setNegativeButton("No") { dialogInterface, i -> dialogInterface.dismiss() }
        alertdialog.show()
    }
}