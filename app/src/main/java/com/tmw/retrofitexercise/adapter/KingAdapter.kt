package com.tmw.retrofitexercise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.createBitmap
import androidx.recyclerview.widget.RecyclerView
import com.tmw.retrofitexercise.R
import com.tmw.retrofitexercise.model.King
import com.tmw.retrofitexercise.model.KingItem
import kotlinx.android.synthetic.main.king_list.view.*

class KingAdapter(var king:ArrayList<KingItem>):RecyclerView.Adapter<KingAdapter.KingViewHolder>(){
    class KingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun kingBind(king:KingItem){
            itemView.txtClass.text=king.`class`
            itemView.txtID.text=king.id
            itemView.txtImg.text=king.img_url
            itemView.txtName.text=king.name
            itemView.txtCount.text=king.vote_count.toString()
            itemView.txtStatus.text=king.vote_time_status.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KingViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.king_list,parent,false)
        return KingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return king.size
    }

    override fun onBindViewHolder(holder: KingViewHolder, position: Int) {
        holder.kingBind(king[position])
    }
}