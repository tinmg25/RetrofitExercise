package com.tmw.retrofitexercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tmw.retrofitexercise.R
import com.tmw.retrofitexercise.model.QueenItem
import kotlinx.android.synthetic.main.king_list.view.*

class QueenAdapter(var queen:ArrayList<QueenItem>):RecyclerView.Adapter<QueenAdapter.QueenViewHolder>(){
    class QueenViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun queenBind(queen:QueenItem){
            itemView.txtClass.text=queen.`class`
            itemView.txtID.text=queen.id
            itemView.txtImg.text=queen.img_url
            itemView.txtName.text=queen.name
            itemView.txtCount.text=queen.vote_count.toString()
            itemView.txtStatus.text=queen.vote_time_status.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueenViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.queen_list,parent,false)
        return QueenViewHolder(view)
    }

    override fun getItemCount(): Int {
        return queen.size
    }

    override fun onBindViewHolder(holder: QueenViewHolder, position: Int) {
        holder.queenBind(queen[position])
    }
}