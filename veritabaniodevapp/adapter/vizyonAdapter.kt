package com.example.veritabaniodevapp.adapter

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.databinding.SeansRecyclerRowItemBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.koltuk
import com.example.veritabaniodevapp.model.seans
import com.example.veritabaniodevapp.model.sinema
import com.example.veritabaniodevapp.model.sinemasalonu

class vizyonAdapter(val listOfSeans : ArrayList<seans>) : RecyclerView.Adapter<vizyonAdapter.vizyonViewHolder>() , PopupMenu.OnMenuItemClickListener{

    private lateinit var popup : PopupMenu

    class vizyonViewHolder(val binding : SeansRecyclerRowItemBinding ) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vizyonViewHolder {
        val binding = SeansRecyclerRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return vizyonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOfSeans.size
    }

    fun lsiteyiGuncelle(yeniListe : List<seans> ){
        listOfSeans.clear()
        listOfSeans.addAll(yeniListe)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: vizyonViewHolder, position: Int) {


        verileriAl(holder)

        popup = PopupMenu(holder.itemView.context,holder.itemView)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.koltuk_sec , popup.menu)
        holder.itemView.setOnClickListener { koltukAlPop() }
    }

    fun koltukAlPop(){
        popup.show()
        popup.setOnMenuItemClickListener (this)
    }
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.birk){
            koltuguAl(1)
        }else if(item!!.itemId == R.id.ikik){
            koltuguAl(2)
        }else if(item!!.itemId == R.id.uck){
            koltuguAl(3)
        }else if(item!!.itemId == R.id.dortk){
            koltuguAl(4)
        }else if(item!!.itemId == R.id.besk){
            koltuguAl(5)
        }else if(item!!.itemId == R.id.altık){
            koltuguAl(6)
        }else if(item!!.itemId == R.id.yedik){
            koltuguAl(7)
        }else if(item!!.itemId == R.id.sekizk){
            koltuguAl(8)
        }else if(item!!.itemId == R.id.dkzk){
            koltuguAl(9)
        }else if(item!!.itemId == R.id.onk){
            koltuguAl(10)
        }else if(item!!.itemId == R.id.onbir){
            koltuguAl(11)
        }else if(item!!.itemId == R.id.oniki){
            koltuguAl(12)
        }else if(item!!.itemId == R.id.onuc){
            koltuguAl(13)
        }else if(item!!.itemId == R.id.ondort){
            koltuguAl(14)
        }else if(item!!.itemId == R.id.onbes){
            koltuguAl(15)
        }else if(item!!.itemId == R.id.onalt){
            koltuguAl(16)
        }else if(item!!.itemId == R.id.onyd){
            koltuguAl(17)
        }else if(item!!.itemId == R.id.onskz){
            koltuguAl(18)
        }else if(item!!.itemId == R.id.ondkz){
            koltuguAl(19)
        }else if(item!!.itemId == R.id.yirmi){
            koltuguAl(20)
        }
        return true
    }
    fun koltuguAl(koltukno : Int){

    }
    fun verileriAl( holder : vizyonViewHolder){
        var film : film
        var seans : seans
        var sinemasalonu : sinemasalonu


        //apiyle üstteki sınıflardan al

        /*
        holder.binding.salon.text = "Salon:" +sinemasalonu.isim
        holder.binding.filmisim.text = film.isim
        holder.binding.filminPuani.text = "Filmin puanı:" + film.ortalama_puan +"/5"
        holder.binding.filmuzunluk.text = film.uzunluk +"dk"
        holder.binding.vizyontarihi.text = seans.tarih
        Glide.with(holder.itemView)
            .load(film.poster_url)
            .fitCenter()
            .into(holder.binding.afis)

         */
    }
}