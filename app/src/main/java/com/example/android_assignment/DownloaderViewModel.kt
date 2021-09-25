package com.example.android_assignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_assignment.utils.DownloadLoaderImpl
import com.example.android_assignment.interfaces.IDownLoaderHelper
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip

class DownloaderViewModel : ViewModel() {
    private val downloaderHelper: IDownLoaderHelper = DownloadLoaderImpl()
    val images: MutableLiveData<ArrayList<String>> = MutableLiveData()

    // 4 images , 4 images , 2 images parallel with zip
    init {
        viewModelScope.launch {
            downloaderHelper.getImages4().collect { firstFourImages->
                images.value = firstFourImages as ArrayList<String>
            }

            downloaderHelper.getImagesNext4().collect { nextFourImages->
                images.value = nextFourImages as ArrayList<String>
            }

            // parallel calls
            downloaderHelper.getImages1()
                .zip(downloaderHelper.getImagesNext1()) { usersFromApi, moreUsersFromApi ->
                    images.value = usersFromApi as ArrayList<String>
                    images.value = moreUsersFromApi as ArrayList<String>
                    return@zip images.value
                }
                .flowOn(Dispatchers.Default)
                .collect {
                    images.value = it
                }
        }
    }
}
