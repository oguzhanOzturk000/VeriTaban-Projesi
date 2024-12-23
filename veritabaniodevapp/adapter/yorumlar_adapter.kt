package com.example.veritabaniodevapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.veritabaniodevapp.adapter.actor_director_adapter.actor_director_viewHolder
import com.example.veritabaniodevapp.databinding.CommentRecyclerRowBinding
import com.example.veritabaniodevapp.databinding.FragmentCommentfragmentBinding
import com.example.veritabaniodevapp.model.sinema
import com.example.veritabaniodevapp.model.yorum
import com.example.veritabaniodevapp.view.direction_bottomnavDirections

class yorumlar_adapter(val listOfComments : ArrayList<yorum>) : RecyclerView.Adapter<yorumlar_adapter.YorumlarViewHolder>() {

    class YorumlarViewHolder(val binding: CommentRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YorumlarViewHolder {
        val binding = CommentRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return YorumlarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfComments.size
    }

    fun lsiteyiGuncelle(yeniListe : List<yorum> ){
        listOfComments.clear()
        listOfComments.addAll(yeniListe)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: YorumlarViewHolder, position: Int) {
        holder.binding.username.text = listOfComments[position].sahipid.toString()
        holder.binding.comment.text = listOfComments[position].yorum

    }

}