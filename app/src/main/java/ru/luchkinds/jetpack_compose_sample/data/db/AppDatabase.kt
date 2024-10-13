package ru.luchkinds.jetpack_compose_sample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.luchkinds.jetpack_compose_sample.data.entities.SampleDbEntity

@Database(entities = [SampleDbEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun sampleDao(): SampleDao
}