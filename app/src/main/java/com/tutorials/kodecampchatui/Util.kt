package com.tutorials.kodecampchatui

data class ChatMessage(
    val id: Int = 0,
    val profile: FriendProfile = FriendProfile(),
    val recentMessage: String = ""
)


data class FriendProfile(
    val id: Int = 0,
    val profileImg: Int = 0,
    val userName: String = ""
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
        profileImg = R.drawable.dia_cooking,
        userName = "Morgan Ford Bill"
    ),
    FriendProfile(
        id = 2,
        profileImg = R.drawable.dia_cooking,
        userName = "Dainee Russel"
    ),
    FriendProfile(
        id = 3,
        profileImg = R.drawable.dia_cooking,
        userName = "Marvin Mckindaey"
    ),
    FriendProfile(
        id = 4,
        profileImg = R.drawable.dia_cooking,
        userName = "Esther Howard"
    ),
    FriendProfile(
        id = 5,
        profileImg = R.drawable.dia_cooking,
        userName = "Sam Smith"
    ),
    FriendProfile(
        id = 6,
        profileImg = R.drawable.dia_cooking,
        userName = "Morgan Bill"
    ),
    FriendProfile(
        id = 7,
        profileImg = R.drawable.dia_cooking,
        userName = "Ford Bill"
    ),
    FriendProfile(
        id = 8,
        profileImg = R.drawable.dia_cooking,
        userName = "Howard Esther"
    ),
    FriendProfile(
        id = 9,
        profileImg = R.drawable.dia_cooking,
        userName = "Mckindaey Marvin"
    ),
    FriendProfile(
        id = 10,
        profileImg = R.drawable.dia_cooking,
        userName = "Russel Dainee"
    ),
    FriendProfile(
        id = 11,
        profileImg = R.drawable.dia_cooking,
        userName = "Russel Bill"
    ),
    FriendProfile(
        id = 12,
        profileImg = R.drawable.dia_cooking,
        userName = "Morgan Dainee"
    ),
    FriendProfile(
        id = 13,
        profileImg = R.drawable.dia_cooking,
        userName = "Mckindaey Morgan "
    ),
    FriendProfile(
        id = 14,
        profileImg = R.drawable.dia_cooking,
        userName = "Howard Morgan "
    ),
    FriendProfile(
        id = 15,
        profileImg = R.drawable.dia_cooking,
        userName = "Bill Howard"
    ),
    FriendProfile(
        id = 16,
        profileImg = R.drawable.dia_cooking,
        userName = "Morgan Esther Bill"
    ),
    FriendProfile(
        id = 17,
        profileImg = R.drawable.dia_cooking,
        userName = "Marvin Bill"
    ),
    FriendProfile(
        id = 18,
        profileImg = R.drawable.dia_cooking,
        userName = "Morgan Smith"
    ),
    FriendProfile(
        id = 19,
        profileImg = R.drawable.dia_cooking,
        userName = "Sam Morgan "
    ),
    FriendProfile(
        id = 20,
        profileImg = R.drawable.dia_cooking,
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