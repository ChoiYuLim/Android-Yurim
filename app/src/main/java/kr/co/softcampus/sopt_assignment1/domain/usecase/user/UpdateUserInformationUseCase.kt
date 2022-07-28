package kr.co.softcampus.sopt_assignment1.domain.usecase.user

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kr.co.softcampus.sopt_assignment1.domain.entity.UserInformation
import kr.co.softcampus.sopt_assignment1.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUserInformationUseCase @Inject constructor(
private val repository: UserRepository
) {
    suspend operator fun invoke(
        userId: String,
        userPassword: String,
        userName: String,
        userAge: Int?,
        userMbti: String?,
        userImage: String?
    ) {
        withContext(Dispatchers.IO) {
            repository.updateUserInformation(
                UserInformation(
                    userId,
                    userPassword,
                    userName,
                    userAge,
                    userMbti,
                    userImage
                )
            )
        }
    }
}