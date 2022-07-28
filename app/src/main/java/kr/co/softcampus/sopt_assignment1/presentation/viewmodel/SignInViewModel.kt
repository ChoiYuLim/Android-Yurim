package kr.co.softcampus.sopt_assignment1.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.co.softcampus.sopt_assignment1.domain.entity.UserInformation
import kr.co.softcampus.sopt_assignment1.domain.usecase.user.GetUserInformationUseCase
import kr.co.softcampus.sopt_assignment1.util.SingleLiveEvent
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getUserInformationUseCase: GetUserInformationUseCase
): ViewModel() {
    var userId = MutableLiveData<String>()
    var userPassword = MutableLiveData<String>()

    private var _userInformation = MutableLiveData<UserInformation>()
    val userInformation: LiveData<UserInformation> get() = _userInformation

    private var _isSuccess = SingleLiveEvent<Boolean>()
    val isSuccess: LiveData<Boolean> get() = _isSuccess

    fun checkSignInPermission() {
        if(!userId.value.isNullOrBlank() && !userId.value.isNullOrBlank()) {
            login()
        }
    }

    private fun login() {
        viewModelScope.launch {
            kotlin.runCatching {
                getUserInformationUseCase.invoke(userId.value!!)
            }.onSuccess {
                _userInformation.value = it
                checkLoginSuccess()
            }.onFailure {
                _isSuccess.value = false
            }
        }
    }

    private fun checkLoginSuccess() {
        _isSuccess.value = (userInformation.value?.userId == userId.value && userInformation.value?.userPassword == userPassword.value)
    }
}