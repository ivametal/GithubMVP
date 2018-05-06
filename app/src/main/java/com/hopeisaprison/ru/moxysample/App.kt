package com.hopeisaprison.ru.moxysample

import android.app.Application
import android.content.Context
import android.util.Log
import com.hopeisaprison.ru.moxysample.di.components.AppComponent
import com.hopeisaprison.ru.moxysample.di.components.DaggerAppComponent
import com.hopeisaprison.ru.moxysample.di.modules.ContextModule
import com.pixplicity.easyprefs.library.Prefs

/**
 * Created by hopeisaprison on 19.02.18.
 */
class App : Application() {

    companion object {
        @JvmStatic
        lateinit var appComponent : AppComponent
    }


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().contextModule(ContextModule(this)).build()


        Log.d("MY_TAG", "APPLICATION CLASS ONCREATE()")
        Prefs.Builder()
                .setContext(this)
                .setMode(Context.MODE_PRIVATE)
                .setPrefsName(packageName)
                .setUseDefaultSharedPreference(true)
                .build()

    }
}