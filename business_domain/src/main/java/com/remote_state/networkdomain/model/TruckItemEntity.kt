package com.remote_state.networkdomain.model

import android.os.Parcelable
import com.remote_state.networkdomain.model.LastRunningState
import com.remote_state.networkdomain.model.LastWaypointDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class TruckItemEntity(
    var truckNumber: String? = null,
    var lastWaypoint: LastWaypointDto? = null,
    var lastRunningState: LastRunningState? = null,
    var deactivated: Boolean? = null,
    var id: Int? = null
):Parcelable