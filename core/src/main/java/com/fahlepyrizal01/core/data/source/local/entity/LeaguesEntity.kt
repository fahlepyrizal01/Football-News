package com.fahlepyrizal01.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leagues")
data class LeaguesEntity (

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idLeague")
    val idLeague: String,

    @ColumnInfo(name = "strLeague")
    val strLeague: String?,

    @ColumnInfo(name = "strSport")
    val strSport: String?,

    @ColumnInfo(name = "strLeagueAlternate")
    val strLeagueAlternate: String?

)