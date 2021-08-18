package com.rodriguez.giomar.laradio

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rodriguez.giomar.laradio.exoplayer.MusicService
import com.rodriguez.giomar.laradio.navigation.Navigation
import com.rodriguez.giomar.laradio.ui.theme.LaRadioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaRadioTheme(
                darkTheme = true,
            ) {
               Navigation()
            }
        }
    }
}
