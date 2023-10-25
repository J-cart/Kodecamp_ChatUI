package com.tutorials.kodecampchatui.data

import com.tutorials.kodecampchatui.R
import com.tutorials.kodecampchatui.data.model.Category
import com.tutorials.kodecampchatui.data.model.ChatMessage
import com.tutorials.kodecampchatui.data.model.FriendProfile


val imageList = listOf(
    R.drawable.image_1,
    R.drawable.image_2,
    R.drawable.image_3,
    R.drawable.image_4,
    R.drawable.image_5,
)

val categoryList = mutableListOf(
    Category(
        id = 1,
        name = "All"
    ),
    Category(
        id = 2,
        name = "Mentions"
    ),
    Category(
        id = 3,
        name = "Replies"
    ),
    Category(
        id = 4,
        name = "Events"
    ),
)

val friendList = listOf(
    FriendProfile(
        id = 1,
        profileImg = imageList.random(),
        userName = "Morgan Ford Bill"
    ),
    FriendProfile(
        id = 2,
        profileImg = imageList.random(),
        userName = "Dainee Russel"
    ),
    FriendProfile(
        id = 3,
        profileImg = imageList.random(),
        userName = "Marvin Mckindaey"
    ),
    FriendProfile(
        id = 4,
        profileImg = imageList.random(),
        userName = "Esther Howard"
    ),
    FriendProfile(
        id = 5,
        profileImg = imageList.random(),
        userName = "Sam Smith"
    ),
    FriendProfile(
        id = 6,
        profileImg = imageList.random(),
        userName = "Morgan Bill"
    ),
    FriendProfile(
        id = 7,
        profileImg = imageList.random(),
        userName = "Ford Bill"
    ),
    FriendProfile(
        id = 8,
        profileImg = imageList.random(),
        userName = "Howard Esther"
    ),
    FriendProfile(
        id = 9,
        profileImg = imageList.random(),
        userName = "Mckindaey Marvin"
    ),
    FriendProfile(
        id = 10,
        profileImg = imageList.random(),
        userName = "Russel Dainee"
    ),
    FriendProfile(
        id = 11,
        profileImg = imageList.random(),
        userName = "Russel Bill"
    ),
    FriendProfile(
        id = 12,
        profileImg = imageList.random(),
        userName = "Morgan Dainee"
    ),
    FriendProfile(
        id = 13,
        profileImg = imageList.random(),
        userName = "Mckindaey Morgan "
    ),
    FriendProfile(
        id = 14,
        profileImg = imageList.random(),
        userName = "Howard Morgan "
    ),
    FriendProfile(
        id = 15,
        profileImg = imageList.random(),
        userName = "Bill Howard"
    ),
    FriendProfile(
        id = 16,
        profileImg = imageList.random(),
        userName = "Morgan Esther Bill"
    ),
    FriendProfile(
        id = 17,
        profileImg = imageList.random(),
        userName = "Marvin Bill"
    ),
    FriendProfile(
        id = 18,
        profileImg = imageList.random(),
        userName = "Morgan Smith"
    ),
    FriendProfile(
        id = 19,
        profileImg = imageList.random(),
        userName = "Sam Morgan "
    ),
    FriendProfile(
        id = 20,
        profileImg = imageList.random(),
        userName = "Morgan Smith Bill"
    ),
)

private val messages = listOf(
    "Hello there",
    "Hello there🤘",
    "Hi there",
    "Hi there🙂",
    "We have a soccer match tomorrow",
    "Will you be tomorrow",
    "I'm good, How about you?",
    "I'm fine thanks👌",
    "Okay, got it👍",
    "Missed your call, Whats up?",
    "We are leaving town tomorrow",
    "Why, is something up?",
    "LFG🚀🚀",
    "Have you seen the new dollar to NGN rate?",
    "Just saw it, its really getting out of hand?",
    "If i had know, I'd have bought some on forex and short it🙄🙄",
    "is that even possible?",
    "Ion know, just saying 🤧🤧",
    "😂😂😂",
    "Last night was fun😎😎",
    "IKR🍸🍸"
)

fun getAllMessages(): List<ChatMessage> {
    val allMessages = friendList.map { friendProfile ->
        ChatMessage(
            profile = friendProfile,
            recentMessage = messages.random()
        )
    }
    return allMessages
}