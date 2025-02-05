package kr.co.softcampus.sopt_assignment1.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kr.co.softcampus.sopt_assignment1.data.remote.RequestSignupData
import kr.co.softcampus.sopt_assignment1.data.remote.ResponseSignupData
import kr.co.softcampus.sopt_assignment1.data.remote.ResponseWrapper
import kr.co.softcampus.sopt_assignment1.R
import kr.co.softcampus.sopt_assignment1.data.remote.ServiceCreator
import kr.co.softcampus.sopt_assignment1.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        RegisterButton()

        setContentView(binding.root)
    }

    private fun RegisterButton() {
        binding.btnReg.setOnClickListener {
            if (checkInputText()) {
                Toast.makeText(this, R.string.blank, Toast.LENGTH_SHORT).show()
            } else {
                initNetwork()
            }
        }
    }

    private fun checkInputText(): Boolean {
        return binding.etId.text.isNullOrBlank() || binding.etPw.text.isNullOrBlank() || binding.etName.text.isNullOrBlank()
    }

    private fun initNetwork() {
        val requestSignupData = RequestSignupData(
            id = binding.etId.text.toString(),
            name = binding.etName.text.toString(),
            password = binding.etPw.text.toString()
        )

        val call: Call<ResponseWrapper<ResponseSignupData>> =
            ServiceCreator.signupService.postSignup(requestSignupData)

        call.enqueue(object : Callback<ResponseWrapper<ResponseSignupData>> {

            override fun onResponse(
                call: Call<ResponseWrapper<ResponseSignupData>>,
                response: Response<ResponseWrapper<ResponseSignupData>>
            ) {
                if (response.isSuccessful) {
                    val Intent_SignIn = Intent(this@SignUpActivity, SignInActivity::class.java)
                    Intent_SignIn.putExtra("id", binding.etId.text.toString())
                    Intent_SignIn.putExtra("pw", binding.etPw.text.toString())
                    Toast.makeText(
                        this@SignUpActivity,
                        "${response.body()?.data?.name}님 회원가입 완료",
                        Toast.LENGTH_LONG
                    ).show()
                    setResult(RESULT_OK, Intent_SignIn)
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "회원가입 실패", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseWrapper<ResponseSignupData>>, t: Throwable) {
                //에러 처리
                Toast.makeText(this@SignUpActivity, "ERROR", Toast.LENGTH_LONG).show()
                Log.e("NetworkTest", "error:$t")
            }

        })
    }
}
