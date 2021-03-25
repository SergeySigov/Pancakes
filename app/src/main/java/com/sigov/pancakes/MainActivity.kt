package com.sigov.pancakes

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable:Runnable
    private var handler: Handler = Handler()
    private var pause:Boolean = false

    var firstTimer = 30
    var firstTimerCounter = 30
    var firstStarted = false
    var secondTimer = 40
    var secondTimerCounter = 40
    var secondStarted = false

    companion object{
        const val FIRST_TIMER = "firstTimer"
        const val SECOND_TIMER = "secondTimer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.text = firstTimer.toString()
        button2.text = secondTimer.toString()

    }

    fun onSetting(view: View){
        val settingsIntent = Intent(this, SettingsActivity::class.java)
        settingsIntent.putExtra(FIRST_TIMER, firstTimer)
        settingsIntent.putExtra(SECOND_TIMER, secondTimer)
        startActivityForResult(settingsIntent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data != null) {
            firstTimer = data.getIntExtra(FIRST_TIMER, 0)
            secondTimer = data.getIntExtra(SECOND_TIMER, 0)
        }

        button1.text = firstTimer.toString()
        button2.text = secondTimer.toString()
        super.onActivityResult(requestCode, resultCode, data)
    }



    fun btn1Click(view: View){
        if(!firstStarted) {
            firstStarted = true
            val timer1 = object : CountDownTimer(firstTimer * 1000L, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    if(firstStarted){
                        button1.text = firstTimerCounter.toString()
                        firstTimerCounter--
                    } else {
                        cancel()
                    }
                }

                override fun onFinish() {
                    button1.text = firstTimer.toString()
                    firstStarted = false
                    playsound()
                }
            }
            firstTimerCounter = firstTimer
            timer1.start()
        } else {
            firstStarted = false
            firstTimerCounter = firstTimer
            button1.text = firstTimerCounter.toString()
        }
    }



    fun btn2Click(view: View){
        if(!secondStarted) {
            secondStarted = true
            var timer2 = object: CountDownTimer(secondTimer * 1000L, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    if(secondStarted){
                        button2.text = secondTimerCounter.toString()
                        secondTimerCounter--
                    } else {
                        cancel()
                    }

                }

                override fun onFinish() {
                    button2.text = secondTimer.toString()
                    secondStarted = false
                    playsound()
                }
            }
            secondTimerCounter = secondTimer

            timer2.start()
        } else {
            secondStarted = false
            secondTimerCounter = secondTimer
            button2.text = secondTimerCounter.toString()
        }
    }
    fun createSinWaveBuffer(freq: Double, ms: Int, sampleRate: Int = 44100): ByteArray {
        val samples = (ms * sampleRate / 1000)
        val output = ByteArray(samples)
        val period = sampleRate.toDouble() / freq
        for (i in output.indices) {
            val angle = 2.0 * Math.PI * i.toDouble() / period
            output[i] = (Math.sin(angle) * 127f).toByte()
        }
        //output.forEach { println(it) }
        return output
    }

    fun playsound() {
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.school_bell)
        mediaPlayer.start()
        Toast.makeText(this,"media playing",Toast.LENGTH_SHORT).show()
    }


}