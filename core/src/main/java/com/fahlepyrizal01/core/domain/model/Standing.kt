package com.fahlepyrizal01.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Standing(

    val idLeague: String,
    val teamid: String,
    val name: String?,
    val played: Int?,
    val goalsfor: Int?,
    val goalsagainst: Int?,
    val goalsdifference: Int?,
    val win: Int?,
    val draw: Int?,
    val loss: Int?,
    val total: Int?

) : Parcelable