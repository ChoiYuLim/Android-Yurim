package kr.co.softcampus.sopt_assignment1.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kr.co.softcampus.sopt_assignment1.HomeActivity
import kr.co.softcampus.sopt_assignment1.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)

        val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if(result.resultCode == RESULT_OK){
                    val id = result.data?.getStringExtra("id") ?: ""
                    val pw = result.data?.getStringExtra("pw") ?: ""
                    binding.etId.setText(id)
                    binding.etPw.setText(pw)
                }
            }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            if(binding.etId.length()!=0 && binding.etPw.length()!=0) {
                Toast.makeText(this, binding.etId.text.toString()+"님 환영합니다", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnReg.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            // 새 액티비티로부터 콜백을 받을 수 있음
            activityResultLauncher.launch(intent)
        }

        setContentView(binding.root)
    }
}