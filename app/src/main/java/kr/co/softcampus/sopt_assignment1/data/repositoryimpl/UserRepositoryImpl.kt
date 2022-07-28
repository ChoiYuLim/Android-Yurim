package kr.co.softcampus.sopt_assignment1.data.repositoryimpl

import kr.co.softcampus.sopt_assignment1.data.datasource.local.UserDao
import kr.co.softcampus.sopt_assignment1.data.mapper.UserMapper
import kr.co.softcampus.sopt_assignment1.domain.entity.UserInformation
import kr.co.softcampus.sopt_assignment1.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) : UserRepository {
    override suspend fun getUserInformation(userId: String): UserInformation {
        return UserMapper.mapperToUserInformation(userDao.getUserInformation(userId))
    }

    override suspend fun insertUserInformation(userInformation: UserInformation): Long {
        return userDao.insertUserInformation(UserMapper.mapperToUser(userInformation))
    }

    override suspend fun updateUserInformation(userInformation: UserInformation) {
        userDao.updateUserInformation(UserMapper.mapperToUser(userInformation))
    }
}