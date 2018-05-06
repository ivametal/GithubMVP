package com.hopeisaprison.ru.moxysample.ui.signin

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import com.hopeisaprison.ru.moxysample.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by hopeisaprison on 24.02.18.
 */
interface ISignInPresenter {
    fun startSignIn()

    fun init()

    abstract fun onReceiveToken(code: String)
}