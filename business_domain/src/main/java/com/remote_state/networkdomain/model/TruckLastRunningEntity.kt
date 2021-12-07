package com.remote_state.networkdomain.model


data class TruckLastRunningEntity(
    var stopStartTime: Long? = null,
    var truckRunningState: Int? = null,
)