package com.example.veritabaniodevapp.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.veritabaniodevapp.databinding.ProfilListeRecyclerRowBinding
import com.example.veritabaniodevapp.model.liste
import com.example.veritabaniodevapp.view.direction_bottomnavDirections

class profile_page_adapter(val listOfLists : ArrayList<liste>): RecyclerView.Adapter<profile_page_adapter.profilPageViewHolder>(){

    class profilPageViewHolder(val binding : ProfilListeRecyclerRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): profilPageViewHolder {
        val binding = ProfilListeRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return profilPageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfLists.size
    }
    fun listeyiGncelle(yeniListelerListesi : ArrayList<liste> ){
        listOfLists.clear()
        listOfLists.addAll(yeniListelerListesi)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: profilPageViewHolder, position: Int) {
        holder.binding.aciklamaTextView.text = listOfLists[position].aciklama
        holder.binding.listNameTextView.text = listOfLists[position].isim
        holder.binding.avgScore.text = "Ortalama Puan : " + listOfLists[position].ortalama_puan.toString()
        holder.binding.movieCount.text ="Film sayısı : " + listOfLists[position].film_sayisi.toString()

        holder.itemView.setOnClickListener {
            val action = direction_bottomnavDirections.actionDirectionBottomnavToListsPage(listOfLists[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}