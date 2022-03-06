package com.android.testing

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.android.testing.ui.TestingTheme

fun launchSecondActivity(context: Context) {
    Intent(context, SecondActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }.let {
        context.startActivity(it)
    }
}

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingTheme {
                Text(
                    text = "Aloha"
                )
            }
        }
    }
}

