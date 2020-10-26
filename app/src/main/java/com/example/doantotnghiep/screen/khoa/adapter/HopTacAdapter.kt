package com.example.doantotnghiep.screen.khoa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.DonViHopTac
import com.example.doantotnghiep.untils.Constant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_donvi_hoptac.view.*
import kotlinx.android.synthetic.main.row_khoa.view.*
import kotlinx.android.synthetic.main.row_thong_tin_nganh.view.*

class HopTacAdapter : RecyclerView.Adapter<HopTacAdapter.ViewHolder>() {
    private val hoptacs = mutableListOf<DonViHopTac>()

    fun updateData(hoptacs: MutableList<DonViHopTac>?) {
        hoptacs?.let {
            this.hoptacs.clear()
            this.hoptacs.addAll(hoptacs)
            notifyDataSetChanged()
        }
    }


    inner class ViewHolder(
        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView) {

        fun bindViewData(hoptac: DonViHopTac) {
            itemView.tendonviTextView.text = hoptac.tenDonVi
            Picasso.get().load(Constant.BASE_URL_IMAGE_DONVI + hoptac.link).into(itemView.donvihoptacImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_donvi_hoptac, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = hoptacs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(hoptacs[position])
    }

}