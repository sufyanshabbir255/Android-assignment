package com.example.android_assignment.utils

import com.example.android_assignment.interfaces.IDownLoaderHelper
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DownloadLoaderImpl : IDownLoaderHelper {

    override fun getImages4(): Flow<List<String>> {
        return flow {
            emit(
                arrayListOf(
                    Utils.imagePath1,
                    Utils.imagePath2,
                    Utils.imagePath3,
                    Utils.imagePath4
                )
            )
            delay(1000)
        }
    }

    override fun getImagesNext4(): Flow<List<String>> {
        return flow {
            emit(
                arrayListOf(
                    Utils.imagePath5,
                    Utils.imagePath6,
                    Utils.imagePath7,
                    Utils.imagePath8
                )
            )
            delay(1000)
        }
    }

    override fun getImages1(): Flow<List<String>> {
        return flow { arrayListOf(Utils.imagePath9) }
    }

    override fun getImagesNext1(): Flow<List<String>> {
        return flow {  arrayListOf(Utils.imagePath10) }
    }
}