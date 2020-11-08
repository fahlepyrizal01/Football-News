package com.fahlepyrizal01.core.domain.usecase

import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.*
import kotlinx.coroutines.flow.Flow

interface FootballUseCase {

    fun getLeagueList(): Flow<Resource<List<League>>>

    fun getLeagueDetail(idLeague: String): Flow<Resource<LeagueDetail>>

    fun getStandingList(idLeague: String): Flow<Resource<List<Standing>>>

    fun getTeamList(idLeague: String): Flow<Resource<List<Team>>>

    fun searchTeams(keyWord: String): Flow<Resource<List<Team>>>

    fun getFavoriteTeamList(): Flow<List<Team>>

    fun getTeamDetail(idTeam: String): Flow<Resource<Team>>

    fun getEventList(idTeam: String, isLastEvent: Boolean): Flow<Resource<List<Event>>>

    fun getEventDetail(idEvent: String, isLastEvent: Boolean): Flow<Resource<Event>>

    suspend fun updateIsFavorite(team: Team, isFavorite: Boolean)
}