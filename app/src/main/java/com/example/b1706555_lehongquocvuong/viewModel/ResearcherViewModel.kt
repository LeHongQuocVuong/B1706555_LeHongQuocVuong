package com.example.b1706555_lehongquocvuong.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.b1706555_lehongquocvuong.data.Researcher
import com.example.b1706555_lehongquocvuong.database.ResearcherDatabase
import com.example.b1706555_lehongquocvuong.repository.ResearcherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResearcherViewModel(application: Application):AndroidViewModel(application) {
    public val readAllData: LiveData<List<Researcher>>
    private val repository: ResearcherRepository
    init {
        val researcherDAO = ResearcherDatabase.getDatabase(application).researcherDao()
        repository = ResearcherRepository(researcherDAO)
        readAllData = repository.readAllData
    }
    fun addResearcher(researcher: Researcher){
        viewModelScope.launch(Dispatchers.IO){
            repository.addResearcher(researcher)
        }
    }

    fun updateResearcher(researcher: Researcher){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateResearcher(researcher)
        }
    }

    fun deleteResearcher(researcher: Researcher){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteResearcher(researcher)
        }
    }

    fun deleteAllResearchers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllResearchers()
        }
    }
}