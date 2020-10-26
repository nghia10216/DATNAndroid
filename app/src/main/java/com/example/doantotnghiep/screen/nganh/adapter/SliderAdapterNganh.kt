package com.example.doantotnghiep.screen.nganh.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.HinhAnhNganh
import com.example.doantotnghiep.untils.Constant
import com.smarteist.autoimageslider.SliderViewAdapter
import java.util.ArrayList

class SliderAdapterNganh :
    SliderViewAdapter<SliderAdapterNganh.SliderAdapterVH>() {
    private var mSliderItems: MutableList<HinhAnhNganh> = ArrayList()

    fun renewItems(sliderItems: MutableList<HinhAnhNganh>) {
        mSliderItems = sliderItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        mSliderItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(sliderItem: HinhAnhNganh) {
        mSliderItems.add(sliderItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val sliderItem: HinhAnhNganh = mSliderItems[position]
        viewHolder.textViewDescription.text = sliderItem.tenAnh
        viewHolder.textViewDescription.textSize = 16f
        viewHolder.textViewDescription.setTextColor(Color.WHITE)
        Glide.with(viewHolder.itemView)
            .load(Constant.BASE_URL_IMAGENGANH + sliderItem.link)
            .fitCenter()
            .into(viewHolder.imageViewBackground)
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return mSliderItems.size
    }

    inner class SliderAdapterVH(itemView: View) :
        ViewHolder(itemView) {
        var imageViewBackground: ImageView = itemView.findViewById(R.id.iv_auto_image_slider)
        var textViewDescription: TextView = itemView.findViewById(R.id.tv_auto_image_slider)
    }
}