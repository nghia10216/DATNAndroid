package com.example.doantotnghiep.screen.hompage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.untils.Constant
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_thong_tin_nganh.view.*
import java.util.*

class ThongTinNganhAdapter() :
    RecyclerView.Adapter<ThongTinNganhAdapter.ViewHolder?>(), Filterable {

    private val thongTinNganhs = mutableListOf<ThongTinNganh>()
    private val thongTinNganhListAll = mutableListOf<ThongTinNganh>()

    private var onItemClickListener: OnItemRecyclerViewClickListener<ThongTinNganh>? = null

    fun updateData(thongTinNganhs: MutableList<ThongTinNganh>?) {
        thongTinNganhs?.let {
            this.thongTinNganhs.clear()
            this.thongTinNganhs.addAll(thongTinNganhs)
            thongTinNganhListAll.addAll(thongTinNganhs)
            notifyDataSetChanged()
        }
    }

    fun addNewThongTinNganh(thongTinNganh: ThongTinNganh) {
        thongTinNganhs.add(thongTinNganh)
        notifyItemInserted(thongTinNganhs.size)
    }

    fun registerItemRecyclerViewClickListener(
        onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<ThongTinNganh>?
    ) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_thong_tin_nganh, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewData(thongTinNganhs[position])
    }

    override fun getItemCount() = thongTinNganhs.size

    inner class ViewHolder(
        itemView: View, private val itemListener: OnItemRecyclerViewClickListener<ThongTinNganh>?
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var listener: OnItemRecyclerViewClickListener<ThongTinNganh>? = null
        fun bindViewData(thongTinNganh: ThongTinNganh) {
            Picasso.get().load(Constant.BASE_URL_IMAGE + thongTinNganh.anhGioiThieu).into(itemView.thongtinnganhImageView)

            itemView.tennganhTextView.text = thongTinNganh.nganh?.tenNganh
            itemView.trinhdodaotaoTextView.text = thongTinNganh.trinhDoDaoTao + ", "
            itemView.hinhthucdaotaoTextView.text = thongTinNganh.hinhThucDaoTao + ", "
            itemView.chitieuTextView.text = "Chỉ tiêu: " + thongTinNganh.chiTieu
            itemView.hocphiTextView.text = thongTinNganh.hocPhi
            itemView.hinhthuctuyensinhTextView.text = thongTinNganh.hinhThucTuyenSinh
            itemView.tohopmonTextView.text = thongTinNganh.toHopMonXetTuyen
            itemView.diemchuanTextView.text = thongTinNganh.diemChuanCacNam
            itemView.setOnClickListener(this)
            listener = itemListener
        }

        override fun onClick(v: View?) {
            listener?.onItemClickListener(thongTinNganhs[adapterPosition])
        }

    }

    override fun getFilter(): Filter {
        return filter1
    }

    private val filter1 = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterList = arrayListOf<ThongTinNganh>()
            if (constraint.toString().isEmpty()) {
                filterList.addAll(thongTinNganhListAll)
            } else {
                for (thongtinnganh in thongTinNganhListAll) {
                    if (thongtinnganh.nganh?.tenNganh?.toLowerCase(Locale.ROOT)
                            ?.contains(constraint.toString().toLowerCase(Locale.ROOT))!!
                    ) {
                        filterList.add(thongtinnganh)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filterList

            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults) {

//            val list2 = results.values.toList().map{ data -> ThongTinNganh() }
            val list = results.values as? MutableList<*>
            val list1 = list?.map { it as ThongTinNganh }?.toMutableList() ?: mutableListOf()

            //(result.values as? List<ThongTin>)?.let{ updateData(it) }

            thongTinNganhs.clear()
            thongTinNganhs.addAll(list1)
            notifyDataSetChanged()
        }

    }

}

