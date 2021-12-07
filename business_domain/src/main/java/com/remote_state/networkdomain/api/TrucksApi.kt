package com.remote_state.networkdomain.api
import com.remote_state.networkdomain.model.TruckDto
import retrofit2.http.GET

interface TrucksApi {

    @GET(EndPoint.GET_TRUCK_LIST)
    suspend fun getTruckList(): TruckDto
}
