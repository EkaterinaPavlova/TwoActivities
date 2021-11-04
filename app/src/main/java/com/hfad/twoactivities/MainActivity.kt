package com.hfad.twoactivities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.transition.Visibility
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

        val intent = Intent(this, SecondActivity::class.java)
        val text = binding.editTextMain.text.toString()
        intent.putExtra(EXTRA_MESSAGE, text)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                val replyMessage = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                binding.textHeaderReply.visibility = View.VISIBLE
                binding.textMessageReply.text = replyMessage
                binding.textMessageReply.visibility = View.VISIBLE

            }
        }
    }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
        const val TEXT_REQUEST = 1

    }

}