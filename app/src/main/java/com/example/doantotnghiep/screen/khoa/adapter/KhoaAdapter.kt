package com.example.doantotnghiep.screen.khoa.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Khoa
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.row_khoa.view.*


class KhoaAdapter : RecyclerView.Adapter<KhoaAdapter.ViewHolder>() {
    private val khoas = mutableListOf<Khoa>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Khoa>? = null

    fun updateData(khoas: MutableList<Khoa>?) {
        khoas?.let {
            this.khoas.clear()
            this.khoas.addAll(khoas)
            notifyDataSetChanged()
        }
    }


    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Khoa>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    inner class ViewHolder(
        itemView: View,
        private val itemListener: OnItemRecyclerViewClickListener<Khoa>?
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<Khoa>? = null

        fun bindViewData(khoa: Khoa) {
            itemView.tenkhoaTextView.isSelected = true
            itemView.sttTextView.text = (position + 1).toString()
            itemView.tenkhoaTextView.text = khoa.tenKhoa
            itemView.setOnClickListener(this)
            listener = itemListener
        }

        override fun onClick(p0: View?) {
            listener?.onItemClickListener(khoas[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_khoa, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int = khoas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(khoas[position])
    }

}