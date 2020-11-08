package com.fahlepyrizal01.core.data.source.remote

import com.fahlepyrizal01.core.data.source.remote.network.ApiResponse
import com.fahlepyrizal01.core.data.source.remote.response.*
import kotlinx.coroutines.flow.Flow

interface IFootballRemoteSource {

    fun getLeagueList(): Flow<ApiResponse<List<LeagueResponse>>>

    fun getLeagueDetail(idLeague: String): Flow<ApiResponse<LeagueDetailResponse>>

    fun getStandingList(idLeague: String): Flow<ApiResponse<List<StandingResponse>>>

    fun getTeamList(idLeague: String): Flow<ApiResponse<List<TeamResponse>>>

    fun getTeamDetail(idTeam: String): Flow<ApiResponse<TeamResponse>>

    fun getEventList(idTeam: String, isLastMatch: Boolean): Flow<ApiResponse<List<EventResponse>>>

    fun getEventDetail(idEvent: String): Flow<ApiResponse<EventResponse>>

    fun searchTeams(keyWord: String): Flow<ApiResponse<List<TeamResponse>>>

}