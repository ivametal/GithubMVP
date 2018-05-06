package com.hopeisaprison.ru.moxysample.di.components

import android.app.Activity
import com.hopeisaprison.ru.moxysample.di.modules.ActivityModule
import com.hopeisaprison.ru.moxysample.di.PerActivity
import com.hopeisaprison.ru.moxysample.ui.about.AboutActivity
import com.hopeisaprison.ru.moxysample.ui.signin.SignInActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by hopeisaprison on 24.02.18.
 */


@PerActivity
@Component(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: SignInActivity)

    fun inject(activity: AboutActivity)
}