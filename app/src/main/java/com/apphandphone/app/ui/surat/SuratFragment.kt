package com.apphandphone.app.ui.surat

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import com.apphandphone.app.R
import com.apphandphone.app.databinding.FragmentSuratBinding
import com.apphandphone.app.ui.home.MainActivity

class SuratFragment : Fragment() {
    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentSuratBinding
    private val viewModel: SuratViewModel by lazy { SuratViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuratBinding.inflate(inflater, container, false).apply {
            viewModel = this@SuratFragment.viewModel
            lifecycleOwner = this@SuratFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun init() {
        binding.recyclerView.adapter = SuratAdapter(parent)
        viewModel.listSurat()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listSurat()
        }
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
            binding.swipeRefresh.isRefreshing = it
        }

        viewModel.actionState.observe(viewLifecycleOwner){
            if (it.isConsumed){
                Log.i("ActionState", "isConsumed")
            }else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

}