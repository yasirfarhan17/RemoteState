package com.remote_state.networkdomain.model

import com.remote_state.networkdomain.model.LastWaypointDto

data class TruckLastWayEntity(
    var lng: Double? = null,
    var lat: Double? = null,
    var createTime: Long? = null,
    var speed: Double? = null,
    var updateTime: Long? = null,
    var ignitionOn: Boolean? = null,
    var id: Int? = null,
)