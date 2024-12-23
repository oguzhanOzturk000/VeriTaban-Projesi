package com.example.veritabaniodevapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.veritabaniodevapp.databinding.MovieGridItemBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.filmsanatci
import com.example.veritabaniodevapp.service.apiService
import com.example.veritabaniodevapp.view.direction_bottomnavDirections
import com.example.veritabaniodevapp.view.person_fragmentDirections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class kisi_filmAdapter (val movieList: ArrayList<filmsanatci>): RecyclerView.Adapter<kisi_filmAdapter.kisifilmViewHolder>() {

    class kisifilmViewHolder(val binding: MovieGridItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): kisifilmViewHolder {
        val binding = MovieGridItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return kisifilmViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    fun lsiteyiGuncelle(yeniListe : List<filmsanatci> ){
        movieList.clear()
        movieList.addAll(yeniListe)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: kisifilmViewHolder, position: Int) {

        val film = filmiBul(movieList[position].filmid)

        holder.binding.movieName.text = film.isim
        holder.binding.score.text = film.ortalama_puan.toString()
        Glide.with(holder.itemView)
            .load(film.poster_uri)
            .fitCenter()
            .into(holder.binding.imageView)

        holder.itemView.setOnClickListener {
            val action = person_fragmentDirections.actionPersonFragment2ToMovieFragment(movieList[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun filmiBul(filmid : Int) : film{
        var filmSonuc : film? = null
        CoroutineScope(Dispatchers.IO).launch{
            val response = apiService.filmsApi.getFilmById(filmid)

        }
        return filmSonuc!!
    }
}