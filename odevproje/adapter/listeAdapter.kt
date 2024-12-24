package com.example.odevproje.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.odevproje.databinding.FilmRowItemBinding
import com.example.odevproje.model.film
import com.example.odevproje.model.liste
import com.example.odevproje.model.listefilm
import com.example.odevproje.service.apiServis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class listeAdapter (val listOfFilms : ArrayList<listefilm>) : RecyclerView.Adapter<listeAdapter.listeViewHolder>() {

    class listeViewHolder(val binding : FilmRowItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listeViewHolder {
        val binding = FilmRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return listeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfFilms.size
    }
    fun listeyiGuncelle(yeniListe : List<listefilm>){
        listOfFilms.clear()
        listOfFilms.addAll(yeniListe)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: listeViewHolder, position: Int) {

        verileriCek(holder, position)
    }
    fun verileriCek(holder: listeViewHolder, position: Int){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val sonuc = apiServis.filmsApi.getFilmById(listOfFilms[position].filmid)
                withContext(Dispatchers.Main){
                    holder.binding.filmadi.text= sonuc.isim
                    holder.binding.filmkonusu.text = sonuc.konu
                    holder.binding.filmminpuani.text = sonuc.ortalama_puan.toString()
                }


            }catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}