package com.example.android_assignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_assignment.interfaces.DownloadLoaderImpl
import com.example.android_assignment.interfaces.IDownLoaderHelper
import kotlinx.coroutines.*

class DownloaderViewModel : ViewModel() {
    private val downloaderHelper: IDownLoaderHelper = DownloadLoaderImpl()
    val images: MutableLiveData<ArrayList<String>> = MutableLiveData()

    // 4 images , 4 images , 2 images async await (coroutine series)
    init {
        viewModelScope.launch {
            val fourImages = withContext(Dispatchers.IO) {
                delay(1000)
                downloaderHelper.getImages4()
            }
            images.value = fourImages as ArrayList<String>

            val nextFourImages = withContext(Dispatchers.IO) {
                delay(2000)
                downloaderHelper.getImagesNext4()
            }
            images.value = nextFourImages as ArrayList<String>

            val oneImage = async {
                delay(3000)
                downloaderHelper.getImages1()
            }
            val lastImage = async {
                delay(4000)
                downloaderHelper.getImagesNext1()
            }

            val result1 = oneImage.await()
            val result2 = lastImage.await()
            images.value = result1 as ArrayList<String>
            images.value = result2 as ArrayList<String>
        }
    }
}
