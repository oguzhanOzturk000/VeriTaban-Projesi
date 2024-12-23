package com.example.veritabaniodevapp.adapter

import android.app.AlertDialog
import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.veritabaniodevapp.databinding.MovieGridItemBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.listefilm
import com.example.veritabaniodevapp.view.direction_bottomnavDirections
import com.example.veritabaniodevapp.view.lists_pageDirections
import kotlinx.coroutines.NonDisposableHandle.parent

class list_page_movieadapter (val movieList: ArrayList<listefilm>): RecyclerView.Adapter<list_page_movieadapter.movieViewholder>() {

    class movieViewholder(val binding: MovieGridItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewholder {
        val binding = MovieGridItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return movieViewholder(binding)
    }

    override fun onBindViewHolder(holder: movieViewholder, position: Int) {
        val filmid = movieList[position].filmid
        val film : film? = null
        //apiyle film çgrılacak


        holder.binding.movieName.text = film!!.isim
        holder.binding.score.text = film!!.ortalama_puan.toString()
        Glide.with(holder.itemView)
            .load(film!!.poster_uri)
            .fitCenter()
            .into(holder.binding.imageView)

        holder.itemView.setOnClickListener { filmeTiklandiPop(holder, position) }
    }


    override fun getItemCount(): Int {
        return movieList.size
    }
    fun listeyiGuncelle(yeniListe : List<listefilm> ){
        movieList.clear()
        movieList.addAll(yeniListe)
        notifyDataSetChanged()
    }
    fun filmeTiklandiPop(holder : movieViewholder , position: Int){
        val builder = AlertDialog.Builder(holder.itemView.context)
        builder.setMessage("Filmle ne yapılsın?")
            .setPositiveButton("Listeden sil"){dialog,which ->
                //apiyle film listeden silinecek


                filmiCek(holder,position)
            }.setNegativeButton("Filmi gör"){ dialog,which->
                val action = lists_pageDirections.actionListsPageToMovieFragment(movieList[position].id)
                Navigation.findNavController(holder.itemView).navigate(action)
            }.setNeutralButton("İptal"){dialog,which ->

            }.show()

    }
    fun filmiCek(holder : movieViewholder, position: Int){

    }


}