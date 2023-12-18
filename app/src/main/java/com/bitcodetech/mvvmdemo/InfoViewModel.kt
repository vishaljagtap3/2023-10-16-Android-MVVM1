package com.bitcodetech.mvvmdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Random


class InfoViewModel(
    private val infoRepository: InfoRepository
) : ViewModel() {

    //var info : String = "" //this is not observable
    val infoLiveData = MutableLiveData<String>()

    //tight coupling
    /*private val infoRepository : InfoRepository
    init {
        infoRepository = InfoRepository()
    }*/

    fun fetchInfo() {
        //connect to web server/database
        //get the info and load it to info variable

        CoroutineScope(Dispatchers.IO).launch {
            Thread.sleep(2000)

            val info = infoRepository.fetchInfo()

            withContext(Dispatchers.Main) {
                infoLiveData.postValue(info)
            }
        }

    }

}