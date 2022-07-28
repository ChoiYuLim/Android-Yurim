package kr.co.softcampus.sopt_assignment1.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kr.co.softcampus.sopt_assignment1.domain.repository.UserRepository
import kr.co.softcampus.sopt_assignment1.domain.usecase.user.GetUserInformationUseCase
import kr.co.softcampus.sopt_assignment1.domain.usecase.user.InsertUserInformationUseCase
import kr.co.softcampus.sopt_assignment1.domain.usecase.user.UpdateUserInformationUseCase


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @ViewModelScoped
    @Provides
    fun provideGetUserInformationUseCase(
        repository: UserRepository
    ): GetUserInformationUseCase {
        return GetUserInformationUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideInsertUserInformationUseCase(
        repository: UserRepository
    ): InsertUserInformationUseCase {
        return InsertUserInformationUseCase(repository)
    }

    @ViewModelScoped
    @Provides
    fun provideUpdateUserInformationUseCase(
        repository: UserRepository
    ): UpdateUserInformationUseCase {
        return UpdateUserInformationUseCase(repository)
    }
}