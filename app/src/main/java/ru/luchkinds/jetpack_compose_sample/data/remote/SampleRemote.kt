package ru.luchkinds.jetpack_compose_sample.data.remote

import retrofit2.http.GET
import ru.luchkinds.jetpack_compose_sample.data.entities.SampleApiEntity
import ru.luchkinds.jetpack_compose_sample.data.entities.SampleDbEntity

interface SampleRemote {
    @GET("posts")
    suspend fun loadRows(): List<SampleApiEntity>
}