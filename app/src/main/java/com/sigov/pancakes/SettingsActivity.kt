package com.sigov.pancakes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    var timer1Value = 0
    var timer2Value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        timer1Value = intent.getIntExtra(MainActivity.FIRST_TIMER, 0)
        textView_timer1.text = intent.getIntExtra(MainActivity.FIRST_TIMER, 0).toString()

        timer2Value = intent.getIntExtra(MainActivity.SECOND_TIMER, 0)
        textView_timer2.text = intent.getIntExtra(MainActivity.SECOND_TIMER, 0).toString()
    }

    fun onSaveButton(view: View){
        val intent = Intent()
        intent.putExtra(MainActivity.FIRST_TIMER, Integer.parseInt(textView_timer1.text.toString()) )
        intent.putExtra(MainActivity.SECOND_TIMER, Integer.parseInt(textView_timer2.text.toString()))

        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    fun button_minus_5_t1_Click(view: View){
        if (timer1Value >= 5) timer1Value -= 5
        textView_timer1.text = timer1Value.toString()
    }

    fun button_minus_1_t1_Click(view: View){
        if (timer1Value >= 1) timer1Value -= 1
        textView_timer1.text = timer1Value.toString()
    }

    fun button_plus_1_t1_Click(view: View){
        timer1Value += 1
        textView_timer1.text = timer1Value.toString()
    }

    fun button_plus_5_t1_Click(view: View){
        timer1Value += 5
        textView_timer1.text = timer1Value.toString()
    }

    fun button_minus_5_t2_Click(view: View){
        if (timer2Value >= 5) timer2Value -= 5
        textView_timer2.text = timer2Value.toString()
    }

    fun button_minus_1_t2_Click(view: View){
        if (timer2Value >= 1) timer2Value -= 1
        textView_timer2.text = timer2Value.toString()
    }

    fun button_plus_1_t2_Click(view: View){
        timer2Value += 1
        textView_timer2.text = timer2Value.toString()
    }

    fun button_plus_5_t2_Click(view: View){
        timer2Value += 5
        textView_timer2.text = timer2Value.toString()
    }
}