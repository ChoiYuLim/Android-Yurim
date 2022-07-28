package kr.co.softcampus.sopt_assignment1.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "UserInformation")
data class User(
    @PrimaryKey val userId: String,
    @ColumnInfo(name="userPassword") val userPassword: String,
    @ColumnInfo(name="userName") val userName: String,
    @ColumnInfo(name="userAge") val userAge: Int?,
    @ColumnInfo(name="userMbti") val userMbti: String?,
    @ColumnInfo(name="userImage") val userImage: String?,
)