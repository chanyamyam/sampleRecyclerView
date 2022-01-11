package com.clean.samplerecyclerview.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.clean.samplerecyclerview.databinding.SampleViewBinding
import com.clean.samplerecyclerview.model.Samplemodel

class SampleViewHolder(private val binding: SampleViewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(samplemodel: Samplemodel) {
        binding.nameTextView.text = samplemodel.name
        binding.infoTextView.text = samplemodel.info
    }
}