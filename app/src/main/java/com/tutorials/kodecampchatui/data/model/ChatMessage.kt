package com.tutorials.kodecampchatui.data.model

data class ChatMessage(
    val id: Int = 0,
    val profile: FriendProfile = FriendProfile(),
    val recentMessage: String = ""
)