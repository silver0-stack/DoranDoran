package com.swu.doran.mailbox.recieved.member

import java.io.Serializable

data class receivedMemberData(
    val img:String?="",
    val name:String?="",
    val total:Int?=0,
    val badge:Int?=0
):Serializable
