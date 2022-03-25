package com.swu.doran.mailbox.sent.letter.list

import java.io.Serializable

//리스트사진,"보냈어요",보낸날짜
data class L_Data(
    val img:Int,
    val name:String,
    val date:String
): Serializable