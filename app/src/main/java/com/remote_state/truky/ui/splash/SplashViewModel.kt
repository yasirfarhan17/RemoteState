package com.remote_state.truky.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remote_state.networkdomain.model.CoinsResponse
import com.remote_state.networkdomain.usecase.GetAllTrucksUseCase
import com.remote_state.networkdomain.network.Resources
import com.remote_state.truky.util.toLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAllTrucksUseCase: GetAllTrucksUseCase
) : ViewModel() {


    private val _setTruckList = MutableLiveData<List<CoinsResponse>>()
    val setTruckList = _setTruckList.toLiveData()

    private val _setError = MutableLiveData<String>()
    val setError = _setError.toLiveData()

    private val _setLoading = MutableLiveData<String>()
    val setLoading = _setLoading.toLiveData()

    init {
        getCoins()
    }

    private fun getCoins() {
        getAllTrucksUseCase().onEach { result ->
            when (result) {
                is Resources.Success -> {
//                    _setTruckList.postValue(result.data)
                }
                is Resources.Error -> {
                    _setError.postValue(result.message)
                }
                is Resources.Loading -> {
                    _setLoading.postValue(result.message)
                }
            }
        }.launchIn(viewModelScope)
    }
}

