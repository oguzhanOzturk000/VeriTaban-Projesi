package com.example.veritabaniodevapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.main_page_movie_adapter
import com.example.veritabaniodevapp.databinding.FragmentMainPageBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.film_tur
import com.example.veritabaniodevapp.service.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class main_page : Fragment() , PopupMenu.OnMenuItemClickListener{
    private var _binding : FragmentMainPageBinding? = null
    private val binding get() = _binding!!
    private lateinit var popup: PopupMenu
    private var adapter = main_page_movie_adapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainPageBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tuslarAtama(view)
        tumFilmleriAl()


    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun tuslarAtama(view: View){
        //filtre butonunun atanması
        popup = PopupMenu(requireContext(),binding.filterButton)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.film_tur_menu, popup.menu)
        binding.filterButton.setOnClickListener { filter() }

        binding.searchBtn.setOnClickListener { ismeGoreFilm(binding.searchEditText.text.toString()) }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext() , 2)
        binding.recyclerView.adapter = adapter
    }
    fun filter(){
        popup.show()
        popup.setOnMenuItemClickListener(this)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.aksiyon){
            //aksyion filni seçilmiş
            tureGoreFilm("Aksiyon")
        }else if( item.itemId == R.id.macera){
            tureGoreFilm("Macera")
        }else if( item.itemId == R.id.dram){
            tureGoreFilm("Dram")
        }else if( item.itemId == R.id.komedi){
            tureGoreFilm("Komedi")
        }else if( item.itemId == R.id.bilimkurgu){
            tureGoreFilm("Bilimkurgu")
        }else if( item.itemId == R.id.animasyon){
            tureGoreFilm("Animasyon")
        }else if( item.itemId == R.id.tum){
            tumFilmleriAl()
        }

        return true
    }
    fun ismeGoreFilm(isim :String){
        val yeniListe = ArrayList<film>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val sonuc = apiService.filmsApi.getFilmsByisim(isim)
                withContext(Dispatchers.Main){
                    yeniListe.addAll(sonuc as Collection<film>)
                    adapter.lsiteyiGuncelle(yeniListe)
                }
            }catch (e: Exception) {
                e.printStackTrace() // Hataları görmek için
            }
        }

        adapter.lsiteyiGuncelle(yeniListe)
    }

    fun tureGoreFilm(tur:String){
        val yeniListe = ArrayList<film>()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Tür bazında film türlerini çek
                val turListesi = apiService.filmturuApi.filmturCekTureGore(tur) as List<film_tur>

                // Her film için ayrı API çağrısı yap
                turListesi.forEach {
                    if(it.tur==tur){
                        val filmSonuc = apiService.filmsApi.getFilmById(it.filmid)
                        yeniListe.add(filmSonuc)
                    }
                }
                // Adapter'i ana iş parçacığında güncelle
                withContext(Dispatchers.Main) {
                    adapter.lsiteyiGuncelle(yeniListe)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun tumFilmleriAl(){
        var yeniListe = ArrayList<film>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val sonuc = apiService.filmsApi.getAllFilms()
                withContext(Dispatchers.Main){
                    yeniListe.addAll(sonuc as Collection<film>)
                    adapter.lsiteyiGuncelle(yeniListe)
                }
            }catch (e: Exception) {
                e.printStackTrace() // Hataları görmek için
            }
        }
    }

//196.168.1.2
}