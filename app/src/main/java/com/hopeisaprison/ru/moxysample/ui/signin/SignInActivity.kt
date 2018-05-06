package com.hopeisaprison.ru.moxysample.ui.signin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hopeisaprison.ru.moxysample.R
import com.hopeisaprison.ru.moxysample.ui.about.AboutActivity
import com.hopeisaprison.ru.moxysample.ui.base.BaseActivity

import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class SignInActivity : BaseActivity(), ISignInView {



    @Inject
    lateinit var mDaggerPresenter: SignInPresenter
    @ProvidePresenter get

    @InjectPresenter
    lateinit var mSignInPresenter : SignInPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        mActivityComponent.inject(this)

        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_login)



        btn_login.setOnClickListener { attemptLogin() }

        supportActionBar?.hide()

        mSignInPresenter.init()

    }

    override fun startAboutActivity() {
        startActivity(Intent(this, AboutActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
    }


    override fun showOauth(oauthUrl: String) {
        wv_login.visibility = View.VISIBLE
        btn_login.visibility = View.INVISIBLE

        wv_login.loadUrl(oauthUrl)
    }

    override fun showError(exc: Throwable) {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }




    override fun attemptLogin() {
        mSignInPresenter.startSignIn()
    }

    override fun configWebView() {

        wv_login.settings.javaScriptEnabled = true
        wv_login.settings.useWideViewPort = true
        wv_login.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                if (request.url != null && request.url.toString().contains("?code="))
                    return false

                val code = request.url.toString().substring(request.url.toString().lastIndexOf("?code=") + 1)

                val tokenCode = code.split('=')
                val tokenFetchedIs = tokenCode[1]
                val cleanToken = tokenFetchedIs.split('&')

                mSignInPresenter.onReceiveToken(cleanToken[0])

                return true
            }
        }
    }
}
