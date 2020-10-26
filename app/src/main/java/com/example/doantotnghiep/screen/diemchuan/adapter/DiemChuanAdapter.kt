package com.example.doantotnghiep.screen.diemchuan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.DiemChuan
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_diemchuan.view.*

class DiemChuanAdapter : RecyclerView.Adapter<DiemChuanAdapter.ViewHolder>() {
    private val diemchuans = mutableListOf<DiemChuan>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<DiemChuan>? = null

    fun updateData(diemchuans: MutableList<DiemChuan>?) {
        diemchuans?.let {
            this.diemchuans.clear()
            this.diemchuans.addAll(diemchuans)
            notifyDataSetChanged()
        }
    }


    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<DiemChuan>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<DiemChuan>?
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<DiemChuan>? = null

        fun bindViewData(diemchuan: DiemChuan) {
//            itemView.tenkhoaTextView.isSelected = true
            itemView.sothutuTextView.text = (position + 1).toString()
            itemView.tennganhTextView.text = diemchuan.nganh?.tenNganh
            itemView.diemtrungtuyenTextView.text = diemchuan.diemTrungTuyen
            itemView.tohopmonTextView.text = diemchuan.toHop
            itemView.dieukienphuTextView.text = diemchuan.dieuKienPhu

            itemView.setOnClickListener(this)
            listener = itemListener
        }

        override fun onClick(p0: View?) {
            listener?.onItemClickListener(diemchuans[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_diemchuan, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = diemchuans.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(diemchuans[position])
    }

}
