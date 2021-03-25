package com.sigov.pancakes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        textView_timer1.text = intent.getIntExtra(MainActivity.FIRST_TIMER, 0).toString()
    }

    fun onSaveButton(view: View){
        val intent = Intent()
        intent.putExtra(MainActivity.FIRST_TIMER, Integer.parseInt(textView_timer1.text.toString()) )
        //intent.putExtra(MainActivity.SECOND_TIMER, Integer.parseInt(textNumber2.text.toString()))

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}