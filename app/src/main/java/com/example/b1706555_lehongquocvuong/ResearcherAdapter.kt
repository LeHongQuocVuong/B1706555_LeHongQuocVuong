package com.example.b1706555_lehongquocvuong

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.b1706555_lehongquocvuong.data.Researcher

class ResearcherAdapter: RecyclerView.Adapter<ResearcherAdapter.MyViewHolder>() {
    private var researcherList = emptyList<Researcher>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.researcher_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var currentResearcher = researcherList[position]
        holder.itemView.findViewById<TextView>(R.id.tv_id).text = currentResearcher.id.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_ho).text = currentResearcher.ho.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_ten).text = currentResearcher.ten.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_email).text = currentResearcher.email.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_donvi).text = currentResearcher.donvi.toString()
        holder.itemView.findViewById<TextView>(R.id.tv_i_10).text = currentResearcher.i_10.toString() + " (i-10)"
        holder.itemView.findViewById<TextView>(R.id.tv_h_index).text = currentResearcher.h_index.toString() + " (h-index)"

        //Update
        holder.itemView.findViewById<ConstraintLayout>(R.id.row_layout).setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentResearcher)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return researcherList.size
    }

    fun setData(researchers:List<Researcher>){
        this.researcherList = researchers
        notifyDataSetChanged()
    }
}