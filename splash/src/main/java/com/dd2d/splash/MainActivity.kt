package com.dd2d.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.dd2d.splash.ui.theme.KotlinpracticeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        이건 없어도 됨
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            KotlinpracticeTheme {
                App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {

}

@Preview
@Composable
private fun AppPreview() {
    App()
}