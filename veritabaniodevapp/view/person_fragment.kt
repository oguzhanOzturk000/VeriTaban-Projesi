package com.example.veritabaniodevapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.kisi_filmAdapter
import com.example.veritabaniodevapp.adapter.main_page_movie_adapter
import com.example.veritabaniodevapp.databinding.FragmentPersonFragmentBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.filmsanatci
import com.example.veritabaniodevapp.model.sanatci
import com.example.veritabaniodevapp.service.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class person_fragment : Fragment() {

    private var _binding : FragmentPersonFragmentBinding? = null
    private val binding get() = _binding!!
    private var adapter = kisi_filmAdapter(arrayListOf())
    private var sanatciid : Int?= null
    private var kisi : sanatci? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPersonFragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            sanatciid = person_fragmentArgs.fromBundle(it).sanatciid
        }

        kisi = kisiyiBul(view)
        atamalar(view)
        kisininFilmleriniAl()


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun atamalar(view: View){
        binding.meslek.text = kisi!!.meslek
        binding.filmSayisi.text = "Film sayısı:"+kisi!!.filmsayisi
        binding.kisiad.text = kisi!!.sanatciad
        binding.hakkinda.text = kisi!!.hakkinda

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerView.adapter = adapter
        binding.geriBtn.setOnClickListener { gerigit(view)}
    }
    fun gerigit(view: View){
        val action = person_fragmentDirections.actionPersonFragment2ToDirectionBottomnav(2)
        Navigation.findNavController(view).navigate(action)
    }
    private fun kisiyiBul(view : View) : sanatci{
        binding.progressBar6.isVisible = true
        var kisi : sanatci? =null
        CoroutineScope(Dispatchers.IO).launch{

        }
        return kisi!!
    }
    fun kisininFilmleriniAl(){
        val yeniListe = ArrayList<filmsanatci>()

        binding.progressBar6.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {

        }
        adapter.lsiteyiGuncelle(yeniListe)
    }


}