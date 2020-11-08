package com.fahlepyrizal01.core.data.source.remote.response

import com.fahlepyrizal01.core.utils.Resource.EMPTY_STRING
import com.google.gson.annotations.SerializedName

data class LeagueDetailResponse (

    @field:SerializedName("idLeague")
    val idLeague: String,

    @field:SerializedName("dateFirstEvent")
    val dateFirstEvent: String?,

    @field:SerializedName("idAPIfootball")
    val idAPIfootball: String?,

    @field:SerializedName("idCup")
    val idCup: String?,

    @field:SerializedName("idSoccerXML")
    val idSoccerXML: String?,

    @field:SerializedName("intFormedYear")
    val intFormedYear: String?,

    @field:SerializedName("strBadge")
    val strBadge: String?,

    @field:SerializedName("strBanner")
    val strBanner: String?,

    @field:SerializedName("strComplete")
    val strComplete: String?,

    @field:SerializedName("strCountry")
    val strCountry: String?,

    @field:SerializedName("strCurrentSeason")
    val strCurrentSeason: String?,

    @field:SerializedName("strDescriptionCN")
    val strDescriptionCN: String?,

    @field:SerializedName("strDescriptionDE")
    val strDescriptionDE: String?,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,

    @field:SerializedName("strDescriptionES")
    val strDescriptionES: String?,

    @field:SerializedName("strDescriptionFR")
    val strDescriptionFR: String?,

    @field:SerializedName("strDescriptionHU")
    val strDescriptionHU: String?,

    @field:SerializedName("strDescriptionIL")
    val strDescriptionIL: String?,

    @field:SerializedName("strDescriptionIT")
    val strDescriptionIT: String?,

    @field:SerializedName("strDescriptionJP")
    val strDescriptionJP: String?,

    @field:SerializedName("strDescriptionNL")
    val strDescriptionNL: String?,

    @field:SerializedName("strDescriptionNO")
    val strDescriptionNO: String?,

    @field:SerializedName("strDescriptionPL")
    val strDescriptionPL: String?,

    @field:SerializedName("strDescriptionPT")
    val strDescriptionPT: String?,

    @field:SerializedName("strDescriptionRU")
    val strDescriptionRU: String?,

    @field:SerializedName("strDescriptionSE")
    val strDescriptionSE: String?,

    @field:SerializedName("strDivision")
    val strDivision: String?,

    @field:SerializedName("strFacebook")
    val strFacebook: String?,

    @field:SerializedName("strFanart1")
    val strFanart1: String?,

    @field:SerializedName("strFanart2")
    val strFanart2: String?,

    @field:SerializedName("strFanart3")
    val strFanart3: String?,

    @field:SerializedName("strFanart4")
    val strFanart4: String?,

    @field:SerializedName("strGender")
    val strGender: String?,

    @field:SerializedName("strLeague")
    val strLeague: String?,

    @field:SerializedName("strLeagueAlternate")
    val strLeagueAlternate: String?,

    @field:SerializedName("strLocked")
    val strLocked: String?,

    @field:SerializedName("strLogo")
    val strLogo: String?,

    @field:SerializedName("strNaming")
    val strNaming: String?,

    @field:SerializedName("strPoster")
    val strPoster: String?,

    @field:SerializedName("strRSS")
    val strRSS: String?,

    @field:SerializedName("strSport")
    val strSport: String?,

    @field:SerializedName("strTrophy")
    val strTrophy: String?,

    @field:SerializedName("strTwitter")
    val strTwitter: String?,

    @field:SerializedName("strWebsite")
    val strWebsite: String?,

    @field:SerializedName("strYoutube")
    val strYoutube: String?

)