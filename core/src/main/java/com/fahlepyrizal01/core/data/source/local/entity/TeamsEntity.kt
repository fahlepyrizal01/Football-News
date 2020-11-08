package com.fahlepyrizal01.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class TeamsEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    val idTeam: String,

    @NonNull
    @ColumnInfo(name = "idLeague")
    val idLeague: String,

    @ColumnInfo(name = "idAPIfootball")
    val idAPIfootball: String?,

    @ColumnInfo(name = "idLeague2")
    val idLeague2: String?,

    @ColumnInfo(name = "idLeague3")
    val idLeague3: String?,

    @ColumnInfo(name = "idLeague4")
    val idLeague4: String?,

    @ColumnInfo(name = "idLeague5")
    val idLeague5: String?,

    @ColumnInfo(name = "idLeague6")
    val idLeague6: String?,

    @ColumnInfo(name = "idLeague7")
    val idLeague7: String?,

    @ColumnInfo(name = "idSoccerXML")
    val idSoccerXML: String?,

    @ColumnInfo(name = "intFormedYear")
    val intFormedYear: String?,

    @ColumnInfo(name = "intLoved")
    val intLoved: String?,

    @ColumnInfo(name = "intStadiumCapacity")
    val intStadiumCapacity: String?,

    @ColumnInfo(name = "strAlternate")
    val strAlternate: String?,

    @ColumnInfo(name = "strCountry")
    val strCountry: String?,

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

    @ColumnInfo(name = "strGender")
    val strGender: String?,

    @ColumnInfo(name = "strInstagram")
    val strInstagram: String?,

    @ColumnInfo(name = "strKeywords")
    val strKeywords: String?,

    @ColumnInfo(name = "strLeague")
    val strLeague: String?,

    @ColumnInfo(name = "strLeague2")
    val strLeague2: String?,

    @ColumnInfo(name = "strLeague3")
    val strLeague3: String?,

    @ColumnInfo(name = "strLeague4")
    val strLeague4: String?,

    @ColumnInfo(name = "strLeague5")
    val strLeague5: String?,

    @ColumnInfo(name = "strLeague6")
    val strLeague6: String?,

    @ColumnInfo(name = "strLeague7")
    val strLeague7: String?,

    @ColumnInfo(name = "strLocked")
    val strLocked: String?,

    @ColumnInfo(name = "strManager")
    val strManager: String?,

    @ColumnInfo(name = "strRSS")
    val strRSS: String?,

    @ColumnInfo(name = "strSport")
    val strSport: String?,

    @ColumnInfo(name = "strStadium")
    val strStadium: String?,

    @ColumnInfo(name = "strStadiumDescription")
    val strStadiumDescription: String?,

    @ColumnInfo(name = "strStadiumLocation")
    val strStadiumLocation: String?,

    @ColumnInfo(name = "strStadiumThumb")
    val strStadiumThumb: String?,

    @ColumnInfo(name = "strTeam")
    val strTeam: String?,

    @ColumnInfo(name = "strTeamBadge")
    val strTeamBadge: String?,

    @ColumnInfo(name = "strTeamBanner")
    val strTeamBanner: String?,

    @ColumnInfo(name = "strTeamFanart1")
    val strTeamFanart1: String?,

    @ColumnInfo(name = "strTeamFanart2")
    val strTeamFanart2: String?,

    @ColumnInfo(name = "strTeamFanart3")
    val strTeamFanart3: String?,

    @ColumnInfo(name = "strTeamFanart4")
    val strTeamFanart4: String?,

    @ColumnInfo(name = "strTeamJersey")
    val strTeamJersey: String?,

    @ColumnInfo(name = "strTeamLogo")
    val strTeamLogo: String?,

    @ColumnInfo(name = "strTeamShort")
    val strTeamShort: String?,

    @ColumnInfo(name = "strTwitter")
    val strTwitter: String?,

    @ColumnInfo(name = "strWebsite")
    val strWebsite: String?,

    @ColumnInfo(name = "strYoutube")
    val strYoutube: String?,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean

)