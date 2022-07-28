package kr.co.softcampus.sopt_assignment1.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kr.co.softcampus.sopt_assignment1.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM UserInformation WHERE userId = :id")
    suspend fun getUserInformation(id: String): User

    @Insert
    suspend fun insertUserInformation(userInformation: User): Long

    @Update
    suspend fun updateUserInformation(userInformation: User)
}