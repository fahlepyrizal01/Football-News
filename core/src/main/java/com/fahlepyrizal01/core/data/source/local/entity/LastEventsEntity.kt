package com.fahlepyrizal01.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "last_events")
data class LastEventsEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idEvent")
    val idEvent: String,

    @NonNull
    @ColumnInfo(name = "idLeague")
    val idLeague: String,

    @NonNull
    @ColumnInfo(name = "idAwayTeam")
    val idAwayTeam: String,

    @NonNull
    @ColumnInfo(name = "idHomeTeam")
    val idHomeTeam: String,

    @ColumnInfo(name = "dateEvent")
    val dateEvent: String?,

    @ColumnInfo(name = "dateEventLocal")
    val dateEventLocal: String?,

    @ColumnInfo(name = "idAPIfootball")
    val idAPIfootball: String?,

    @ColumnInfo(name = "idSoccerXML")
    val idSoccerXML: String?,

    @ColumnInfo(name = "intAwayScore")
    val intAwayScore: String?,

    @ColumnInfo(name = "intAwayShots")
    val intAwayShots: Int?,

    @ColumnInfo(name = "intHomeScore")
    val intHomeScore: String?,

    @ColumnInfo(name = "intHomeShots")
    val intHomeShots: Int?,

    @ColumnInfo(name = "intRound")
    val intRound: String?,

    @ColumnInfo(name = "intSpectators")
    val intSpectators: Int?,

    @ColumnInfo(name = "strAwayFormation")
    val strAwayFormation: String?,

    @ColumnInfo(name = "strAwayGoalDetails")
    val strAwayGoalDetails: String?,

    @ColumnInfo(name = "strAwayLineupDefense")
    val strAwayLineupDefense: String?,

    @ColumnInfo(name = "strAwayLineupForward")
    val strAwayLineupForward: String?,

    @ColumnInfo(name = "strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String?,

    @ColumnInfo(name = "strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,

    @ColumnInfo(name = "strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?,

    @ColumnInfo(name = "strAwayRedCards")
    val strAwayRedCards: String?,

    @ColumnInfo(name = "strAwayTeam")
    val strAwayTeam: String?,

    @ColumnInfo(name = "strAwayYellowCards")
    val strAwayYellowCards: String?,

    @ColumnInfo(name = "strBanner")
    val strBanner: String?,

    @ColumnInfo(name = "strCity")
    val strCity: String?,

    @ColumnInfo(name = "strCountry")
    val strCountry: String?,

    @ColumnInfo(name = "strDate")
    val strDate: String?,

    @ColumnInfo(name = "strDescriptionEN")
    val strDescriptionEN: String?,

    @ColumnInfo(name = "strEvent")
    val strEvent: String?,

    @ColumnInfo(name = "strEventAlternate")
    val strEventAlternate: String?,

    @ColumnInfo(name = "strFanart")
    val strFanart: String?,

    @ColumnInfo(name = "strFilename")
    val strFilename: String?,

    @ColumnInfo(name = "strHomeFormation")
    val strHomeFormation: String?,

    @ColumnInfo(name = "strHomeGoalDetails")
    val strHomeGoalDetails: String?,

    @ColumnInfo(name = "strHomeLineupDefense")
    val strHomeLineupDefense: String?,

    @ColumnInfo(name = "strHomeLineupForward")
    val strHomeLineupForward: String?,

    @ColumnInfo(name = "strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,

    @ColumnInfo(name = "strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,

    @ColumnInfo(name = "strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,

    @ColumnInfo(name = "strHomeRedCards")
    val strHomeRedCards: String?,

    @ColumnInfo(name = "strHomeTeam")
    val strHomeTeam: String?,

    @ColumnInfo(name = "strHomeYellowCards")
    val strHomeYellowCards: String?,

    @ColumnInfo(name = "strLeague")
    val strLeague: String?,

    @ColumnInfo(name = "strLocked")
    val strLocked: String?,

    @ColumnInfo(name = "strMap")
    val strMap: String?,

    @ColumnInfo(name = "strOfficial")
    val strOfficial: String?,

    @ColumnInfo(name = "strPoster")
    val strPoster: String?,

    @ColumnInfo(name = "strPostponed")
    val strPostponed: String?,

    @ColumnInfo(name = "strResult")
    val strResult: String?,

    @ColumnInfo(name = "strSeason")
    val strSeason: String?,

    @ColumnInfo(name = "strSport")
    val strSport: String?,

    @ColumnInfo(name = "strStatus")
    val strStatus: String?,

    @ColumnInfo(name = "strTVStation")
    val strTVStation: String?,

    @ColumnInfo(name = "strThumb")
    val strThumb: String?,

    @ColumnInfo(name = "strTime")
    val strTime: String?,

    @ColumnInfo(name = "strTimeLocal")
    val strTimeLocal: String?,

    @ColumnInfo(name = "strTimestamp")
    val strTimestamp: String?,

    @ColumnInfo(name = "strTweet1")
    val strTweet1: String?,

    @ColumnInfo(name = "strTweet2")
    val strTweet2: String?,

    @ColumnInfo(name = "strTweet3")
    val strTweet3: String?,

    @ColumnInfo(name = "strVenue")
    val strVenue: String?,

    @ColumnInfo(name = "strVideo")
    val strVideo: String?
    
)