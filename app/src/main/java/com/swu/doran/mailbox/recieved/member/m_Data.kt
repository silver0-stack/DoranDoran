package com.swu.doran.mailbox.recieved.member

import java.io.Serializable

data class m_Data(
    val img:Int,
    val name:String,
    val accumulated:Int,
    val badge: String
):Serializable
