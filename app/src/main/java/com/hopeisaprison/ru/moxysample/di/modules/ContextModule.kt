package com.hopeisaprison.ru.moxysample.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by hopeisaprison on 19.02.18.
 */

@Module
class ContextModule(private val context: Context) {

    @Provides
    fun context() = context

}