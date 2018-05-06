package com.hopeisaprison.ru.moxysample.ui.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by hopeisaprison on 04.03.18.
 */
open class BasePresenter<T: MvpView> constructor(var compositeDisposable: CompositeDisposable) : MvpPresenter<T>() {



    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.dispose()
    }
}