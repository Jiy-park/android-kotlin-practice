package com.dd2d.splash

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.dd2d.splash.ui.theme.KotlinpracticeTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var onSplashScreen = true
        get() {
//            onSplashScreen 값이 false 가 될 때까지 로그가 찍힘
            Log.d("LOG_CHECK", "MainViewModel :: () -> 1")
            return field
        }

    init {
        viewModelScope.launch {
            delay(3000)
            onSplashScreen = false
        }
    }
}

class MainActivity : ComponentActivity() {
    private val vm = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
//            스플래시 화면을 지속할 필요가 있는지에 대한 여부.
//            람다로 넘겨주는 값이 false인 경우 다음 화면으로 넘어감.
//            이때 스플래시 화면은 매번 람다로 넘겨주는 값을 확인하게 됨. -> vm.onSplashScreen 값을 매번 확인하게 되면서 다음 화면으로 진행 전까지 로그가 찍히게 됨.
            setKeepOnScreenCondition {
                vm.onSplashScreen
            }
        }

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