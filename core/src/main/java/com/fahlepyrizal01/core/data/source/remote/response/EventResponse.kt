package com.fahlepyrizal01.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class EventResponse(

    @field:SerializedName("idEvent")
    val idEvent: String,

    @field:SerializedName("idLeague")
    val idLeague: String,

    @field:SerializedName("idAwayTeam")
    val idAwayTeam: String,

    @field:SerializedName("idHomeTeam")
    val idHomeTeam: String,

    @field:SerializedName("dateEvent")
    val dateEvent: String?,

    @field:SerializedName("dateEventLocal")
    val dateEventLocal: String?,

    @field:SerializedName("idAPIfootball")
    val idAPIfootball: String?,

    @field:SerializedName("idSoccerXML")
    val idSoccerXML: String?,

    @field:SerializedName("intAwayScore")
    val intAwayScore: String?,

    @field:SerializedName("intAwayShots")
    val intAwayShots: Int?,

    @field:SerializedName("intHomeScore")
    val intHomeScore: String?,

    @field:SerializedName("intHomeShots")
    val intHomeShots: Int?,

    @field:SerializedName("intRound")
    val intRound: String?,

    @field:SerializedName("intSpectators")
    val intSpectators: Int?,

    @field:SerializedName("strAwayFormation")
    val strAwayFormation: String?,

    @field:SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String?,

    @field:SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String?,

    @field:SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String?,

    @field:SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String?,

    @field:SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,

    @field:SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?,

    @field:SerializedName("strAwayRedCards")
    val strAwayRedCards: String?,

    @field:SerializedName("strAwayTeam")
    val strAwayTeam: String?,

    @field:SerializedName("strAwayYellowCards")
    val strAwayYellowCards: String?,

    @field:SerializedName("strBanner")
    val strBanner: String?,

    @field:SerializedName("strCity")
    val strCity: String?,

    @field:SerializedName("strCountry")
    val strCountry: String?,

    @field:SerializedName("strDate")
    val strDate: String?,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,

    @field:SerializedName("strEvent")
    val strEvent: String?,

    @field:SerializedName("strEventAlternate")
    val strEventAlternate: String?,

    @field:SerializedName("strFanart")
    val strFanart: String?,

    @field:SerializedName("strFilename")
    val strFilename: String?,

    @field:SerializedName("strHomeFormation")
    val strHomeFormation: String?,

    @field:SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String?,

    @field:SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String?,

    @field:SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String?,

    @field:SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,

    @field:SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,

    @field:SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,

    @field:SerializedName("strHomeRedCards")
    val strHomeRedCards: String?,

    @field:SerializedName("strHomeTeam")
    val strHomeTeam: String?,

    @field:SerializedName("strHomeYellowCards")
    val strHomeYellowCards: String?,

    @field:SerializedName("strLeague")
    val strLeague: String?,

    @field:SerializedName("strLocked")
    val strLocked: String?,

    @field:SerializedName("strMap")
    val strMap: String?,

    @field:SerializedName("strOfficial")
    val strOfficial: String?,

    @field:SerializedName("strPoster")
    val strPoster: String?,

    @field:SerializedName("strPostponed")
    val strPostponed: String?,

    @field:SerializedName("strResult")
    val strResult: String?,

    @field:SerializedName("strSeason")
    val strSeason: String?,

    @field:SerializedName("strSport")
    val strSport: String?,

    @field:SerializedName("strStatus")
    val strStatus: String?,

    @field:SerializedName("strTVStation")
    val strTVStation: String?,

    @field:SerializedName("strThumb")
    val strThumb: String?,

    @field:SerializedName("strTime")
    val strTime: String?,

    @field:SerializedName("strTimeLocal")
    val strTimeLocal: String?,

    @field:SerializedName("strTimestamp")
    val strTimestamp: String?,

    @field:SerializedName("strTweet1")
    val strTweet1: String?,

    @field:SerializedName("strTweet2")
    val strTweet2: String?,

    @field:SerializedName("strTweet3")
    val strTweet3: String?,

    @field:SerializedName("strVenue")
    val strVenue: String?,

    @field:SerializedName("strVideo")
    val strVideo: String?

)