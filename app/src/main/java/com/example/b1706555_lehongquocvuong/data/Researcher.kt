package com.example.b1706555_lehongquocvuong.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "researcher_table")
data class Researcher(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val ho: String,
    val ten: String,
    val email: String,
    val donvi: String,
    val h_index: Int,
    val i_10: Int
):Parcelable
