package com.swu.doran.mailbox.sent.member

import java.io.Serializable

//프사,이름,보낸편지수
data class sentMemberData(
    val img:String,
    val name:String,
    val total:Int
): Serializable
