package com.soft.attendancekt.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class Member(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int,
//    @TypeConverters(TypeConverter::class)
//    val gender: Gender,
    val phone: String,
    val email: String,
    val photo: String,
    val barcode: String
)/*{
    enum class Gender{
        MALE, FEMALE
    }
}*/