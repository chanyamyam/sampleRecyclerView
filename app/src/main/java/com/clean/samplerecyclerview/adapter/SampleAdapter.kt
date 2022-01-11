package com.clean.samplerecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.clean.samplerecyclerview.databinding.SampleViewBinding
import com.clean.samplerecyclerview.model.Samplemodel
import com.clean.samplerecyclerview.viewHolder.SampleViewHolder

class SampleAdapter: ListAdapter<Samplemodel,SampleViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder(SampleViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        // 달라진 list만 바꾸게 해서 flickering, 시간지연 방지를 도와줌!
        val diffUtil = object:DiffUtil.ItemCallback<Samplemodel>() {
            override fun areItemsTheSame(oldItem: Samplemodel, newItem: Samplemodel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Samplemodel, newItem: Samplemodel): Boolean {
                return oldItem.name == newItem.name
            }

        }
    }
}