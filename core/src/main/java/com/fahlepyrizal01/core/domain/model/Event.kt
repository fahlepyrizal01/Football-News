package com.fahlepyrizal01.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Event(

    val idEvent: String,
    val idLeague: String,
    val idAwayTeam: String,
    val idHomeTeam: String,
    val dateEvent: String?,
    val dateEventLocal: String?,
    val idAPIfootball: String?,
    val idSoccerXML: String?,
    val intAwayScore: String?,
    val intAwayShots: Int?,
    val intHomeScore: String?,
    val intHomeShots: Int?,
    val intRound: String?,
    val intSpectators: Int?,
    val strAwayFormation: String?,
    val strAwayGoalDetails: String?,
    val strAwayLineupDefense: String?,
    val strAwayLineupForward: String?,
    val strAwayLineupGoalkeeper: String?,
    val strAwayLineupMidfield: String?,
    val strAwayLineupSubstitutes: String?,
    val strAwayRedCards: String?,
    val strAwayTeam: String?,
    val strAwayYellowCards: String?,
    val strBanner: String?,
    val strCity: String?,
    val strCountry: String?,
    val strDate: String?,
    val strDescriptionEN: String?,
    val strEvent: String?,
    val strEventAlternate: String?,
    val strFanart: String?,
    val strFilename: String?,
    val strHomeFormation: String?,
    val strHomeGoalDetails: String?,
    val strHomeLineupDefense: String?,
    val strHomeLineupForward: String?,
    val strHomeLineupGoalkeeper: String?,
    val strHomeLineupMidfield: String?,
    val strHomeLineupSubstitutes: String?,
    val strHomeRedCards: String?,
    val strHomeTeam: String?,
    val strHomeYellowCards: String?,
    val strLeague: String?,
    val strLocked: String?,
    val strMap: String?,
    val strOfficial: String?,
    val strPoster: String?,
    val strPostponed: String?,
    val strResult: String?,
    val strSeason: String?,
    val strSport: String?,
    val strStatus: String?,
    val strTVStation: String?,
    val strThumb: String?,
    val strTime: String?,
    val strTimeLocal: String?,
    val strTimestamp: String?,
    val strTweet1: String?,
    val strTweet2: String?,
    val strTweet3: String?,
    val strVenue: String?,
    val strVideo: String?

) : Parcelable