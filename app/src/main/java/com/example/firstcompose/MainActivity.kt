package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fcom.core.designsystem.theme.FirstComposeTheme
import com.fcom.core.data.managers.NetworkManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkManager: NetworkManager

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.fcom.core.designsystem.theme.FirstComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android", viewModel = viewModel)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val topicUiState: MainActivityUIState by viewModel.uiState.collectAsStateWithLifecycle()
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    com.fcom.core.designsystem.theme.FirstComposeTheme {
        //Greeting("Android", MainViewModel(UserDataRepository(OfflineUserDataRepository())))
    }
}