package com.example.firstcompose

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class FCOMApplication : Application(), ImageLoaderFactory {

    @Inject
    lateinit var imageLoader: dagger.Lazy<ImageLoader>
    override fun onCreate() {
        super.onCreate()
        //empty impl
    }

    override fun newImageLoader(): ImageLoader = imageLoader.get()
}