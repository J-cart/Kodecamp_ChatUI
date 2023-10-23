package com.tutorials.kodecampchatui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tutorials.kodecampchatui.adapters.CategoriesAdapter
import com.tutorials.kodecampchatui.adapters.FriendsAdapter
import com.tutorials.kodecampchatui.adapters.MessagesAdapter
import com.tutorials.kodecampchatui.databinding.ActivityMainBinding

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
}