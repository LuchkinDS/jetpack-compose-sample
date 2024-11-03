package ru.luchkinds.jetpack_compose_sample.data.db

import androidx.room.Dao
import androidx.room.Query
import ru.luchkinds.jetpack_compose_sample.data.entities.SampleDbEntity

@Dao
interface SampleDao {
    @Query("select * from table_name")
    fun getRows(): List<SampleDbEntity>

    @Query("select * from table_name where id = :id")
    fun getRowBtId(id: Long): SampleDbEntity
}