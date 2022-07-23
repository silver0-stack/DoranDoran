package com.swu.doran.account

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.swu.doran.R


class SignUpActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth //FirebaseAuth 인스턴스 선언
    private lateinit var Email: EditText
    private lateinit var PW: EditText
    private lateinit var PW_confirm: EditText
    private lateinit var emailCheck: TextView
    private lateinit var pwCheck: TextView
    private lateinit var pw_confirmCheck: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        mAuth = FirebaseAuth.getInstance() //FirebaseAuth 인스턴스 초기화
        Email = findViewById(R.id.userEmail)
        PW = findViewById(R.id.userPW)
        PW_confirm = findViewById(R.id.userPW_confirm)
        emailCheck = findViewById(R.id.emailCheck)
        pwCheck = findViewById(R.id.pwCheck)
        pw_confirmCheck = findViewById(R.id.pw_confirmCheck)


        //이메일 확인하기
        Email.addTextChangedListener(object : TextWatcher {
            // EditText에 문자 입력 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            // EditText에 변화가 있을 경우
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmail()
            }

            // EditText 입력이 끝난 후
            override fun afterTextChanged(s: Editable?) {

            }
        })
        //비밀번호 확인하기
        PW.addTextChangedListener(object : TextWatcher {
            // EditText에 문자 입력 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            // EditText에 변화가 있을 경우
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (PW.length() >= 6) {
                    pwCheck.visibility = View.VISIBLE
                    PW.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@SignUpActivity,
                            R.drawable.edittext_rightcheck
                        )
                    )
                } else PW.setBackgroundDrawable(
                    ContextCompat.getDrawable(
                        this@SignUpActivity,
                        R.drawable.edittext_wrongcheck
                    )
                )
            }

            // EditText 입력이 끝난 후
            override fun afterTextChanged(s: Editable?) {
            }
        })

        //비밀번호 일치 여부 확인하기
        PW_confirm.addTextChangedListener(object : TextWatcher {
            // EditText에 문자 입력 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            // EditText에 변화가 있을 경우
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (PW.text.toString().trim() == PW_confirm.text.toString().trim()) {
                    PW_confirm.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@SignUpActivity,
                            R.drawable.edittext_rightcheck
                        )
                    )
                    pw_confirmCheck.visibility = View.VISIBLE
                } else {
                    PW_confirm.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@SignUpActivity,
                            R.drawable.edittext_wrongcheck
                        )
                    )
                }
            }

            // EditText 입력이 끝난 후
            override fun afterTextChanged(s: Editable?) {
            }
        })

    }

    fun checkEmail(): Boolean {
        val email = Email.text.toString().trim() //공백제거

        //이메일 정규식
        val pattern = Patterns.EMAIL_ADDRESS

        if (pattern.matcher(email).matches()) {
            Email.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.edittext_rightcheck
                )
            )
            emailCheck.visibility = View.VISIBLE
            return true
        } else {
            Email.setBackgroundDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.edittext_wrongcheck
                )
            )
        }
        return false
    }


    fun signUpComplete(view: View) {
        createAccount(
            Email.text.toString().trim(),
            PW.text.toString().trim(),
            PW_confirm.text.toString().trim(),
        )
    }

    private fun createAccount(email: String, pw: String, pw_confirm: String) {
        if (email.isNotEmpty() && pw.isNotEmpty() && pw_confirm.isNotEmpty()) {
            mAuth.createUserWithEmailAndPassword(email, pw)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "계정 생성 완료", Toast.LENGTH_SHORT)
                            .show();
                        moveMainPage(mAuth.currentUser)
                    } else {
                        Toast.makeText(this, "계정 생성 실패", Toast.LENGTH_SHORT)
                            .show();
                    }
                }
        }
    }

    private fun moveMainPage(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }
}