package com.mike.commitbrowser.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mike.commitbrowser.databinding.CardViewIndividualCommitBinding
import com.mike.commitbrowser.model.CommitItem

class CommitItemAdapter :
    ListAdapter<CommitItem, CommitItemAdapter.ViewHolder>(CommitItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder private constructor(val binding: CardViewIndividualCommitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CommitItem) {
            binding.commit = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CardViewIndividualCommitBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)

            }
        }
    }
}

class CommitItemDiffCallback : DiffUtil.ItemCallback<CommitItem>() {

    override fun areItemsTheSame(oldItem: CommitItem, newItem: CommitItem): Boolean {
        return oldItem.sha == newItem.sha
    }


    override fun areContentsTheSame(oldItem: CommitItem, newItem: CommitItem): Boolean {
        return oldItem == newItem
    }
}