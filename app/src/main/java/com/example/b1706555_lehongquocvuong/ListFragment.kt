package com.example.b1706555_lehongquocvuong

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.b1706555_lehongquocvuong.databinding.FragmentAddBinding
import com.example.b1706555_lehongquocvuong.databinding.FragmentListBinding
import com.example.b1706555_lehongquocvuong.viewModel.ResearcherViewModel


class ListFragment : Fragment() {
    private lateinit var _binding: FragmentListBinding
    private lateinit var mUserModelView: ResearcherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_list, container, false)

        _binding = FragmentListBinding.inflate(inflater,container,false)

        //recyclerView
        val adapter = ResearcherAdapter()
        _binding.rvListResearcher.adapter = adapter
        _binding.rvListResearcher.layoutManager= LinearLayoutManager(requireContext())
        //View model
        mUserModelView = ViewModelProvider(this).get(ResearcherViewModel::class.java)
        mUserModelView.readAllData.observe(viewLifecycleOwner, Observer{
                researchers->adapter.setData(researchers)
        })

        _binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return _binding.root
    }


}