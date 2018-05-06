package com.hopeisaprison.ru.moxysample.ui.signin

import com.arellomobile.mvp.InjectViewState
import com.hopeisaprison.ru.moxysample.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by hopeisaprison on 14.01.18.
 */

@InjectViewState
class SignInPresenter constructor(val mCompositeDisposable: CompositeDisposable, val mSignInInteractor: SignInInteractor) : BasePresenter<ISignInView>(mCompositeDisposable), ISignInPresenter {

    private val URL_AUTORIZATION  = "https://github.com/login/oauth/authorize?client_id=d21dba5a929a3d2a81f4"



    override fun startSignIn() {
        viewState.showOauth(URL_AUTORIZATION)
    }

    override fun init() {


        viewState.configWebView()
    }

    override fun onReceiveToken(token: String) {
        mSignInInteractor.saveTokenInPref(token)
        viewState.startAboutActivity()
    }
}