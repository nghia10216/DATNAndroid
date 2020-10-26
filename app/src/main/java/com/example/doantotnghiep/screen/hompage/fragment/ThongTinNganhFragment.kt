package com.example.doantotnghiep.screen.hompage.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doantotnghiep.R
import com.example.doantotnghiep.data.model.Suggestion
import com.example.doantotnghiep.data.model.ThongTinNganh
import com.example.doantotnghiep.data.source.remote.ThongTinNganhRemoteDataSource
import com.example.doantotnghiep.data.source.thongtinnganh.ThongTinNganhRepository
import com.example.doantotnghiep.screen.hompage.adapter.ThongTinNganhAdapter
import com.example.doantotnghiep.untils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.fragment_thong_tin_nganh.*
import java.util.*


class ThongTinNganhFragment : Fragment(), OnItemRecyclerViewClickListener<ThongTinNganh>,
    ThongTinNganhContract.View {

    private var thongTinNganhPresenter: ThongTinNganhContract.Presenter? = null
    var mSuggestions: MutableList<Suggestion>? = null
    private var progressDialog: ProgressDialog? = null
    private val adapter: ThongTinNganhAdapter by lazy { ThongTinNganhAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thong_tin_nganh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true);
        initView()
        initData()
        thongTinNganhPresenter?.getThongTinNganh()
    }

    private fun initData() {
        progressDialog?.show()
        mSuggestions = mutableListOf()
        thongTinNganhPresenter = context?.let {
            ThongTinNganhPresenter(
                ThongTinNganhRepository.getInstance(ThongTinNganhRemoteDataSource.getInstance()),
                this
            )
        }
    }

    private fun initView() {
        progressDialog = ProgressDialog(context)

        (activity as AppCompatActivity?)!!.setSupportActionBar(floating_search_view)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayShowTitleEnabled(false)

        thongtinnganhRecycleview.setHasFixedSize(true)
        thongtinnganhRecycleview.adapter = adapter
        thongtinnganhRecycleview.layoutManager = LinearLayoutManager(context)
        adapter.registerItemRecyclerViewClickListener(this)
    }

    override fun onItemClickListener(item: ThongTinNganh?) {
        openFragment(ChiTietThongTinNganhFragment(), item)
    }


    override fun onSuccess(data: MutableList<ThongTinNganh>) {
        progressDialog?.dismiss()
        for (index in data.indices) {
            data[index].nganh?.tenNganh?.let { Suggestion(it, index) }
                ?.let { mSuggestions?.add(it) }

        }
        adapter.updateData(data)
    }

    override fun onError(error: String) {
        progressDialog?.dismiss()
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun openFragment(fragment: Fragment, item: ThongTinNganh?) {
        val bundle = Bundle()
        bundle.putSerializable("thongTinNganh", item)
        fragment.arguments = bundle
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.fragment_container, fragment)
            ?.addToBackStack(null)
            ?.commit()
    }

}