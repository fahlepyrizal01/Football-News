package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class StandingResponse(

    @field:SerializedName("teamid")
    val teamid: String,

    @field:SerializedName("name")
    val name: String?,

    @field:SerializedName("played")
    val played: Int?,

    @field:SerializedName("goalsfor")
    val goalsfor: Int?,

    @field:SerializedName("goalsagainst")
    val goalsagainst: Int?,

    @field:SerializedName("goalsdifference")
    val goalsdifference: Int?,

    @field:SerializedName("win")
    val win: Int?,

    @field:SerializedName("draw")
    val draw: Int?,

    @field:SerializedName("loss")
    val loss: Int?,

    @field:SerializedName("total")
    val total: Int?,

)