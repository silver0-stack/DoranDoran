package com.swu.doran.account

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.swu.doran.R
import com.swu.doran.profile.start.ProfileMenuActivity

class SignInActivity : AppCompatActivity() {
    lateinit var mAuth: FirebaseAuth
    lateinit var Email: EditText
    lateinit var pw: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)

        mAuth = FirebaseAuth.getInstance()
        Email = findViewById(R.id.userEmail)
        pw = findViewById(R.id.userPW)

    }

    // 로그아웃하지 않을 시 자동 로그인 , 회원가입시 바로 로그인 됨
    public override fun onStart() {
        super.onStart()
        moveMainPage(mAuth.currentUser)
    }

    // 유저정보 넘겨주고 메인 액티비티 호출
    private fun moveMainPage(currentUser: FirebaseUser?) {
        val i = Intent(this, ProfileMenuActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
        finish()
    }


    //비번잊음 메소드
    fun forgetPW(view: View) {

    }

    //로그인 버튼 메소드
    fun signInComplete(view: View) {
        signIn(Email.text.toString().trim(), pw.text.toString().trim())
    }

    private fun signIn(email: String, pw: String) {
        if (email.isNotEmpty() && pw.isNotEmpty()) {
            mAuth.signInWithEmailAndPassword(email, pw)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(baseContext, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT)
                            .show()
                        moveMainPage(mAuth.currentUser)
                    } else {
                        Toast.makeText(baseContext, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT)
                            .show()
                     
                    }
                }
        }else{
            Toast.makeText(baseContext, "이메일과 비밀번호를 입력해주세요", Toast.LENGTH_SHORT)
                .show()
        }


    }

    //회원가입 메소드
    fun signUp(view: View) {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    fun change_pw(view: android.view.View) {
        startActivity(Intent(this, PasswordEmailActivity::class.java))
    }
    //로그아웃
    //Firebase.auth.signOut()
}