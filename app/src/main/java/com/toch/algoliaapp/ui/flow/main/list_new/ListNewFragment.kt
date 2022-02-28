package com.toch.algoliaapp.ui.flow.main.list_new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.toch.algoliaapp.R
import com.toch.algoliaapp.base.BaseFragment
import com.toch.algoliaapp.databinding.FragmentListNewBinding
import com.toch.algoliaapp.model.HitDomain
import com.toch.algoliaapp.model.state.ListNewState
import com.toch.algoliaapp.ui.flow.main.MainViewModel
import com.toch.algoliaapp.ui.flow.main.list_new.adapter.HitAdapter
import com.toch.algoliaapp.utils.data.ErrorDomain
import com.toch.algoliaapp.utils.data.ErrorEntity
import com.toch.algoliaapp.utils.extension.collectLastLifecycleFLow
import com.toch.algoliaapp.utils.extension.openHitDialog
import com.toch.algoliaapp.utils.extension.setupItemTouch

class ListNewFragment  : BaseFragment(){

    private var _binding: FragmentListNewBinding? = null

    private val binding get() = _binding!!

    private val adapter = HitAdapter(action = ::openHitDialog)

    private val vm by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListNewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        swipeConfig()
        vm.getHit()
        collectLastLifecycleFLow(vm.state, ::setupState)
        collectLastLifecycleFLow(vm.cacheData, ::setupData)
    }

    private fun setupData(hits : List<HitDomain>?){
        hits?.let {
            if (it.isNotEmpty()) {
                adapter.setData(it)
            }else{
                vm.getHit()
            }
        }
    }

    private fun swipeConfig(){
        binding.spRefresh.apply {
            setOnRefreshListener {
                vm.getHit()
            }
            setColorSchemeResources (
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
            )
        }
    }

    private fun setupRv() {
        binding.apply {
            rvNew.layoutManager = LinearLayoutManager(requireContext())
            rvNew.adapter = adapter
            rvNew.setupItemTouch(::deleteItem)
        }
    }

    private fun setupState(state: ListNewState) {
        state.apply {
            binding.spRefresh.isRefreshing = this == ListNewState.Loading
            when (this){
                is ListNewState.SuccessData -> {  }
                is ListNewState.Error -> { errorStateHandler(error) }
                else -> { }
            }
        }
    }

    private fun errorStateHandler(error: ErrorDomain) {
        when (error) {
            is ErrorEntity -> Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
            else -> Toast.makeText(requireContext(), getString(R.string.error), Toast.LENGTH_LONG).show()
        }
        vm.getCacheHit()
    }

    private fun deleteItem(position: Int) {
        vm.deleteCacheHit(adapter.getItem(position), position, ::deleteInAdapter)
    }

    private fun deleteInAdapter(position: Int){
        adapter.deleteItem(position)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}