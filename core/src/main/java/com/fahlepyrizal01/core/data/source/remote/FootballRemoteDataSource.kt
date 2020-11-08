package com.fahlepyrizal01.core.data.source.remote

import com.fahlepyrizal01.core.data.source.remote.network.ApiResponse
import com.fahlepyrizal01.core.data.source.remote.network.ApiService
import com.fahlepyrizal01.core.data.source.remote.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FootballRemoteDataSource(private val apiService: ApiService) : IFootballRemoteSource {
    override fun getLeagueList(): Flow<ApiResponse<List<LeagueResponse>>> {
        return flow {
            try {
                val response = apiService.getLeagueList()
                if (response.leagues.isNotEmpty()) {
                    emit(ApiResponse.Success(response.leagues.filter { it.strSport == DEFAULT_SPORT }))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getLeagueDetail(idLeague: String): Flow<ApiResponse<LeagueDetailResponse>> {
        return flow {
            try {
                val response = apiService.getLeagueDetail(idLeague)
                if (response.leagues.isNotEmpty()) {
                    emit(ApiResponse.Success(response.leagues.first()))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getStandingList(idLeague: String): Flow<ApiResponse<List<StandingResponse>>> {
        return flow {
            try {
                val response = apiService.getStandingList(idLeague)
                if (response.standing.isNotEmpty()) {
                    emit(ApiResponse.Success(response.standing))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getTeamList(idLeague: String): Flow<ApiResponse<List<TeamResponse>>> {
        return flow {
            try {
                val response = apiService.getTeamList(idLeague)
                if (response.teams.isNotEmpty()) {
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getTeamDetail(idTeam: String): Flow<ApiResponse<TeamResponse>> {
        return flow {
            try {
                val response = apiService.getTeamDetail(idTeam)
                if (response.teams.isNotEmpty()) {
                    emit(ApiResponse.Success(response.teams.first()))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getEventList(idTeam: String, isLastMatch: Boolean): Flow<ApiResponse<List<EventResponse>>> {
        return flow {
            try {
                if (isLastMatch) {
                    val response = apiService.getLastEventList(idTeam)
                    if (response.results.isNotEmpty()) {
                        emit(ApiResponse.Success(response.results))
                    } else {
                        emit(ApiResponse.Empty)
                    }
                } else {
                    val response = apiService.getNextEventList(idTeam)
                    if (response.events.isNotEmpty()) {
                        emit(ApiResponse.Success(response.events))
                    } else {
                        emit(ApiResponse.Empty)
                    }
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getEventDetail(idEvent: String): Flow<ApiResponse<EventResponse>> {
        return flow {
            try {
                val response = apiService.getEventDetail(idEvent)
                if (response.results.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results.first()))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun searchTeams(keyWord: String): Flow<ApiResponse<List<TeamResponse>>> {
        return flow {
            try {
                val response = apiService.searchTeams(keyWord)
                if (response.teams.isNotEmpty()) {
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        const val DEFAULT_SPORT = "Soccer"
    }
}