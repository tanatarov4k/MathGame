package com.example.mthgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_eki.*

class eki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eki)
    }
    fun basildi(butto:View){
        val intento = Intent(this,ush::class.java)
        intento.putExtra("qq", (butto as Button).text.toString().toInt())
        startActivity(intento)
    }
}