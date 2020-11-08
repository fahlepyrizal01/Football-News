package com.fahlepyrizal01.core.domain.usecase

import com.fahlepyrizal01.core.data.Resource
import com.fahlepyrizal01.core.domain.model.*
import com.fahlepyrizal01.core.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow

class FootballInteractor(private val footballRepository: IFootballRepository) : FootballUseCase {

    override fun getLeagueList(): Flow<Resource<List<League>>> = footballRepository.getLeagueList()

    override fun getLeagueDetail(idLeague: String): Flow<Resource<LeagueDetail>> =
        footballRepository.getLeagueDetail(idLeague)

    override fun getStandingList(idLeague: String): Flow<Resource<List<Standing>>> =
        footballRepository.getStandingList(idLeague)

    override fun getTeamList(idLeague: String): Flow<Resource<List<Team>>> =
        footballRepository.getTeamList(idLeague)

    override fun searchTeams(keyWord: String): Flow<Resource<List<Team>>> =
        footballRepository.searchTeams(keyWord)

    override fun getFavoriteTeamList(): Flow<List<Team>> =
        footballRepository.getFavoriteTeamList()

    override fun getTeamDetail(idTeam: String): Flow<Resource<Team>> =
        footballRepository.getTeamDetail(idTeam)

    override fun getEventList(idTeam: String, isLastEvent: Boolean): Flow<Resource<List<Event>>> =
        footballRepository.getEventList(idTeam, isLastEvent)

    override fun getEventDetail(idEvent: String, isLastEvent: Boolean): Flow<Resource<Event>> =
        footballRepository.getEventDetail(idEvent, isLastEvent)

    override suspend fun updateIsFavorite(team: Team, isFavorite: Boolean) {
        footballRepository.updateIsFavorite(team, isFavorite)
    }
}