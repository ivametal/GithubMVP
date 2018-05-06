package com.hopeisaprison.ru.moxysample.ui.signin

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.*

/**
 * Created by hopeisaprison on 14.01.18.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface ISignInView : MvpView {

    fun showError(exc: Throwable)


    @StateStrategyType(SkipStrategy::class)
    fun attemptLogin()

    @StateStrategyType(AddToEndStrategy::class)
    fun configWebView()

    @StateStrategyType(AddToEndStrategy::class)
    fun showOauth(oauthUrl: String)

    @StateStrategyType(SkipStrategy::class)
    fun startAboutActivity()



}