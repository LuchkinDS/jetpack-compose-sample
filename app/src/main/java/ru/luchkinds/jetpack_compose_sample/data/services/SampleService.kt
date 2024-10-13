package ru.luchkinds.jetpack_compose_sample.data.services

import retrofit2.http.GET
import ru.luchkinds.jetpack_compose_sample.data.entities.SampleDbEntity

interface SampleService {
    @GET("posts")
    suspend fun loadData(): List<SampleDbEntity>
}