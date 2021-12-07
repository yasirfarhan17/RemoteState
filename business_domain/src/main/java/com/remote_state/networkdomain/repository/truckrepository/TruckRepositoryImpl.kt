package com.remote_state.networkdomain.repository.truckrepository

import com.remote_state.networkdomain.api.TrucksApi
import com.remote_state.networkdomain.model.TruckDto
import javax.inject.Inject

class TruckRepositoryImpl @Inject constructor(
    private val trucksApi: TrucksApi
) : TruckRepository {
    override suspend fun getAllTrucks():TruckDto = trucksApi.getTruckList()
}
