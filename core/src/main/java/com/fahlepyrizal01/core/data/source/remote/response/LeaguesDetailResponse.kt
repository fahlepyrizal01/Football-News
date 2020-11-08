package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class LeaguesDetailResponse(

    @field:SerializedName("leagues")
    val leagues: List<LeagueDetailResponse>

)