package com.swu.doran.account

data class RegisterUser(//사용자 이름
    var userName: String, //사용자 프로필사진
    var profileImageUrl: String, //사용자 이메일
    var userEmail: String, //로그인한 사용자 고유아이디
    var uid: String
) {
    @JvmName("getUserName1")
    fun getUserName(): String {
        return userName
    }

    @JvmName("setUserName1")
    fun setUserName(title: String?) {
        userName = userName
    }
}

