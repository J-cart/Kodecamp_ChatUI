package com.tutorials.kodecampchatui.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tutorials.kodecampchatui.data.model.ChatMessage
import com.tutorials.kodecampchatui.R
import com.tutorials.kodecampchatui.databinding.RecentChatViewholderBinding

class MessagesAdapter : ListAdapter<ChatMessage, MessagesAdapter.ViewHolder>(diffObject) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecentChatViewholderBinding.bind(view)
        fun bind(chatMessage: ChatMessage) {
            binding.apply {
                profileImg.setImageResource(chatMessage.profile.profileImg)
                titleText.text = chatMessage.profile.userName
                msgText.text = chatMessage.recentMessage
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recent_chat_viewholder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = getItem(position)
        if (pos != null)
            holder.bind(pos)

    }

    companion object {
        val diffObject = object : DiffUtil.ItemCallback<ChatMessage>() {
            override fun areItemsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
                return oldItem.id == newItem.id && oldItem.profile.userName == newItem.profile.userName
            }
        }
    }

}