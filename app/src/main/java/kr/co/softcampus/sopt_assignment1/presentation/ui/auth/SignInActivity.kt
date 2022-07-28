package kr.co.softcampus.sopt_assignment1.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.co.softcampus.sopt_assignment1.HomeActivity
import kr.co.softcampus.sopt_assignment1.databinding.ActivitySignInBinding
import kr.co.softcampus.sopt_assignment1.presentation.viewmodel.SignInViewModel

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding
    private val signInViewModel by viewModels<SignInViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        binding.viewModel = signInViewModel
        binding.lifecycleOwner = this

        val activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if(result.resultCode == RESULT_OK){
                    val id = result.data?.getStringExtra("id") ?: ""
                    val pw = result.data?.getStringExtra("pw") ?: ""
                    binding.etId.setText(id)
                    binding.etPw.setText(pw)
                }
            }

        observeLogin()

        binding.btnLogin.setOnClickListener {
            signInViewModel.checkSignInPermission()
        }

        binding.btnReg.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            // 새 액티비티로부터 콜백을 받을 수 있음
            activityResultLauncher.launch(intent)
        }

        setContentView(binding.root)
    }

    private fun observeLogin() {
        signInViewModel.isSuccess.observe(this) {
            when (it) {
                true -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> {
                    Toast.makeText(this, "다시 시도해주세요", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}