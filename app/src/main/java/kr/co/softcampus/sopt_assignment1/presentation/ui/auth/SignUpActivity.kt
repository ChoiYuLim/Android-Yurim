package kr.co.softcampus.sopt_assignment1.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.co.softcampus.sopt_assignment1.databinding.ActivitySignUpBinding
import kr.co.softcampus.sopt_assignment1.presentation.viewmodel.SignUpViewModel

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val signUpViewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        binding.viewModel = signUpViewModel
        binding.lifecycleOwner = this

        observeSignUp()
        binding.btnReg.setOnClickListener {
            signUpViewModel.checkSignUpPermission()
        }

        setContentView(binding.root)
    }

    private fun observeSignUp() {
        signUpViewModel.isSuccess.observe(this) {
            when (it) {
                true -> {
                    val intent = Intent(this, SignInActivity::class.java).apply {
                        putExtra("userId", binding.etId.text.toString())
                    }
                    setResult(RESULT_OK, intent)
                    if (!isFinishing) {
                        finish()
                    }
                }
                else -> {
                    Toast.makeText(this, "다시 시도해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
