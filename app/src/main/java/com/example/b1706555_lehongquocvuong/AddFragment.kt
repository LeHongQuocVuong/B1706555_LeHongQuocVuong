package com.example.b1706555_lehongquocvuong

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.b1706555_lehongquocvuong.data.Researcher
import com.example.b1706555_lehongquocvuong.databinding.FragmentAddBinding
import com.example.b1706555_lehongquocvuong.viewModel.ResearcherViewModel


class AddFragment : Fragment() {
    private lateinit var _binding:FragmentAddBinding
    private lateinit var mUserModelView: ResearcherViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_add, container, false)
        mUserModelView = ViewModelProvider(this).get(ResearcherViewModel::class.java)

        _binding = FragmentAddBinding.inflate(inflater,container,false)
        _binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }
        return _binding.root
    }

    private fun insertDataToDatabase() {
        val ho = _binding.etHo.text.toString()
        val ten = _binding.etTen.text.toString()
        val email = _binding.etEmail.text.toString()
        val donvi = _binding.etDonvi.text.toString()
        val h_index = _binding.etHIndex.text.toString()
        val i_10 = _binding.etI10.text.toString()

        if(checkInput(ho,ten,email,donvi,h_index,i_10)){
            val researcher = Researcher(0,ho,ten,email,donvi,Integer.parseInt(h_index),Integer.parseInt(i_10))
            mUserModelView.addResearcher(researcher)
            Toast.makeText(requireContext(),"Successfully added",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
        }
    }

    private fun checkInput(ho: String, ten: String, email: String, donvi: String, h_index: String, i_10: String): Boolean {
        var check = true
            if(TextUtils.isEmpty(ho)&&TextUtils.isEmpty(ten)&&TextUtils.isEmpty(email)
                &&TextUtils.isEmpty(donvi)&&TextUtils.isEmpty(h_index)&&TextUtils.isEmpty(i_10)){
                if(h_index.toInt()<0&&i_10.toInt()<0){
                    check=true
                }
            }
        return check
    }


}