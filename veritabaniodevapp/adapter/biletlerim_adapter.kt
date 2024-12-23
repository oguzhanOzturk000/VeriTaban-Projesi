package com.example.veritabaniodevapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.veritabaniodevapp.databinding.BiletItemRowBinding
import com.example.veritabaniodevapp.model.bilet
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.koltuk
import com.example.veritabaniodevapp.model.seans
import com.example.veritabaniodevapp.model.sinema
import com.example.veritabaniodevapp.model.sinemasalonu

class biletlerim_adapter( val biletListesi : ArrayList<bilet>) :RecyclerView.Adapter<biletlerim_adapter.biletlerimViewHolder>(){

    class biletlerimViewHolder(val binding : BiletItemRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): biletlerimViewHolder {
        val binding = BiletItemRowBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return biletlerimViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return biletListesi.size
    }
    fun lsiteyiGuncelle(yeniListe : List<bilet> ){
        biletListesi.clear()
        biletListesi.addAll(yeniListe)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: biletlerimViewHolder, position: Int) {
        var film : film
        var bilet : bilet
        var seans : seans
        var sinema : sinema
        var koltuk : koltuk
        var sinemasalonu : sinemasalonu

        //apiyle üsteki sınıfları bul

        /*
        holder.binding.sinemaad.text= sinema.isim
        holder.binding.filmadi.text = film.isim
        holder.binding.saat.text = "Saat:"+ seans.saat
        holder.binding.biletTurText.text = bilet.bilettur +"bilet"
        holder.binding.salon.text = "Salon:" + sinemasalonu.isim
        holder.binding.koltukno.text = "Koltuk:"+ koltuk.koltukno
         */
    }
}