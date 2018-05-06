package com.hopeisaprison.ru.moxysample.di.modules

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.hopeisaprison.ru.moxysample.data.network.ApiEndPoint
import com.hopeisaprison.ru.moxysample.data.network.GithubApi
import com.hopeisaprison.ru.moxysample.di.PerActivity
import com.hopeisaprison.ru.moxysample.ui.about.AboutInteractor
import com.hopeisaprison.ru.moxysample.ui.about.AboutPresenter
import com.hopeisaprison.ru.moxysample.ui.signin.SignInInteractor
import com.hopeisaprison.ru.moxysample.ui.signin.SignInPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by hopeisaprison on 24.02.18.
 */

@Module
class ActivityModule(private val mContext: Context) {

    @Provides
    fun context() = mContext

    @Provides
    fun compositeDisposable() = CompositeDisposable()

    @PerActivity
    @Provides
    fun signInPresenter(compositeDisposable: CompositeDisposable, signInInteractor: SignInInteractor)
            = SignInPresenter(compositeDisposable, signInInteractor)

    @PerActivity
    @Provides
    fun aboutPresenter(compositeDisposable: CompositeDisposable, aboutInteractor: AboutInteractor)
            = AboutPresenter(compositeDisposable, aboutInteractor)



    @Provides
    @PerActivity
    fun retrofit(gsonConverterFactory: GsonConverterFactory, rxJavaConverterFactory: RxJava2CallAdapterFactory) = Retrofit.Builder()
            .baseUrl(ApiEndPoint.GITHUB_API_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJavaConverterFactory)
            .build()

    @Provides
    @PerActivity
    fun githubApi(retrofit: Retrofit) = retrofit.create(GithubApi::class.java)


    @Provides
    @PerActivity
    fun converterFactory() = GsonConverterFactory.create()

    @Provides
    @PerActivity
    fun rxJavaConverterFactory() = RxJava2CallAdapterFactory.create()
}