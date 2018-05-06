package com.hopeisaprison.ru.moxysample.ui.signin

import com.hopeisaprison.ru.moxysample.data.network.GithubApi
import com.hopeisaprison.ru.moxysample.ui.base.BaseInteractor
import com.pixplicity.easyprefs.library.Prefs
import javax.inject.Inject

/**
 * Created by hopeisaprison on 24.02.18.
 */
class SignInInteractor @Inject constructor(githubApi: GithubApi) : BaseInteractor(githubApi), ISignInInteractor {


    override fun saveTokenInPref(token: String) {
        Prefs.putString("token", token)
    }


}