package com.tutorials.kodecampchatui.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.tutorials.kodecampchatui.R
import com.tutorials.kodecampchatui.data.categoryList
import com.tutorials.kodecampchatui.data.friendList
import com.tutorials.kodecampchatui.data.getAllMessages
import com.tutorials.kodecampchatui.data.model.Category
import com.tutorials.kodecampchatui.data.model.ChatMessage
import com.tutorials.kodecampchatui.data.model.FriendProfile
import com.tutorials.kodecampchatui.databinding.ActivityMainBinding
import com.tutorials.kodecampchatui.ui.adapters.CategoriesAdapter
import com.tutorials.kodecampchatui.ui.adapters.FriendsAdapter
import com.tutorials.kodecampchatui.ui.adapters.MessagesAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val messagesAdapter by lazy { MessagesAdapter() }
    private val friendsAdapter by lazy { FriendsAdapter() }
    private val categoriesAdapter by lazy { CategoriesAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeSearchViewPlate()

        binding.apply {
            categoriesRv.adapter = categoriesAdapter
            topChatRv.adapter = friendsAdapter
            recentChatsRv.adapter = messagesAdapter

            updateMessageAdapter(getAllMessages())
            updateFriendAdapter(friendList)
            updateCategoryAdapter(categoryList[0])

            categoriesAdapter.adapterClickListener {
                updateCategoryAdapter(it)
                updateFriendAdapter(friendList.shuffled().reversed())
            }
        }
    }

    private fun updateMessageAdapter(messages: List<ChatMessage>){
        messagesAdapter.submitList(messages)
    }
    private fun updateFriendAdapter(friends: List<FriendProfile>){
        friendsAdapter.submitList(friends)
    }

    private fun updateCategoryAdapter(category: Category) {
        val newCategories = mutableListOf<Category>()

        categoryList.forEach {
            if (it.id == category.id){
               val copyCategory = it.copy(isSelected = true)
                newCategories.add(copyCategory)
            }else{
                newCategories.add(it)
            }

        }

        categoriesAdapter.submitList(newCategories)
    }

    private fun changeSearchViewPlate(){
        val searchPlate = binding.searchBar.findViewById<View>(androidx.appcompat.R.id.search_plate)
        searchPlate.setBackgroundResource(R.drawable.transparent_background)
    }

    private fun toggleUIMode(){
        val search = binding.searchBar
        val searchEditText =
            search.findViewById(androidx.appcompat.R.id.search_src_text) as EditText

        val blackColor = ContextCompat.getColor(
            this,
            R.color.black
        )
        val greyColor = ContextCompat.getColor(
            this,
            R.color.grey_4
        )

        val nightModeFlags = this.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK
        when (nightModeFlags) {
            Configuration.UI_MODE_NIGHT_YES -> {
                searchEditText.setHintTextColor(blackColor)
                searchEditText.setTextColor(blackColor)
            }
            Configuration.UI_MODE_NIGHT_NO -> {
                searchEditText.setHintTextColor(greyColor)
                searchEditText.setTextColor(blackColor)
            }
            Configuration.UI_MODE_NIGHT_UNDEFINED -> searchEditText.setHintTextColor(blackColor)
        }
    }
}