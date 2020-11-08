package com.fahlepyrizal01.core.data.source.local

import com.fahlepyrizal01.core.data.source.local.entity.*
import com.fahlepyrizal01.core.data.source.local.room.FootballDao
import kotlinx.coroutines.flow.Flow

class FootballLocalDataSource(private val footballDao: FootballDao): IFootballLocalSource {

    override fun getLeagueList(): Flow<List<LeaguesEntity>> = footballDao.getLeagueList()

    override fun getLeagueDetail(idLeague: String): Flow<LeagueEntity> = footballDao.getLeagueDetail(idLeague)

    override fun getStandingList(idLeague: String): Flow<List<StandingsEntity>> = footballDao.getStandingList(idLeague)

    override fun getTeamList(idLeague: String): Flow<List<TeamsEntity>> = footballDao.getTeamList(idLeague)

    override fun searchTeams(keyWord: String): Flow<List<TeamsEntity>> = footballDao.searchTeams(keyWord)

    override fun getFavoriteTeamList(): Flow<List<TeamsEntity>> = footballDao.getFavoriteTeamList()

    override fun getTeamDetail(idTeam: String): Flow<TeamsEntity> = footballDao.getTeamDetail(idTeam)

    override fun getLastEventList(idTeam: String): Flow<List<LastEventsEntity>> = footballDao.getLastEventList(idTeam)

    override fun getLastEventDetail(idEvent: String): Flow<LastEventsEntity> = footballDao.getLastEventDetail(idEvent)

    override fun getNextEventList(idTeam: String): Flow<List<NextEventsEntity>> = footballDao.getNextEventList(idTeam)

    override fun getNextEventDetail(idEvent: String): Flow<NextEventsEntity> = footballDao.getNextEventDetail(idEvent)

    override suspend fun insertLeagueList(data: List<LeaguesEntity>) {
        footballDao.insertLeagueList(data)
    }

    override suspend fun insertLeagueDetail(data: LeagueEntity) {
        footballDao.insertLeagueDetail(data)
    }

    override suspend fun insertStandingList(data: List<StandingsEntity>) {
        footballDao.insertStandingList(data)
    }

    override suspend fun insertTeamList(data: List<TeamsEntity>) {
        footballDao.insertTeamList(data)
    }

    override suspend fun insertTeamDetail(data: TeamsEntity) {
        footballDao.insertTeamDetail(data)
    }

    override suspend fun insertLastEventList(data: List<LastEventsEntity>) {
        footballDao.insertLastEventsList(data)
    }

    override suspend fun insertLastEventDetail(data: LastEventsEntity) {
        footballDao.insertLastEventDetail(data)
    }

    override suspend fun insertNextEventList(data: List<NextEventsEntity>) {
        footballDao.insertNextEventsList(data)
    }

    override suspend fun insertNextEventDetail(data: NextEventsEntity) {
        footballDao.insertNextEventDetail(data)
    }

    override fun updateIsFavorite(team: TeamsEntity) {
        footballDao.updateIsFavorite(team)
    }

}