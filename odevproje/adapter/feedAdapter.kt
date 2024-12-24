package com.example.odevproje.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odevproje.databinding.ListeRowItemBinding
import com.example.odevproje.model.liste
import com.example.odevproje.view.feedFragmentDirections

class feedAdapter (val listOfLists : ArrayList<liste>): RecyclerView.Adapter<feedAdapter.feedViewHolder>() {

    class feedViewHolder(val binding : ListeRowItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): feedViewHolder {
        val binding =ListeRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return feedViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfLists.size
    }
    fun listeyiGuncelle(yeniListe : ArrayList<liste>){
        listOfLists.clear()
        listOfLists.addAll(yeniListe)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: feedViewHolder, position: Int) {
        holder.binding.aciklama.text = listOfLists[position].aciklama
        holder.binding.listeadi.text = listOfLists[position].isim
        holder.itemView.setOnClickListener {
            val action = feedFragmentDirections.actionFeedFragmentToListeFragment(listOfLists[position].id!!)
            Navigation.findNavController(holder.itemView).navigate(action)
        }
    }
}