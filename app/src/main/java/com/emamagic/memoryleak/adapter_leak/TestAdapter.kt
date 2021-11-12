package com.emamagic.memoryleak.adapter_leak

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.emamagic.memoryleak.databinding.RowTestBinding

class TestAdapter(private var onItemClicked: OnItemClicked) :
    ListAdapter<TestModel, TestAdapter.TestViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
        val binding = RowTestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TestViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    class TestViewHolder
    constructor(
        private var binding: RowTestBinding,
        private var onItemClicked: OnItemClicked
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TestModel) {
            binding.txtTest.text = item.id
            binding.root.setOnClickListener{
                onItemClicked.onClicked(item.id)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TestModel>() {
            override fun areItemsTheSame(oldItem: TestModel, newItem: TestModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: TestModel, newItem: TestModel) =
                oldItem == newItem
        }
    }

    interface OnItemClicked {
        fun onClicked(id: String)
    }

}