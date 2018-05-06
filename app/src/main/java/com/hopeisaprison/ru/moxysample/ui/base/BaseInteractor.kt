package com.hopeisaprison.ru.moxysample.ui.base


import com.hopeisaprison.ru.moxysample.data.network.GithubApi
import com.hopeisaprison.ru.moxysample.di.components.DaggerGithubComponent
import com.hopeisaprison.ru.moxysample.di.modules.GithubModule
import javax.inject.Inject

/**
 * Created by hopeisaprison on 25.03.18.
 */
open class BaseInteractor @Inject constructor(val githubApi: GithubApi) {

}