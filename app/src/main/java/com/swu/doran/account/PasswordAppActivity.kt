package com.swu.doran.account

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.swu.doran.R

///
class PasswordAppActivity : AppCompatActivity() {
    lateinit var newpw: EditText
    lateinit var checkpw: EditText
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_pw)

        newpw = findViewById(R.id.newpw)
        checkpw = findViewById(R.id.checkpw)
        btn = findViewById(R.id.app_pw)

        //비밀번호 일치 여부 확인하기
        newpw.addTextChangedListener(object : TextWatcher {
            // EditText에 문자 입력 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            // EditText에 변화가 있을 경우
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (newpw.text.toString().trim() == checkpw.text.toString().trim()) {
                    newpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
                            R.drawable.edittext_rightcheck
                        )
                    )
                    checkpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
                            R.drawable.edittext_rightcheck
                        )
                    )
                    btn.isEnabled=true
                } else {
                    newpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
                            R.drawable.edittext_wrongcheck
                        )
                    )
                    checkpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
                            R.drawable.edittext_wrongcheck
                        )
                    )
                }
            }

            // EditText 입력이 끝난 후
            override fun afterTextChanged(s: Editable?) {
       
            }
        })




        //비밀번호 "확인" 일치 여부 확인하기
        checkpw.addTextChangedListener(object : TextWatcher {
            // EditText에 문자 입력 전
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            // EditText에 변화가 있을 경우
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (newpw.text.toString().trim() == checkpw.text.toString().trim()) {
                    newpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
                            R.drawable.edittext_rightcheck
                        )
                    )
                    checkpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
                            R.drawable.edittext_rightcheck
                        )
                    )
                    btn.isEnabled=true
                } else {
                    newpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
                            R.drawable.edittext_wrongcheck
                        )
                    )
                    checkpw.setBackgroundDrawable(
                        ContextCompat.getDrawable(
                            this@PasswordAppActivity,
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

    fun back(view: android.view.View) {
        super.onBackPressed()
    }

    //버튼
    fun app_pw(view: android.view.View) {
        val user = FirebaseAuth.getInstance().currentUser
        val newPassword = newpw.text.toString().trim()

        user!!.updatePassword(newPassword)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "비밀번호 변경을 성공했습니다.", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this, SignInActivity::class.java))
                }else{
                    Toast.makeText(baseContext, "비밀번호 변경을 실패했습니다.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
    }

}