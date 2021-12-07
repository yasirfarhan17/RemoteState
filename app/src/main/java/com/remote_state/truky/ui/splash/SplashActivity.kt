package com.remote_state.truky.ui.splash

import android.os.Bundle
import android.os.Handler
import com.glocal.techsupport.ui.base.BaseActivity
import com.remote_state.truky.R
import com.remote_state.truky.databinding.ActivitySplashBinding
import com.remote_state.truky.ui.listactivity.ListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashhActivity : BaseActivity<ActivitySplashBinding>() {

    override fun layoutId(): Int = R.layout.activity_splash
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed(Runnable {
            navigator.startActivity(ListActivity::class.java)
            finish()
        }, 2000)
    }

    override fun addObservers() = Unit

}

