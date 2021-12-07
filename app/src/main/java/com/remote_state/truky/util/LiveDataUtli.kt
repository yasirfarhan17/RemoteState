package com.remote_state.truky.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.toLiveData(): LiveData<T> = this