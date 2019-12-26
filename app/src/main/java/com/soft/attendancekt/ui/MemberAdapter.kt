package com.soft.attendancekt.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soft.attendancekt.BR
import com.soft.attendancekt.R
import com.soft.attendancekt.model.entity.Member
import com.soft.attendancekt.util.AdapterItemClickListener

class MemberAdapter() : ListAdapter<Member, MemberAdapter.MemberViewHolder>(DiffCallBack()) {

    lateinit var adapterItemClickListener: AdapterItemClickListener<Member>
    /*set(adapterClick: AdapterItemClickListener<Member>) {
        field = adapterClick
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var dataBinding: ViewDataBinding =
            DataBindingUtil.inflate(inflater, R.layout.layout_add_member, parent, false)
        return MemberViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding: ViewDataBinding

        constructor(binding: ViewDataBinding) : this(binding.root) {
            this.binding = binding
            binding.root.setOnClickListener {
                adapterItemClickListener.onClick(getItem(adapterPosition))
            }
        }

        fun bind(member: Member) {
            binding.setVariable(BR.viewModel, member)
        }

    }

}

class DiffCallBack : DiffUtil.ItemCallback<Member>() {
    override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
        return oldItem == newItem
    }

}