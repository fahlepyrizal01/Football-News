package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TeamsResponse(

    @field:SerializedName("teams")
    val teams: List<TeamResponse>

)