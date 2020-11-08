package com.fahlepyrizal01.core.data.source.local

import com.fahlepyrizal01.core.data.source.local.entity.*
import kotlinx.coroutines.flow.Flow

interface IFootballLocalSource {

    fun getLeagueList(): Flow<List<LeaguesEntity>>

    fun getLeagueDetail(idLeague: String): Flow<LeagueEntity>

    fun getStandingList(idLeague: String): Flow<List<StandingsEntity>>

    fun getTeamList(idLeague: String): Flow<List<TeamsEntity>>

    fun searchTeams(keyWord: String): Flow<List<TeamsEntity>>

    fun getFavoriteTeamList(): Flow<List<TeamsEntity>>

    fun getTeamDetail(idTeam: String): Flow<TeamsEntity>

    fun getLastEventList(idTeam: String): Flow<List<LastEventsEntity>>

    fun getLastEventDetail(idEvent: String): Flow<LastEventsEntity>

    fun getNextEventList(idTeam: String): Flow<List<NextEventsEntity>>

    fun getNextEventDetail(idEvent: String): Flow<NextEventsEntity>

    suspend fun insertLeagueList(data: List<LeaguesEntity>)

    suspend fun insertLeagueDetail(data: LeagueEntity)

    suspend fun insertStandingList(data: List<StandingsEntity>)

    suspend fun insertTeamList(data: List<TeamsEntity>)

    suspend fun insertTeamDetail(data: TeamsEntity)

    suspend fun insertLastEventList(data: List<LastEventsEntity>)

    suspend fun insertLastEventDetail(data: LastEventsEntity)

    suspend fun insertNextEventList(data: List<NextEventsEntity>)

    suspend fun insertNextEventDetail(data: NextEventsEntity)

    fun updateIsFavorite(team: TeamsEntity)

}