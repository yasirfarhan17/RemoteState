package com.remote_state.networkdomain.repository.truckrepository

import com.remote_state.networkdomain.model.TruckDto

interface TruckRepository {
    suspend fun getAllTrucks(): TruckDto
}