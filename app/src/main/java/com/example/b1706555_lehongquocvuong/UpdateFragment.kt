package com.example.b1706555_lehongquocvuong

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.b1706555_lehongquocvuong.data.Researcher
import com.example.b1706555_lehongquocvuong.databinding.FragmentListBinding
import com.example.b1706555_lehongquocvuong.databinding.FragmentUpdateBinding
import com.example.b1706555_lehongquocvuong.viewModel.ResearcherViewModel


class UpdateFragment : Fragment() {
    private lateinit var _binding: FragmentUpdateBinding
    private lateinit var mResearcherViewModel: ResearcherViewModel
    private val args by navArgs<UpdateFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_update, container, false)
        mResearcherViewModel = ViewModelProvider(this).get(ResearcherViewModel::class.java)
        _binding = FragmentUpdateBinding.inflate(inflater,container,false)
        _binding.etHoUpdate.setText(args.currentResearcher.ho)
        _binding.etTenUpdate.setText(args.currentResearcher.ten)
        _binding.etEmailUpdate.setText(args.currentResearcher.email)
        _binding.etDonviUpdate.setText(args.currentResearcher.donvi)

        _binding.etI10Update.setText(args.currentResearcher.i_10.toString())
        _binding.etHIndexUpdate.setText(args.currentResearcher.h_index.toString())
        _binding.btnUpdate.setOnClickListener {
            updateResearcher()
        }


        return _binding.root
    }
    private fun deleteResearcher():Boolean{
        val builder= AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_
            ->mResearcherViewModel.deleteResearcher(args.currentResearcher)
            Toast.makeText(requireContext(),"Successfull removed: ${args.currentResearcher.ten}",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,_
            ->

        }
        builder.setTitle("Delete ${args.currentResearcher.ten}?")
        builder.setMessage("Are you sure you want to delete ${args.currentResearcher.ten}?")
        builder.create().show()
        return true
    }

    private fun updateResearcher() {
        val ho = _binding.etHoUpdate.text.toString()
        val ten = _binding.etTenUpdate.text.toString()
        val email = _binding.etEmailUpdate.text.toString()
        val donvi = _binding.etDonviUpdate.text.toString()
        val h_index = Integer.parseInt(_binding.etHIndexUpdate.text.toString())
        val i_10 = Integer.parseInt(_binding.etI10Update.text.toString())
        if(checkInput(ho,ten,email,donvi,h_index,i_10)){
            val updateResearcher = Researcher(args.currentResearcher.id,ho,ten,email,donvi,h_index,i_10)
            mResearcherViewModel.updateResearcher(updateResearcher)
            Toast.makeText(requireContext(),"Update successfully",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
        }
    }

    private fun checkInput(ho: String, ten: String, email: String, donvi: String, h_index: Int, i_10: Int): Boolean {
        var check = true
        if(!TextUtils.isEmpty(ho)&&TextUtils.isEmpty(ten)&&TextUtils.isEmpty(email)
            &&TextUtils.isEmpty(donvi)){

                check=true

        }
        return check
    }


}