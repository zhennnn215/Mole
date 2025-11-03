package tw.edu.pu.csim.tcyang.mole.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class MoleViewModel : ViewModel(){
    var counter by mutableLongStateOf(0)
        private set
    fun incrementCounter() {
        counter++
    }
}