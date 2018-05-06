package com.hopeisaprison.ru.moxysample.ui.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.hopeisaprison.ru.moxysample.App
import com.hopeisaprison.ru.moxysample.R
import com.hopeisaprison.ru.moxysample.di.components.ActivityComponent
import com.hopeisaprison.ru.moxysample.di.components.DaggerActivityComponent
import com.hopeisaprison.ru.moxysample.di.components.DaggerGithubComponent
import com.hopeisaprison.ru.moxysample.di.components.GithubComponent
import com.hopeisaprison.ru.moxysample.di.modules.ActivityModule
import com.hopeisaprison.ru.moxysample.di.modules.GithubModule

/**
 * Created by hopeisaprison on 24.02.18.
 */
open class BaseActivity: MvpAppCompatActivity(), IBaseView {


    var mActivityComponent: ActivityComponent
    private set

    init {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(App.appComponent.context()))
                .build()
    }


    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showError(msg: String) {
        val snackbar = Snackbar.make(findViewById<View>(android.R.id.content),
                msg, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView
                .findViewById(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.show()
    }

    override fun onDestroy() {
        super.onDestroy()


    }




}