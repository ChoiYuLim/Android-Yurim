package kr.co.softcampus.sopt_assignment1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.softcampus.sopt_assignment1.data.datasource.local.UserDao
import kr.co.softcampus.sopt_assignment1.data.repositoryimpl.UserRepositoryImpl
import kr.co.softcampus.sopt_assignment1.domain.repository.UserRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepository(
        userDao: UserDao
    ): UserRepository = UserRepositoryImpl(userDao)
}