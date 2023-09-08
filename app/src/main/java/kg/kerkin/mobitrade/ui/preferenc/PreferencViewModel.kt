package kg.kerkin.mobitrade.ui.preferenc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.kerkin.mobitrade.FtpWebHost

class PreferencViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Мои настройкиии!"
    }
    val text: LiveData<String> = _text
}