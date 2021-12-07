package com.remote_state.networkdomain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinsResponse(
	val symbol: String,
	val isActive: Boolean,
	val isNew: Boolean,
	val name: String,
	val rank: Int,
	val id: String,
	val type: String
) : Parcelable

/*
{"id":"btc-bitcoin","name":"Bitcoin","symbol":"BTC","rank":1,"is_new":false,"is_active":true,"type":"coin"}
 */