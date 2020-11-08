package com.fahlepyrizal01.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fahlepyrizal01.core.data.source.local.entity.*

@Database(
    entities = [
        LeaguesEntity::class,
        LeagueEntity::class,
        StandingsEntity::class,
        TeamsEntity::class,
        LastEventsEntity::class,
        NextEventsEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class FootballDatabase : RoomDatabase() {

    abstract fun footballDao(): FootballDao

}