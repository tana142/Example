package com.example.baseproject

import android.app.Application
import com.example.core.BuildConfig
import com.example.setting.model.Ahihi
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication @Inject constructor() : Application() {

    @Inject
    lateinit var ahihi: Ahihi

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}