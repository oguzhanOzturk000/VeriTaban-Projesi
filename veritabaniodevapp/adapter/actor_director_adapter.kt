package com.example.veritabaniodevapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.veritabaniodevapp.databinding.KisilerRecyclerRowBinding
import com.example.veritabaniodevapp.model.liste
import com.example.veritabaniodevapp.model.sanatci
import com.example.veritabaniodevapp.view.direction_bottomnavDirections


class actor_director_adapter(val listOfPeople : ArrayList<sanatci>) : RecyclerView.Adapter<actor_director_adapter.actor_director_viewHolder>() {

    class actor_director_viewHolder(val binding : KisilerRecyclerRowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): actor_director_viewHolder {
        val binding = KisilerRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return actor_director_viewHolder(binding)
    }

    override fun getItemCount(): Int {
         return listOfPeople.size
    }
    fun lsiteyiGuncelle(yeniListe : List<sanatci> ){
        listOfPeople.clear()
        listOfPeople.addAll(yeniListe)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: actor_director_viewHolder, position: Int) {
        holder.binding.personName.text = listOfPeople[position].sanatciad
        holder.binding.personJob.text = listOfPeople[position].meslek
        holder.binding.movieCount.text = "Film sayısı : " + listOfPeople[position].filmsayisi.toString()

        holder.itemView.setOnClickListener {
            val action = direction_bottomnavDirections.actionDirectionBottomnavToPersonFragment(listOfPeople[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}