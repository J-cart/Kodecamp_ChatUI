package com.tutorials.kodecampchatui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tutorials.kodecampchatui.FriendProfile
import com.tutorials.kodecampchatui.R
import com.tutorials.kodecampchatui.databinding.ProfileViewholderBinding

class FriendsAdapter : ListAdapter<FriendProfile, FriendsAdapter.ViewHolder>(diffObject) {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ProfileViewholderBinding.bind(view)
        fun bind(friend: FriendProfile) {
            binding.apply {
                profileImg.setImageResource(friend.profileImg)
                titleText.text = friend.userName
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.profile_viewholder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = getItem(position)
        if (pos != null)
            holder.bind(pos)

    }

    companion object {
        val diffObject = object : DiffUtil.ItemCallback<FriendProfile>() {
            override fun areItemsTheSame(oldItem: FriendProfile, newItem: FriendProfile): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: FriendProfile, newItem: FriendProfile): Boolean {
                return oldItem.id == newItem.id && oldItem.userName == newItem.userName
            }
        }
    }

}