package com.example.b1706555_lehongquocvuong.repository

import androidx.lifecycle.LiveData
import com.example.b1706555_lehongquocvuong.DAO.ResearcherDAO
import com.example.b1706555_lehongquocvuong.data.Researcher

class ResearcherRepository(private val researcherDAO: ResearcherDAO) {
    val readAllData: LiveData<List<Researcher>> = researcherDAO.readAllData()

    suspend fun addResearcher(researcher: Researcher){
        researcherDAO.AddResearcher(researcher)
    }

    suspend fun deleteResearcher(researcher: Researcher){
        researcherDAO.deleteResearcher(researcher)
    }

    suspend fun deleteAllResearchers(){
        researcherDAO.deleteAllResearchers()
    }

    suspend fun updateResearcher(researcher: Researcher){
        researcherDAO.updateResearcher(researcher)
    }
}