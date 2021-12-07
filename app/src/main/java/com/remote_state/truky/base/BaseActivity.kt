package com.glocal.techsupport.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.remote_state.truky.base.Navigator
import com.remote_state.truky.util.UiUtil

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: B
    lateinit var navigator: Navigator
    protected lateinit var uiUtil: UiUtil


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindContentView(layoutId())
        navigator = Navigator(this)
        uiUtil = UiUtil(this)
        // observeViewState()
        addObservers()
    }

/*
    private fun observeViewState() {
        viewModel.viewState
            .observe(this, {
                when (it) {
                    ViewState.Idle -> {
                    }
                    ViewState.Loading -> {
                        showProgress()
                    }
                    is ViewState.Success -> {
                        hideProgress()
                        showMessage(it.message)
                    }
                    is ViewState.StopLoading -> {
                        hideProgress()
                    }
                    is ViewState.StartLoading -> {
                        hideProgress()
                    }
                    is ViewState.Error -> {
                        hideProgress()
                        handleException(it.throwable)
                    }
                }
            })
    }
*/

    private fun handleException(throwable: Throwable?) {
        showMessage(throwable?.message)
    }


    private fun bindContentView(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    @LayoutRes
    abstract fun layoutId(): Int


    //abstract fun getViewModelClass(): Class<VM>

    abstract fun addObservers()

    protected fun showProgress() {
        //  uiUtil.showProgress()
    }

    protected fun hideProgress() {
        //  uiUtil.hideProgress()
    }

    protected fun showMessage(
        message: String?,
        button: Boolean = false,
        buttonText: String = "Ok"
    ) {
        message?.let { uiUtil.showMessage(it, button = button, buttonText = buttonText) }
    }

    protected fun showToast(
        message: String?,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        message?.let { uiUtil.showToast(it, duration) }
    }

    fun getLayoutBinding() = binding

}