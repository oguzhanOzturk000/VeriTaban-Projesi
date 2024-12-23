package com.example.veritabaniodevapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.biletlerim_adapter
import com.example.veritabaniodevapp.databinding.FragmentBiletlerimBinding
import com.example.veritabaniodevapp.model.bilet

class biletlerim : Fragment() {

    private var _binding : FragmentBiletlerimBinding? = null
    private val binding get() = _binding!!
    private var adapter = biletlerim_adapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBiletlerimBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        biletleriAl()

        binding.button.setOnClickListener { gerigit(view) }
        binding.biletlerimRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.biletlerimRecyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding= null
    }
    fun biletleriAl(){
        val yeniListe = ArrayList<bilet>()

        adapter.lsiteyiGuncelle(yeniListe)

    }
    fun gerigit(view: View){
        val action = biletlerimDirections.actionBiletlerimToDirectionBottomnav(3)
        Navigation.findNavController(view).navigate(action)
    }

}