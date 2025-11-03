package tw.edu.pu.csim.tcyang.mole

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tw.edu.pu.csim.tcyang.mole.ui.theme.MoleTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MoleViewModel : ViewModel() {
    var counter by mutableStateOf(0L)  // 用來保存計數器的狀態
        private set

    fun incrementCounter() {
        counter++  // 點擊時增加計數
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoleTheme {
                MoleScreen()
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun MoleScreen(moleViewModel: MoleViewModel = viewModel()) {
    val counter = moleViewModel.counter
    Box (
        modifier = Modifier.fillMaxSize(),
        Alignment.Center
    ) {
        Text(counter.toString())
    }

    Image(
        painter = painterResource(id = R.drawable.mole),
        contentDescription = "地鼠",
        modifier = Modifier
            .offset { IntOffset(50, 200) }
            .size(150.dp)
            .clickable { moleViewModel.incrementCounter() }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoleTheme {
        Greeting("Android")
    }
}