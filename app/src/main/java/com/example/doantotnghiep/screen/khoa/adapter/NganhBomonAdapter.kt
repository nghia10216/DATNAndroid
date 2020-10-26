package com.example.doantotnghiep.screen.khoa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Nganh
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_khoa.view.*

class NganhBomonAdapter : RecyclerView.Adapter<NganhBomonAdapter.ViewHolder>() {
    private val nganhs = mutableListOf<Nganh>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Nganh>? = null

    fun updateData(nganhs: MutableList<Nganh>?) {
        nganhs?.let {
            this.nganhs.clear()
            this.nganhs.addAll(nganhs)
            notifyDataSetChanged()
        }
    }


    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Nganh>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<Nganh>?
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<Nganh>? = null

        fun bindViewData(nganh: Nganh) {
            itemView.tenkhoaTextView.isSelected = true
            itemView.sttTextView.text = (position + 1).toString()
            itemView.tenkhoaTextView.text = nganh.tenNganh
            itemView.setOnClickListener(this)
            listener = itemListener
        }

        override fun onClick(p0: View?) {
            listener?.onItemClickListener(nganhs[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_khoa, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = nganhs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(nganhs[position])
    }

}