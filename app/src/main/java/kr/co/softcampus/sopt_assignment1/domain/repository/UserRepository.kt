package kr.co.softcampus.sopt_assignment1.domain.repository

import kr.co.softcampus.sopt_assignment1.domain.entity.UserInformation

interface UserRepository {
    suspend fun getUserInformation(userId: String): UserInformation
    suspend fun insertUserInformation(userInformation: UserInformation): Long
    suspend fun updateUserInformation(userInformation: UserInformation)
}