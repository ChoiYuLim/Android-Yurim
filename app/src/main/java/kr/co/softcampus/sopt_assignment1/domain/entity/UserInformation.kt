package kr.co.softcampus.sopt_assignment1.domain.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class UserInformation(
    val userId: String,
    val userPassword: String,
    val userName: String,
    val userAge: Int?,
    val userMbti: String?,
    val userImage: String?,
)