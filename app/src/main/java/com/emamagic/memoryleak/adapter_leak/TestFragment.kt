package com.emamagic.memoryleak.adapter_leak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.emamagic.memoryleak.R
import com.emamagic.memoryleak.databinding.FragmentTestBinding

class TestFragment: Fragment(), TestAdapter.OnItemClicked {

    lateinit var binding: FragmentTestBinding
    private lateinit var adapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TestAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
        adapter.submitList(dummyData())

    }

    private fun dummyData(): List<TestModel> {
        val data = ArrayList<TestModel>()
        for (i in 0..50) { data.add(TestModel("$i")) }
        return data
    }

    override fun onClicked(id: String) {
        findNavController().navigate(R.id.action_testFragment_to_test2Fragment)
    }
}