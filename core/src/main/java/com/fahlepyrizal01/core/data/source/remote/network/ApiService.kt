package com.fahlepyrizal01.core.data.source.remote.network

import com.fahlepyrizal01.core.data.source.remote.response.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("all_leagues.php")
    suspend fun getLeagueList(): LeaguesResponse

    @GET("lookupleague.php")
    suspend fun getLeagueDetail(@Query("id") idLeague: String): LeaguesDetailResponse

    @GET("lookuptable.php")
    suspend fun getStandingList(@Query("l") idLeague: String): StandingsResponse

    @GET("lookup_all_teams.php")
    suspend fun getTeamList(@Query("id") idLeague: String): TeamsResponse

    @GET("lookupteam.php")
    suspend fun getTeamDetail(@Query("id") idTeam: String): TeamsResponse

    @GET("eventslast.php")
    suspend fun getLastEventList(@Query("id") idTeam: String): LastEventsResponse

    @GET("eventsnext.php")
    suspend fun getNextEventList(@Query("id") idTeam: String): NextEventsResponse

    @GET("lookupevent.php")
    suspend fun getEventDetail(@Query("id") idEvent: String): LastEventsResponse

    @GET("searchteams.php")
    suspend fun searchTeams(@Query("t") keyWord: String): TeamsResponse

}