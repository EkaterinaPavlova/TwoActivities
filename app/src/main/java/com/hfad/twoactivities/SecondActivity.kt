package com.hfad.twoactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.twoactivities.MainActivity.Companion.EXTRA_MESSAGE
import com.hfad.twoactivities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        binding.textMessage.text = message

    }

    fun returnReply(view: android.view.View) {
        val replyIntent = Intent()
        val reply = binding.editTextSecond.text.toString()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    companion object {
        const val EXTRA_REPLY = "extra_reply"
    }
}