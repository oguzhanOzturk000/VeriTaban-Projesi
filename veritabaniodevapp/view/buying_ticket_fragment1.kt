package com.example.veritabaniodevapp.view

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.sinemaAdapter
import com.example.veritabaniodevapp.databinding.FragmentBuyingTicketFragment1Binding
import com.example.veritabaniodevapp.model.sehir
import com.example.veritabaniodevapp.model.sinema


class buying_ticket_fragment1 : Fragment() {
    private var _binding : FragmentBuyingTicketFragment1Binding? = null
    private val binding get() = _binding!!
    private var adapterSinema = sinemaAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBuyingTicketFragment1Binding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.biletlerimBtn.setOnClickListener { val action = direction_bottomnavDirections.actionDirectionBottomnavToBiletlerim()
            Navigation.findNavController(view).navigate(action)
        }
        sehirTuslariAtama(view)
        sinemalariAl("tum")


        binding.sinemaRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.sinemaRecyclerView.adapter = adapterSinema
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun sinemalariAl(sehir: String){
        if(sehir == "tum"){
            val yeniListe = ArrayList<sinema>()

            //apiyle yenilisteye kaydet



            adapterSinema.lsiteyiGuncelle(yeniListe)
        }else if (sehir =="bursa"){
            val yeniListe = ArrayList<sinema>()

            //apiyle yenilisteye kaydet


            adapterSinema.lsiteyiGuncelle(yeniListe)
        }else if(sehir=="istanbul"){
            val yeniListe = ArrayList<sinema>()
            //apiyle yenilisteye kaydet



            adapterSinema.lsiteyiGuncelle(yeniListe)
        }else if(sehir=="sakarya"){
            val yeniListe = ArrayList<sinema>()
            //apiyle yenilisteye kaydet



            adapterSinema.lsiteyiGuncelle(yeniListe)
        }


    }
    fun sehirTuslariAtama(view: View){
        binding.tumutBtn.setOnClickListener { sinemalariAl("tum")}
        binding.bursaBtn.setOnClickListener { sinemalariAl("bursa")}
        binding.istBtn.setOnClickListener { sinemalariAl("istanbul")}
        binding.sakaryaBtn.setOnClickListener { sinemalariAl("sakarya") }
    }


}