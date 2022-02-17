package com.swu.doran.mailbox.sent.member

import java.io.Serializable

data class M_Data(
    val img:Int,
    val name:String,
    val accumulated:Int
): Serializable
