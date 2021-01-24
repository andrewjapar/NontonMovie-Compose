package dev.andrewjap.nontonmovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dev.andrewjap.nontonmovie.presentation.ui.home.component.TestScreen

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestScreen()
        }
    }
}