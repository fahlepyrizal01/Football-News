package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LeagueResponse(

    @field:SerializedName("idLeague")
    val idLeague: String,

    @field:SerializedName("strLeague")
    val strLeague: String?,

    @field:SerializedName("strSport")
    val strSport: String?,

    @field:SerializedName("strLeagueAlternate")
    val strLeagueAlternate: String?,

)