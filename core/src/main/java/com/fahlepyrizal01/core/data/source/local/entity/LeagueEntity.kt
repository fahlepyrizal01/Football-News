package com.fahlepyrizal01.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league")
data class LeagueEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idLeague")
    val idLeague: String,

    @ColumnInfo(name = "dateFirstEvent")
    val dateFirstEvent: String?,

    @ColumnInfo(name = "idAPIfootball")
    val idAPIfootball: String?,

    @ColumnInfo(name = "idCup")
    val idCup: String?,

    @ColumnInfo(name = "idSoccerXML")
    val idSoccerXML: String?,

    @ColumnInfo(name = "intFormedYear")
    val intFormedYear: String?,

    @ColumnInfo(name = "strBadge")
    val strBadge: String?,

    @ColumnInfo(name = "strBanner")
    val strBanner: String?,

    @ColumnInfo(name = "strComplete")
    val strComplete: String?,

    @ColumnInfo(name = "strCountry")
    val strCountry: String?,

    @ColumnInfo(name = "strCurrentSeason")
    val strCurrentSeason: String?,

    @ColumnInfo(name = "strDescriptionCN")
    val strDescriptionCN: String?,

    @ColumnInfo(name = "strDescriptionDE")
    val strDescriptionDE: String?,

    @ColumnInfo(name = "strDescriptionEN")
    val strDescriptionEN: String?,

    @ColumnInfo(name = "strDescriptionES")
    val strDescriptionES: String?,

    @ColumnInfo(name = "strDescriptionFR")
    val strDescriptionFR: String?,

    @ColumnInfo(name = "strDescriptionHU")
    val strDescriptionHU: String?,

    @ColumnInfo(name = "strDescriptionIL")
    val strDescriptionIL: String?,

    @ColumnInfo(name = "strDescriptionIT")
    val strDescriptionIT: String?,

    @ColumnInfo(name = "strDescriptionJP")
    val strDescriptionJP: String?,

    @ColumnInfo(name = "strDescriptionNL")
    val strDescriptionNL: String?,

    @ColumnInfo(name = "strDescriptionNO")
    val strDescriptionNO: String?,

    @ColumnInfo(name = "strDescriptionPL")
    val strDescriptionPL: String?,

    @ColumnInfo(name = "strDescriptionPT")
    val strDescriptionPT: String?,

    @ColumnInfo(name = "strDescriptionRU")
    val strDescriptionRU: String?,

    @ColumnInfo(name = "strDescriptionSE")
    val strDescriptionSE: String?,

    @ColumnInfo(name = "strDivision")
    val strDivision: String?,

    @ColumnInfo(name = "strFacebook")
    val strFacebook: String?,

    @ColumnInfo(name = "strFanart1")
    val strFanart1: String?,

    @ColumnInfo(name = "strFanart2")
    val strFanart2: String?,

    @ColumnInfo(name = "strFanart3")
    val strFanart3: String?,

    @ColumnInfo(name = "strFanart4")
    val strFanart4: String?,

    @ColumnInfo(name = "strGender")
    val strGender: String?,

    @ColumnInfo(name = "strLeague")
    val strLeague: String?,

    @ColumnInfo(name = "strLeagueAlternate")
    val strLeagueAlternate: String?,

    @ColumnInfo(name = "strLocked")
    val strLocked: String?,

    @ColumnInfo(name = "strLogo")
    val strLogo: String?,

    @ColumnInfo(name = "strNaming")
    val strNaming: String?,

    @ColumnInfo(name = "strPoster")
    val strPoster: String?,

    @ColumnInfo(name = "strRSS")
    val strRSS: String?,

    @ColumnInfo(name = "strSport")
    val strSport: String?,

    @ColumnInfo(name = "strTrophy")
    val strTrophy: String?,

    @ColumnInfo(name = "strTwitter")
    val strTwitter: String?,

    @ColumnInfo(name = "strWebsite")
    val strWebsite: String?,

    @ColumnInfo(name = "strYoutube")
    val strYoutube: String?

)