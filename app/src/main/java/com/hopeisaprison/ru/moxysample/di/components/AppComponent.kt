package com.hopeisaprison.ru.moxysample.di.components

import android.content.Context
import com.hopeisaprison.ru.moxysample.di.modules.ContextModule
import dagger.Component

/**
 * Created by hopeisaprison on 19.02.18.
 */

@Component(modules = [ContextModule::class])
interface AppComponent {

    fun context(): Context
}