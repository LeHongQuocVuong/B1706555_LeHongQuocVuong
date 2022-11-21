package com.example.b1706555_lehongquocvuong.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.b1706555_lehongquocvuong.data.Researcher

@Dao
interface ResearcherDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun AddResearcher(researcher: Researcher)

    @Query("SELECT * FROM researcher_table ORDER BY h_index DESC")
    fun readAllData():LiveData<List<Researcher>>

    @Update
    suspend fun updateResearcher(researcher: Researcher)

    @Delete
    suspend fun deleteResearcher(researcher: Researcher)

    @Query("DELETE FROM researcher_table")
    fun  deleteAllResearchers()
}