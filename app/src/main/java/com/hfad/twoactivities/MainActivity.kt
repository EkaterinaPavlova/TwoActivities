package com.hfad.twoactivities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hfad.twoactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val LOG_TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
    }

    fun launchSecondActivity(view: android.view.View) {
        Log.d(LOG_TAG, "Button clicked!")

        val intent = Intent(applicationContext, SecondActivity::class.java)
        val text = binding.editTextMain.text
        intent.putExtra(EXTRA_MESSAGE, text.toString())
        startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
    }

}