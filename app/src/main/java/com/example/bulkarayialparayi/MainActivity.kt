package com.example.bulkarayialparayi

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    private lateinit var txtCredit : TextView
    private lateinit var btnNewGame : Button
    private lateinit var select1 : ImageButton
    private lateinit var select2 : ImageButton
    private lateinit var select3 : ImageButton
    private lateinit var txtResult : TextView

    private var totalMoney = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tutar = intent.getStringExtra("tutar")
        totalMoney = tutar.toString().toInt()


        txtCredit = findViewById(R.id.txtCredit)
        btnNewGame = findViewById(R.id.btnNewGame)
        select1 = findViewById(R.id.select1)
        select2 = findViewById(R.id.select2)
        select3 = findViewById(R.id.select3)
        txtResult = findViewById(R.id.txtResult)

        txtCredit.setText("Krediniz: " + totalMoney.toString()+" BTC")

        txtResult.setTextColor(Color.YELLOW)
        txtResult.text="Kart Seç !"

        btnNewGame.setOnClickListener {
            txtResult.text=""
            txtResult.setTextColor(Color.YELLOW)
            txtResult.text="Kart Seç !"
            if (totalMoney == 0){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Kredi Bakiyeniz Kalmadı !")
                builder.setMessage("Lütfen Kredi Almak İçin Anasyafya Dönün...")
                txtResult.text="GAME OVER !"
                builder.setPositiveButton("Tamam") { dialog, which ->
                    val intent = Intent(this,StartActivity::class.java)
                    startActivity(intent)
                }
                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()
            }

            imageEnabled(true)

            select1.setBackgroundColor(Color.GRAY)
            select2.setBackgroundColor(Color.GRAY)
            select3.setBackgroundColor(Color.GRAY)

            select1.setImageResource(android.R.color.transparent)
            select2.setImageResource(android.R.color.transparent)
            select3.setImageResource(android.R.color.transparent)
            txtResult.setTextColor(Color.YELLOW)
        }

    }

    fun ClickItem(view: View){

        val rndNumber = 1 + Random().nextInt(3)
        val imgbutton = view as ImageButton

        when(imgbutton.id){

            R.id.select1 -> {
                TheGame(rndNumber)
                if (rndNumber == 1) WinUser()
                else LooseUser()

            }
            R.id.select2 -> {
                TheGame(rndNumber)
                if (rndNumber == 2) WinUser()
                else LooseUser()
            }

            R.id.select3 -> {
                TheGame(rndNumber)
                if (rndNumber == 3) WinUser()
                else LooseUser()
            }
        }

    }

    private fun TheGame(rndNumber: Int) {

        select1.setBackgroundColor(Color.TRANSPARENT)
        select2.setBackgroundColor(Color.TRANSPARENT)
        select3.setBackgroundColor(Color.TRANSPARENT)

        imageEnabled(false)


        if (rndNumber == 1){
            select1.setImageResource(R.drawable.btc)
        }
        else if (rndNumber == 2) {
            select2.setImageResource(R.drawable.btc)
        }
        else {
            select3.setImageResource(R.drawable.btc)
        }


    }

    private fun imageEnabled(bools: Boolean) {
        select1.isEnabled = bools
        select2.isEnabled = bools
        select3.isEnabled = bools
    }

    private fun LooseUser() {
        txtResult.text="KAYBETTİNİZ !"
        val hak = totalMoney--
        if (hak == 0){

            totalMoney = 0
        }
        txtCredit.text="Krediniz: "+totalMoney.toString()+" BTC"
        txtResult.setTextColor(Color.RED)

    }

    private fun WinUser() {
        txtResult.text="KAZANDINIZ !"
        totalMoney++
        txtCredit.text="Krediniz: "+totalMoney.toString()+" BTC"
        txtResult.setTextColor(Color.GREEN)

    }
}



