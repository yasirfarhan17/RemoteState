package com.remote_state.truky.ui.listactivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.glocal.techsupport.ui.base.BaseActivity
import com.google.android.gms.maps.model.LatLng
import com.remote_state.networkdomain.model.TruckItemEntity
import com.remote_state.truky.R
import com.remote_state.truky.databinding.ActivityListBinding
import com.remote_state.truky.ui.listactivity.ListViewModel
import com.remote_state.truky.ui.listactivity.adapter.TruckAdapter
import com.remote_state.truky.ui.map.MapActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListActivity : BaseActivity<ActivityListBinding>() {

    override fun layoutId(): Int = R.layout.activity_list
    val truckList = ArrayList<TruckItemEntity>()


    private val _viewModel: ListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        addListener()
        addObservers()
    }


    private fun initUi() {
        with(binding) {
            _viewModel.getTruckList()
            appbar.tvTitle.text = getString(R.string.txt_app_namee)
            rvTrucks.adapter = TruckAdapter()
            rvTrucks.layoutManager = LinearLayoutManager(this@ListActivity)
            appbar.imgMap.setOnClickListener {
                val bundle=Bundle().apply {
                    putParcelableArrayList(MapActivity.KEY_LAT_LNG,truckList)
                }
                navigator.startActivityWithData(MapActivity::class.java,bundle)
            }
        }
    }
    private fun addListener() {
        binding.appbar.imgMap.setOnClickListener {
            val bundle = Bundle().apply {
                putParcelableArrayList(MapActivity.KEY_LAT_LNG, truckList)
            }
            navigator.startActivityWithData(MapActivity::class.java, bundle)
        }
        binding.appbar.imgSearch.setOnClickListener {
            binding.appbar.clNormalLayout.visibility = View.GONE
            binding.appbar.clSearch.visibility = View.VISIBLE
        }
        binding.appbar.imgNormal.setOnClickListener {
            binding.appbar.clNormalLayout.visibility = View.VISIBLE
            binding.appbar.clSearch.visibility = View.GONE
            (binding.rvTrucks.adapter as TruckAdapter).restoreAllList()

        }
        binding.appbar.imgCut.setOnClickListener {
            if(binding.appbar.etSearch.text.isNullOrBlank()){
                binding.appbar.clNormalLayout.visibility = View.VISIBLE
                binding.appbar.clSearch.visibility = View.GONE
                (binding.rvTrucks.adapter as TruckAdapter).restoreAllList()
                return@setOnClickListener
            }
            binding.appbar.etSearch.text?.clear()
        }
        binding.appbar.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                (binding.rvTrucks.adapter as TruckAdapter).filter.filter(p0.toString());
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

    }


    override fun addObservers() {
        observeTruckList()
        observeError()
    }

    private fun observeError() {
        _viewModel.setError.observe(this, {
            showToast(it.toString())
        })
    }

    private fun observeTruckList() {
        _viewModel.setTruckList.observe(this, {
            if (it?.data == null || it.responseCode == null || it.responseCode?.responseCode == null || it.responseCode!!.responseCode!! == 0) {
                uiUtil.showToast("Something went wrong")
                return@observe
            }
            truckList.clear()
            for (item in it.data!!) {
                truckList.add(item!!.toTruckItemEntity())
            }
            (binding.rvTrucks.adapter as TruckAdapter).submitList(list = truckList)
        })
    }
}