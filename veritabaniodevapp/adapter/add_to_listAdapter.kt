package com.example.veritabaniodevapp.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.veritabaniodevapp.databinding.FragmentAddToListBinding
import com.example.veritabaniodevapp.databinding.ProfilListeRecyclerRowBinding
import com.example.veritabaniodevapp.model.bilet
import com.example.veritabaniodevapp.model.liste
import com.example.veritabaniodevapp.model.listefilm
import com.example.veritabaniodevapp.view.addToListDirections
import java.time.ZonedDateTime
import androidx.lifecycle.lifecycleScope
import com.example.veritabaniodevapp.service.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.time.format.DateTimeFormatter
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.suspendCoroutine

class add_to_listAdapter(val listOfLists : ArrayList<liste> , val filmId : Int): RecyclerView.Adapter<add_to_listAdapter.addTolistViewHolder>() {

    class addTolistViewHolder(val binding: ProfilListeRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): addTolistViewHolder {
        val binding = ProfilListeRecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return addTolistViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfLists.size
    }
    fun lsiteyiGuncelle(yeniListe : List<liste> ){
        listOfLists.clear()
        listOfLists.addAll(yeniListe)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: addTolistViewHolder, position: Int) {

        holder.binding.aciklamaTextView.text = listOfLists[position].aciklama
        holder.binding.listNameTextView.text = listOfLists[position].isim
        holder.binding.avgScore.text = "Ortalama Puan : " + listOfLists[position].ortalama_puan.toString()
        holder.binding.movieCount.text ="Film sayısı : " + listOfLists[position].film_sayisi.toString()
        holder.itemView.setOnClickListener { kaydet(holder, position)}
        val action = addToListDirections.actionAddToListToMovieFragment(filmId)
        Navigation.findNavController(holder.itemView).navigate(action)
    }
    fun kaydet(holder : addTolistViewHolder , position: Int){
        var listefilm : listefilm?=null

        listefilm!!.listeid = listOfLists[position].id
        listefilm!!.filmid = filmId
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val date = ZonedDateTime.now()
            listefilm!!.eklenme_tarihi = DateTimeFormatter.ofPattern("dd MM yyyy HH:mm").format(date)
        }

    }
}