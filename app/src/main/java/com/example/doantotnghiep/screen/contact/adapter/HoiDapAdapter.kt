package com.example.doantotnghiep.screen.contact.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HoiDap
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_hoidap.view.*


class HoiDapAdapter :  RecyclerView.Adapter<HoiDapAdapter.ViewHolder>(){
    private val hoidaps = mutableListOf<HoiDap>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<HoiDap>? = null

    fun updateData(hoidaps: MutableList<HoiDap>?) {
        hoidaps?.let {
            this.hoidaps.clear()
            this.hoidaps.addAll(hoidaps)
            notifyDataSetChanged()
        }
    }


    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<HoiDap>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<HoiDap>?
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<HoiDap>? = null

        fun bindViewData(hoidap: HoiDap) {
            Log.d("cautraloi", hoidap.cauTraLoi.toString())
            itemView.tomtatcauhoiTextView.text = hoidap.cauHoi
            if (hoidap.cauTraLoi.isNullOrEmpty()) {
                Log.d("vaoday","me")
                itemView.checkedImageView.setBackgroundResource(R.drawable.ic_baseline_check_outline_24)
            } else {
                Log.d("conlai","me")
                itemView.checkedImageView.setBackgroundResource(R.drawable.ic_baseline_check_circle_outline_24)
            }
            itemView.setOnClickListener(this)
            listener = itemListener
        }

        override fun onClick(p0: View?) {
            listener?.onItemClickListener(hoidaps[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_hoidap, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = hoidaps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(hoidaps[position])
    }
}
