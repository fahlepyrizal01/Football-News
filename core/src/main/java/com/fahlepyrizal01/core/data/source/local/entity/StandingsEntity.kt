package com.fahlepyrizal01.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "standings")
data class StandingsEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "teamid")
    val teamid: String,

    @NonNull
    @ColumnInfo(name = "idLeague")
    val idLeague: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "played")
    val played: Int?,

    @ColumnInfo(name = "goalsfor")
    val goalsfor: Int?,

    @ColumnInfo(name = "goalsagainst")
    val goalsagainst: Int?,

    @ColumnInfo(name = "goalsdifference")
    val goalsdifference: Int?,

    @ColumnInfo(name = "win")
    val win: Int?,

    @ColumnInfo(name = "draw")
    val draw: Int?,

    @ColumnInfo(name = "loss")
    val loss: Int?,

    @ColumnInfo(name = "total")
    val total: Int?,

)