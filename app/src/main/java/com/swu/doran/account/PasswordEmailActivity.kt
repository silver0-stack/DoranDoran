package com.swu.doran.account

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.swu.doran.R
import java.util.regex.Pattern

class PasswordEmailActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_pw)

        email = findViewById(R.id.userEmail)
        btn = findViewById(R.id.email_pw)
        //이메일 확인하기
        email.addTextChangedListener(object : TextWatcher {
            // EditText에 문자 입력 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            // EditText에 변화가 있을 경우
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val emailAddress = email.text.toString().trim()
                val pattern: Pattern = Patterns.EMAIL_ADDRESS

                if (pattern.matcher(emailAddress).matches()) {
                   email.setBackgroundDrawable(ContextCompat.getDrawable(this@PasswordEmailActivity, R.drawable.edittext_rightcheck))
                    btn.isEnabled=true
                } else {
                    email.setBackgroundDrawable(ContextCompat.getDrawable(this@PasswordEmailActivity, R.drawable.edittext_wrongcheck))
                }
            }

            // EditText 입력이 끝난 후
            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    //비밀번호 재설정 이메일 버튼
    fun email_pw(view: android.view.View) {
        val emailAddress = email.text.toString().trim()

        FirebaseAuth.getInstance().sendPasswordResetEmail(emailAddress)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "이메일 전송을 성공했습니다.", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this, EmailToSignIn::class.java))
                } else {
                    Toast.makeText(baseContext, "이메일 전송을 실패했습니다.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

    //앱 내에서 비밀번호 변경
    fun to_app_pw(view: android.view.View) {
        startActivity(Intent(this, PasswordAppActivity::class.java))
    }
}