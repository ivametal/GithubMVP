package com.hopeisaprison.ru.moxysample.ui.about

import com.hopeisaprison.ru.moxysample.data.network.model.Repository
import io.reactivex.Single
import retrofit2.Call

interface IAboutInteractor {

    fun getUserRepos(): Single<List<Repository>>
}