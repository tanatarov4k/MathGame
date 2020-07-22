package com.example.mthgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_ush.*
import kotlin.random.Random

class ush : AppCompatActivity() {
    private var ss:Int = 0
    private var dj:Int = 0
    private var qj:Int = 0
    private var juwap : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ush)
        ss = intent.getIntExtra("qq",0)
        playGGG()
    }
    fun selected(view: View){
        if (ss != dj + qj) {
            if ((view as Button).text == juwap.toString()) {
                dj++
                djtext.text = "Duris juwaplar: $dj"
                qjtext.text = "Qa'te juwaplar: $qj"
                playGGG()
            } else {
                qj++
                djtext.text = "Duris juwaplar: $dj"
                qjtext.text = "Qa'te juwaplar: $qj"
                if (qj == 3){
                    val intento = Intent(this,yaq::class.java)
                    startActivity(intento)
                    finish()
                }else{
                    playGGG()
                }
            }
        }else if (ss == dj + qj){
            val intento = Intent(this,awa::class.java)
            startActivity(intento)
            finish()
        }
    }
    private fun playGGG(){
        generateQuestions()
        generateWrongQuestions(buttonA)
        generateWrongQuestions(buttonB)
        generateWrongQuestions(buttonC)
        generateWrongQuestions(buttonD)
        generateRightAnswers()
    }
    private fun generateRandom(start:Int,end:Int):Int = Random.nextInt(start,end)
    private fun generateQuestions(){
        var san1 : Int = generateRandom(10,100)
        var san2 : Int = generateRandom(10,100)
        when(generateRandom(0,4)){
            0->{
                tvText.text = "$san1 + $san2"
                juwap = san1 + san2
            }
            1->{
                if (san1<=san2){
                    san1=san2.also { san2=san1 }
                }
                if (san1 - san2 <= 10){
                    san1 += 13
                }
                tvText.text = "$san1 - $san2"
                juwap = san1 - san2
            }
            2->{
                if (san2/10!=0){
                    san2 = san2 % 10
                }
                san2++
                tvText.text = "$san1 * $san2"
                juwap = san1 * san2
            }
            3->{
                if (san1<=san2){
                    san1=san2.also { san2=san1 }
                }
                if (san1%san2!=0){
                    for (i in 9..san1){
                        if (san1%i==0){
                            san2=i
                            break
                        }
                    }
                }
                tvText.text = "$san1 / $san2"
                juwap = san1 / san2
            }
            else->{
                tvText.text = "$san1 = $san2"
                juwap = san1 * san2
            }
        }
    }
    private fun generateWrongQuestions(butto:View){
        when(generateRandom(0,4)){
            0->(butto as Button).text = (juwap + generateRandom(1,10)).toString()
            1->(butto as Button).text = (juwap + generateRandom(11,20)).toString()
            2->(butto as Button).text = (juwap + generateRandom(21,30)).toString()
            3->(butto as Button).text = (juwap + generateRandom(31,40)).toString()
            else->(butto as Button).text = (juwap + generateRandom(31,60)).toString()
        }
    }
    private fun generateRightAnswers() {
        when (generateRandom(0, 4)) {
            0 -> buttonA.text = juwap.toString()
            1 -> buttonB.text = juwap.toString()
            2 -> buttonC.text = juwap.toString()
            3 -> buttonD.text = juwap.toString()
            else -> buttonA.text = juwap.toString()
        }
    }
}