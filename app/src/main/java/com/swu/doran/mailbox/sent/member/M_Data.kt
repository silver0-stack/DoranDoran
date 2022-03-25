package com.swu.doran.mailbox.sent.member

import java.io.Serializable

//프사,이름,보낸편지수
data class M_Data(
    val img:Int,
    val name:String,
    val accumulated:Int
): Serializable
