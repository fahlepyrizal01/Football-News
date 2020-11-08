package com.fahlepyrizal01.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(

    val idLeague: String,
    val strLeague: String?,
    val strSport: String?,
    val strLeagueAlternate: String?

) : Parcelable