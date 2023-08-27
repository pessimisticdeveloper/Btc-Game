package com.example.bulkarayialparayi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class StartActivity : AppCompatActivity() {

    private lateinit var tutar : EditText
    private lateinit var baslabtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        tutar = findViewById(R.id.tutar)
        baslabtn = findViewById(R.id.baslabtn)


        baslabtn.setOnClickListener{
            if (tutar.text.toString() == "") {
                Toast.makeText(this,"BTC Yatırın !", Toast.LENGTH_LONG).show()
            }else{
                val tutarSayi = tutar.text
                val intent = Intent(this@StartActivity,MainActivity::class.java)
                intent.putExtra("tutar",tutarSayi.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
