package com.example.android_assignment.interfaces

import kotlinx.coroutines.flow.Flow

interface IDownLoaderHelper {
    fun getImages4(): Flow<List<String>>
    fun getImagesNext4(): Flow<List<String>>
    fun getImages1(): Flow<List<String>>
    fun getImagesNext1(): Flow<List<String>>
}
