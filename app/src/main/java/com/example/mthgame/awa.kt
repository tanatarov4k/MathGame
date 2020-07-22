package com.example.mthgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_awa.*

class awa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_awa)
        var wrongJuwaplarSani = intent.getIntExtra(ush.WRONG_ANSWERS_COUNT,0)
        var rightJuwaplarSani = intent.getIntExtra(ush.RIGHT_ANSWERS_COUNT,0)
        text1234.text = "Duris juwap: $rightJuwaplarSani\nQa'te juwap: $wrongJuwaplarSani"
        buttonAwa.setOnClickListener {
            val intento = Intent(this,eki::class.java)
            intento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intento)
            finish()
        }
        buttonAwaShiq.setOnClickListener {
            val intento = Intent(this,MainActivity::class.java)
            intento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intento)
            finish()
        }
    }
}