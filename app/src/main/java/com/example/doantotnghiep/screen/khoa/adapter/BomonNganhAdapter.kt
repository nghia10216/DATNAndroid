package com.example.doantotnghiep.screen.khoa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.BoMon
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_khoa.view.*

class BomonNganhAdapter : RecyclerView.Adapter<BomonNganhAdapter.ViewHolder>() {
    private val bomons = mutableListOf<BoMon>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<BoMon>? = null

    fun updateData(bomons: MutableList<BoMon>?) {
        bomons?.let {
            this.bomons.clear()
            this.bomons.addAll(bomons)
            notifyDataSetChanged()
        }
    }


    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<BoMon>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<BoMon>?
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<BoMon>? = null

        fun bindViewData(bomon: BoMon) {
            itemView.tenkhoaTextView.isSelected = true
            itemView.sttTextView.text = (position + 1).toString()
            itemView.tenkhoaTextView.text = bomon.tenBoMon
            itemView.setOnClickListener(this)
            listener = itemListener
        }

        override fun onClick(p0: View?) {
            listener?.onItemClickListener(bomons[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_khoa, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = bomons.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(bomons[position])
    }

}