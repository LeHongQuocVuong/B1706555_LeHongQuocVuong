package com.example.b1706555_lehongquocvuong.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.b1706555_lehongquocvuong.DAO.ResearcherDAO
import com.example.b1706555_lehongquocvuong.data.Researcher

@Database (entities = [Researcher::class], version = 1, exportSchema = false)
abstract class ResearcherDatabase: RoomDatabase() {
    abstract fun researcherDao(): ResearcherDAO
    companion object{
        @Volatile
        private var INSTANCE: ResearcherDatabase? = null
        fun getDatabase(context: Context): ResearcherDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ResearcherDatabase::class.java,
                    "researcher_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}