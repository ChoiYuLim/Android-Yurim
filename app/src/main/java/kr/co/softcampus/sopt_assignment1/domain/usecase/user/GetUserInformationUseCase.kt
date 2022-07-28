package kr.co.softcampus.sopt_assignment1.domain.usecase.user

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.softcampus.sopt_assignment1.domain.entity.UserInformation
import kr.co.softcampus.sopt_assignment1.domain.repository.UserRepository
import javax.inject.Inject


class GetUserInformationUseCase @Inject constructor(
    private val repository: UserRepository
)  {
    suspend operator fun invoke(
        userId: String
    ): UserInformation {
        return withContext(Dispatchers.IO) {
            repository.getUserInformation(userId)
        }
    }
}