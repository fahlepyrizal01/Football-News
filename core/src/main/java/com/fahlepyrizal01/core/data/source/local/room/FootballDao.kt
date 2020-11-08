package com.fahlepyrizal01.core.data.source.local.room

import androidx.room.*
import com.fahlepyrizal01.core.data.source.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballDao {

    @Query("SELECT * FROM leagues")
    fun getLeagueList(): Flow<List<LeaguesEntity>>

    @Query("SELECT * FROM league WHERE idLeague = :idLeague")
    fun getLeagueDetail(idLeague: String): Flow<LeagueEntity>

    @Query("SELECT * FROM standings WHERE idLeague = :idLeague")
    fun getStandingList(idLeague: String): Flow<List<StandingsEntity>>

    @Query("SELECT * FROM teams WHERE idLeague = :idLeague")
    fun getTeamList(idLeague: String): Flow<List<TeamsEntity>>

    @Query("SELECT * FROM teams WHERE strTeam LIKE '%' || :keyWord || '%'")
    fun searchTeams(keyWord: String): Flow<List<TeamsEntity>>

    @Query("SELECT * FROM teams WHERE isFavorite = 1")
    fun getFavoriteTeamList(): Flow<List<TeamsEntity>>

    @Query("SELECT * FROM teams WHERE idTeam = :idTeam")
    fun getTeamDetail(idTeam: String): Flow<TeamsEntity>

    @Query("SELECT * FROM last_events WHERE idHomeTeam = :idTeam OR idAwayTeam = :idTeam")
    fun getLastEventList(idTeam: String): Flow<List<LastEventsEntity>>

    @Query("SELECT * FROM last_events WHERE idEvent = :idEvent")
    fun getLastEventDetail(idEvent: String): Flow<LastEventsEntity>

    @Query("SELECT * FROM next_events WHERE idHomeTeam = :idTeam OR idAwayTeam = :idTeam")
    fun getNextEventList(idTeam: String): Flow<List<NextEventsEntity>>

    @Query("SELECT * FROM last_events WHERE idEvent = :idEvent")
    fun getNextEventDetail(idEvent: String): Flow<NextEventsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagueList(data: List<LeaguesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagueDetail(data: LeagueEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStandingList(data: List<StandingsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamList(data: List<TeamsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamDetail(data: TeamsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLastEventsList(data: List<LastEventsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLastEventDetail(data: LastEventsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNextEventsList(data: List<NextEventsEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNextEventDetail(data: NextEventsEntity)

    @Update
    fun updateIsFavorite(team: TeamsEntity)

}