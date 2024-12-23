package com.example.veritabaniodevapp.view

import android.os.Build
import android.os.Bundle
import android.text.Layout.Directions
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.databinding.FragmentMovieFragmentBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.film_tur
import com.example.veritabaniodevapp.model.filmsanatci
import com.example.veritabaniodevapp.model.kayitliKullanici
import com.example.veritabaniodevapp.model.puanlama
import com.example.veritabaniodevapp.model.sanatci
import com.example.veritabaniodevapp.service.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


class movie_fragment : Fragment() , PopupMenu.OnMenuItemClickListener{
    private var _bindig : FragmentMovieFragmentBinding? = null
    private val binding get() = _bindig!!
    private lateinit var popup : PopupMenu
    private var filmidd : Int? = null
    private var film : film? =null
    private var puanVerili : Boolean = false
    private var puanlamaId : Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindig = FragmentMovieFragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            filmidd = movie_fragmentArgs.fromBundle(it).filmid
        }
        tuslariAta(view)
        puanVerili = false
        binding.verilenPuan.text = ""
        puanlamaGetir()
        if (!binding.verilenPuan.text.isNullOrBlank()){ puanVerili = true }
        filmiCek(view)
        sanatciListeyiCek(view)
        filmturgetir(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindig = null
    }

    private fun tuslariAta(view: View){
        binding.button.setOnClickListener { gerigit(view) }
        popup= PopupMenu(requireContext(),binding.rateButton)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.puan_ver_menu,popup.menu)
        binding.rateButton.setOnClickListener { rate(view)}
        binding.commentBtn.setOnClickListener {
            val action = movie_fragmentDirections.actionMovieFragmentToCommentfragment(filmidd!!)
            Navigation.findNavController(view).navigate(action)
        }
        binding.addToListbutton.setOnClickListener {
            val action = movie_fragmentDirections.actionMovieFragmentToAddToList(filmidd!!)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun rate(view: View){
        popup.show()
        popup.setOnMenuItemClickListener(this)
    }

    private fun filmturgetir(view: View){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.filmturuApi.filmTurBul(filmidd!!)
                withContext(Dispatchers.Main){
                    response.forEach {
                        binding.tur.text = binding.tur.text.toString().uppercase() + it.tur + ","
                    }
                }
            }catch (e: Exception) {
                e.printStackTrace() // Hataları görmek için
            }
        }
    }
    private fun sanatciListeyiCek(view: View){
        var sanatcilarListesi = ArrayList<sanatci>()
        CoroutineScope(Dispatchers.IO).launch{
            try{
                val response = apiService.filmsanatcilarApi.filmdekiSanatcileriAl(filmidd!!)
                response.forEach {
                    val sanatci = apiService.sanatcilarApi.sanatciBulId(it.sanatciid)
                    sanatcilarListesi.add(sanatci)
                }
                withContext(Dispatchers.Main){
                    sanatcilarListesi.forEach {
                        if(it.meslek == "yonetmen"){
                            binding.yonetmenler.append(it.sanatciad +",")
                        }else{
                            binding.aktorler.append(it.sanatciad+",")
                        }
                    }
                }
            }catch (e: Exception) {
                e.printStackTrace() // Hataları görmek için
            }
        }
    }

    private fun filmiCek(view: View){
        CoroutineScope(Dispatchers.IO).launch{
            try {
                val response = apiService.filmsApi.getFilmById(filmidd!!)
                withContext(Dispatchers.Main){
                    binding.filmad.text = response.isim
                    binding.description.text = response.konu
                    binding.rating.text = response.ortalama_puan.toString()
                    binding.filmuzunuk.text = response.uzunluk.toString() +"dk"
                    Glide.with(view)
                        .load(response.poster_uri)
                        .fitCenter()
                        .into(binding.imageView)
                }
            }catch (e: Exception) {
                e.printStackTrace() // Hataları görmek için
            }
        }
    }

    fun gerigit(view: View){
        val action= movie_fragmentDirections.actionMovieFragmentToDirectionBottomnav(1)
        Navigation.findNavController(view).navigate(action)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if(item!!.itemId==R.id.bir){
            //filme 1 puan verildi
            filmePuanVerildi(1)
        }else if(item!!.itemId==R.id.iki){
            //filme 2 puan verildi
            filmePuanVerildi(2)
        }else if(item!!.itemId==R.id.uc){
            //filme 3 puan verildi
            filmePuanVerildi(3)
        }else if(item!!.itemId==R.id.dort){
            binding.filmad.text = "aaaaaaaaaaaaaa"
            filmePuanVerildi(4)
        }else if(item!!.itemId==R.id.bes){
            //filme 5 puan verildi
            filmePuanVerildi(5)
        }else if(item!!.itemId==R.id.puaniptal){
            //puan geri çekildi
            puangericekildi()
        }
        return true
    }

    private fun puanlamaGetir(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val cevap = apiService.puanlamalarApi.kullanicIdilepuanlamaAl(kayitliKullanici.id!!)
                cevap.forEach {
                    if(it.filmid == filmidd){
                        puanlamaId = it.id!!
                        binding.verilenPuan.text = it.puan.toString()
                    }
                }
            }catch (e: Exception) {
                e.printStackTrace() // Hataları görmek için
            }
        }
    }
    fun filmePuanVerildi(puan : Int){

        if(puanVerili){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val yenipuanlama = puanlama(null,filmidd!!,kayitliKullanici.id!!,puan,"")
                    apiService.puanlamalarApi.puaniDegistir(
                        object{
                            val id = null
                            var filmid = filmidd!!
                            var kullaniciid = kayitliKullanici.id
                            var puan = puan
                            var puanlamatarih ="" }
                    )
                }catch (e: Exception) {
                    e.printStackTrace() // Hataları görmek için
                }
            }
        }else{
            //puanlama eklenecek
            CoroutineScope(Dispatchers.IO).launch {
                try {
                        apiService.puanlamalarApi.yeniPuanlama(
                            object{
                                val id = null
                                var filmid = filmidd!!
                                var kullaniciid = kayitliKullanici.id
                                var puan = puan
                                var puanlamatarih =""
                            }
                        )
                    withContext(Dispatchers.Main){
                        binding.filmad.text = "aaaaaaaaaaaaaa"
                        binding.verilenPuan.text = puan.toString()
                    }
                }catch (e: Exception) {
                    e.printStackTrace() // Hataları görmek için
                }
            }
        }
        binding.verilenPuan.text = puan.toString()
    }
    fun puangericekildi(){

        if(puanVerili){
            CoroutineScope(Dispatchers.Main).launch {
                try {
                    apiService.puanlamalarApi.puanlamayiSil(puanlamaId)
                }catch (e: Exception) {
                    e.printStackTrace() // Hataları görmek için
                }
            }
        }else{
        }
        binding.verilenPuan.text = ""
    }


}


