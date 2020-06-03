package ru.g000sha256.ads_demo

import android.app.Application
import ru.g000sha256.ads_demo.manager.AdsManager
import ru.g000sha256.scheduler.MainSchedulerFactoryImpl
import ru.g000sha256.schedulers.SchedulersHolder
import ru.g000sha256.schedulers.SchedulersImpl

class MainApplication : Application() {

    val adsManagerWithGoogle by lazy { AdsManager(false, this, schedulersHolder) }
    val adsManagerWithMock by lazy { AdsManager(true, this, schedulersHolder) }
    val schedulersHolder by lazy { createSchedulersHolder() }

    private fun createSchedulersHolder(): SchedulersHolder {
        val mainSchedulerFactory = MainSchedulerFactoryImpl()
        return SchedulersImpl(mainSchedulerFactory)
    }

}