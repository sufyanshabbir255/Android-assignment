package com.example.android_assignment.interfaces

import com.example.android_assignment.utils.Utils

class DownloadLoaderImpl : IDownLoaderHelper {
    override fun getImages4(): List<String> {
        return arrayListOf(Utils.imagePath1, Utils.imagePath2, Utils.imagePath3, Utils.imagePath4)
    }

    override fun getImagesNext4(): List<String> {
        return arrayListOf(Utils.imagePath5, Utils.imagePath6, Utils.imagePath7, Utils.imagePath8)
    }

    override fun getImages1(): List<String> {
        return arrayListOf(Utils.imagePath9)
    }

    override fun getImagesNext1(): List<String> {
        return arrayListOf(Utils.imagePath10)
    }
}