package com.example.veritabaniodevapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.veritabaniodevapp.databinding.MovieGridItemBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.yorum
import com.example.veritabaniodevapp.view.direction_bottomnavDirections

class main_page_movie_adapter(val movieList: ArrayList<film>): RecyclerView.Adapter<main_page_movie_adapter.mainpageViewHolder>() {

    class mainpageViewHolder(val binding: MovieGridItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mainpageViewHolder {
        val binding = MovieGridItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return mainpageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
    fun lsiteyiGuncelle(yeniListe : List<film> ){
        movieList.clear()
        movieList.addAll(yeniListe)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: mainpageViewHolder, position: Int) {
        holder.binding.movieName.text = movieList[position].isim
        holder.binding.score.text = movieList[position].ortalama_puan.toString()

        Glide.with(holder.itemView.context)
            .load(movieList[position].poster_uri)
            .fitCenter()
            .into(holder.binding.imageView)



        holder.itemView.setOnClickListener {
            val action = direction_bottomnavDirections.actionDirectionBottomnavToMovieFragment(movieList[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}