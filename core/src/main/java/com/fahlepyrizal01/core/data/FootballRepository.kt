package com.fahlepyrizal01.core.data

import com.fahlepyrizal01.core.data.source.local.IFootballLocalSource
import com.fahlepyrizal01.core.data.source.remote.IFootballRemoteSource
import com.fahlepyrizal01.core.data.source.remote.network.ApiResponse
import com.fahlepyrizal01.core.data.source.remote.response.*
import com.fahlepyrizal01.core.domain.model.*
import com.fahlepyrizal01.core.domain.repository.IFootballRepository
import com.fahlepyrizal01.core.utils.AppExecutors
import com.fahlepyrizal01.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class FootballRepository(
    private val footballRemoteDataSource: IFootballRemoteSource,
    private val footballLocalDataSource: IFootballLocalSource,
    private val appExecutors: AppExecutors
): IFootballRepository {

    override fun getLeagueList(): Flow<Resource<List<League>>> {
        return object: NetworkBoundResource<List<League>, List<LeagueResponse>>() {
            override fun loadFromDB(): Flow<List<League>> {
                return footballLocalDataSource.getLeagueList().map {
                    DataMapper.LeagueMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<League>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<LeagueResponse>>> =
                footballRemoteDataSource.getLeagueList()

            override suspend fun saveCallResult(data: List<LeagueResponse>) {
                footballLocalDataSource.insertLeagueList(
                    DataMapper.LeagueMapper.mapResponsesToEntities(data)
                )
            }

        }.asFlow()
    }

    override fun getLeagueDetail(idLeague: String): Flow<Resource<LeagueDetail>> {
        return object: NetworkBoundResource<LeagueDetail, LeagueDetailResponse>() {
            override fun loadFromDB(): Flow<LeagueDetail> {
                return footballLocalDataSource.getLeagueDetail(idLeague).map {
                    DataMapper.LeagueDetailMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<LeagueDetailResponse>> =
                footballRemoteDataSource.getLeagueDetail(idLeague)

            override fun shouldFetch(data: LeagueDetail?): Boolean = true

            override suspend fun saveCallResult(data: LeagueDetailResponse) {
                footballLocalDataSource.insertLeagueDetail(
                    DataMapper.LeagueDetailMapper.mapResponsesToEntities(data)
                )
            }

        }.asFlow()
    }

    override fun getStandingList(idLeague: String): Flow<Resource<List<Standing>>> {
        return object: NetworkBoundResource<List<Standing>, List<StandingResponse>>() {
            override fun loadFromDB(): Flow<List<Standing>> {
                return footballLocalDataSource.getStandingList(idLeague).map {
                    DataMapper.StandingMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Standing>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<StandingResponse>>> =
                footballRemoteDataSource.getStandingList(idLeague)

            override suspend fun saveCallResult(data: List<StandingResponse>) {
                footballLocalDataSource.insertStandingList(DataMapper.StandingMapper.mapResponsesToEntities(data, idLeague))
            }
        }.asFlow()
    }

    override fun getTeamList(idLeague: String): Flow<Resource<List<Team>>> {
        return object: NetworkBoundResource<List<Team>, List<TeamResponse>>() {
            override fun loadFromDB(): Flow<List<Team>> {
                return footballLocalDataSource.getTeamList(idLeague).map {
                    DataMapper.TeamMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Team>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<TeamResponse>>> =
                footballRemoteDataSource.getTeamList(idLeague)

            override suspend fun saveCallResult(data: List<TeamResponse>) {
                val oldData = footballLocalDataSource.getTeamList(idLeague).first()
                footballLocalDataSource.insertTeamList(DataMapper.TeamMapper.mapResponsesToEntities(data, oldData))
            }
        }.asFlow()
    }

    override fun searchTeams(keyWord: String): Flow<Resource<List<Team>>> {
        return object: NetworkBoundResource<List<Team>, List<TeamResponse>>() {
            override fun loadFromDB(): Flow<List<Team>> {
                return footballLocalDataSource.searchTeams(keyWord).map {
                    DataMapper.TeamMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Team>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<TeamResponse>>> =
                footballRemoteDataSource.searchTeams(keyWord)

            override suspend fun saveCallResult(data: List<TeamResponse>) {
                val oldData = footballLocalDataSource.searchTeams(keyWord).first()
                footballLocalDataSource.insertTeamList(DataMapper.TeamMapper.mapResponsesToEntities(data, oldData))
            }
        }.asFlow()
    }

    override fun getFavoriteTeamList(): Flow<List<Team>> {
        return footballLocalDataSource.getFavoriteTeamList().map {
            DataMapper.TeamMapper.mapEntitiesToDomain(it)
        }
    }

    override fun getTeamDetail(idTeam: String): Flow<Resource<Team>> {
        return object: NetworkBoundResource<Team, TeamResponse>() {
            override fun loadFromDB(): Flow<Team> {
                return footballLocalDataSource.getTeamDetail(idTeam).map {
                    DataMapper.TeamDetailMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: Team?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<TeamResponse>> =
                footballRemoteDataSource.getTeamDetail(idTeam)

            override suspend fun saveCallResult(data: TeamResponse) {
                val oldData = footballLocalDataSource.getTeamDetail(idTeam).first()
                footballLocalDataSource.insertTeamDetail(DataMapper.TeamDetailMapper.mapResponsesToEntities(data, oldData))
            }
        }.asFlow()
    }

    override fun getEventList(idTeam: String, isLastEvent: Boolean): Flow<Resource<List<Event>>> {
        return object: NetworkBoundResource<List<Event>, List<EventResponse>>() {
            override fun loadFromDB(): Flow<List<Event>> {
                return if (isLastEvent) {
                    footballLocalDataSource.getLastEventList(idTeam).map {
                        DataMapper.EventMapper.lastMapEntitiesToDomain(it)
                    }
                } else {
                    footballLocalDataSource.getNextEventList(idTeam).map {
                        DataMapper.EventMapper.nextMapEntitiesToDomain(it)
                    }
                }
            }

            override fun shouldFetch(data: List<Event>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<EventResponse>>> =
                footballRemoteDataSource.getEventList(idTeam, isLastEvent)

            override suspend fun saveCallResult(data: List<EventResponse>) {
                if (isLastEvent) footballLocalDataSource.insertLastEventList(DataMapper.EventMapper.lastMapResponsesToEntities(data))
                else footballLocalDataSource.insertNextEventList(DataMapper.EventMapper.nextMapResponsesToEntities(data))
            }
        }.asFlow()
    }

    override fun getEventDetail(idEvent: String, isLastEvent: Boolean): Flow<Resource<Event>> {
        return object: NetworkBoundResource<Event, EventResponse>() {
            override fun loadFromDB(): Flow<Event> {
                return if (isLastEvent) {
                    footballLocalDataSource.getLastEventDetail(idEvent).map {
                        DataMapper.EventDetailMapper.lastMapEntitiesToDomain(it)
                    }
                } else {
                    footballLocalDataSource.getNextEventDetail(idEvent).map {
                        DataMapper.EventDetailMapper.nextMapEntitiesToDomain(it)
                    }
                }
            }

            override fun shouldFetch(data: Event?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<EventResponse>> =
                footballRemoteDataSource.getEventDetail(idEvent)

            override suspend fun saveCallResult(data: EventResponse) {
                if (isLastEvent) footballLocalDataSource.insertLastEventDetail(DataMapper.EventDetailMapper.lastMapResponsesToEntities(data))
                else footballLocalDataSource.insertNextEventDetail(DataMapper.EventDetailMapper.nextMapResponsesToEntities(data))
            }
        }.asFlow()
    }

    override fun updateIsFavorite(team: Team, isFavorite: Boolean) {
        appExecutors.diskIO().execute {
            footballLocalDataSource.updateIsFavorite(DataMapper.TeamDetailMapper.mapDomainToEntity(team, isFavorite))
        }
    }

}