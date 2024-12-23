package com.example.veritabaniodevapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.veritabaniodevapp.databinding.SinemaRecylerRowBinding
import com.example.veritabaniodevapp.model.sinema
import com.example.veritabaniodevapp.view.direction_bottomnavDirections

class sinemaAdapter (val listOfSinema : ArrayList<sinema>): RecyclerView.Adapter<sinemaAdapter.sinemaViewHolder>() {

    class sinemaViewHolder(val binding : SinemaRecylerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sinemaViewHolder {
        val binding = SinemaRecylerRowBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return sinemaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfSinema.size
    }

    fun lsiteyiGuncelle(yeniListe : List<sinema> ){
        listOfSinema.clear()
        listOfSinema.addAll(yeniListe)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: sinemaViewHolder, position: Int) {
        holder.binding.adres.text = listOfSinema[position].adres
        holder.binding.sinemaad.text = listOfSinema[position].isim

        holder.itemView.setOnClickListener {
            val action = direction_bottomnavDirections.actionDirectionBottomnavToBuyingTicketFragment2(listOfSinema[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }


}