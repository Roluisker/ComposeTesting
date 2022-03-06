package com.android.testing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.testing.ui.TestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingTheme {
                MainScreenCounter(MainViewModel())
            }
        }
    }
}

@Composable
fun MainScreenCounter(mainViewModel: MainViewModel) {
    val counter by mainViewModel.counter.observeAsState(0)
    val context = LocalContext.current.applicationContext

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Button(
            onClick = { mainViewModel.counterIncrement() }) {
            Text(stringResource(id = R.string.increment_number))
        }
        Text(
            text = stringResource(id = R.string.clicks, counter)
        )
        Button(
            onClick = { launchSecondActivity(context = context) }) {
            Text(stringResource(id = R.string.second_screen))
        }
    }
}

@VisibleForTesting
@Composable
fun MainScreen(message: String) {
    Text(text = message)
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen("Aloha")
}
