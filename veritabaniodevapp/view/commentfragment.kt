package com.example.veritabaniodevapp.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.yorumlar_adapter
import com.example.veritabaniodevapp.databinding.FragmentCommentfragmentBinding
import com.example.veritabaniodevapp.model.kayitliKullanici
import com.example.veritabaniodevapp.model.yorum
import com.example.veritabaniodevapp.service.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


class commentfragment : Fragment() {
    private var _binding : FragmentCommentfragmentBinding? = null
    private val binding get() = _binding!!
    private var filmid : Int? = null
    private var adapter = yorumlar_adapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommentfragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendCommentBtn.setOnClickListener { yorumyolla() }
        arguments?.let {
            filmid = commentfragmentArgs.fromBundle(it).filmid
        }
        verileriAl()

        binding.button.setOnClickListener { gerigit(view) }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }
    fun verileriAl(){
        val yeniListe = ArrayList<yorum>()

        CoroutineScope(Dispatchers.IO).launch {
            val response =try {
                apiService.yorumlarApi.yorumlarGetir(filmid!!)
            }catch (e : IOException){
                println(e.localizedMessage)
                binding.progressBar4.isVisible = false
                return@launch
            }catch(e : HttpException){
                println("Http exception")
                return@launch
            }
            if(response.isSuccessful && response.body() != null){
                yeniListe.addAll(response.body()!!)
            }else{
                println("Response not succesful")
            }
            binding.progressBar4.isVisible = false
        }
        adapter.lsiteyiGuncelle(yeniListe)
    }
    fun gerigit(view: View){
        val action = commentfragmentDirections.actionCommentfragmentToMovieFragment(filmid!!)
        Navigation.findNavController(view).navigate(action)
    }

    fun yorumyolla(){
        var yorum : yorum?= null
        yorum!!.filmid = filmid!!
        yorum!!.sahipid = kayitliKullanici.id!!
        yorum!!.yorum = binding.commentText.text.toString()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val date = ZonedDateTime.now()
            yorum!!.tarih = DateTimeFormatter.ofPattern("dd MM yyyy HH:mm").format(date)
        }
        //api işlemleri
        CoroutineScope(Dispatchers.IO).launch{
            binding.progressBar4.isVisible = true
            try {
                apiService.yorumlarApi.yorumYap(yorum)
            }catch (e : IOException){
                println(e.localizedMessage)
                binding.progressBar4.isVisible = false
                return@launch
            }catch(e : HttpException){
                println("Http exception")
                return@launch
            }
            binding.progressBar4.isVisible = false
        }
        Toast.makeText(this.context,"Yorum Yapıldı", Toast.LENGTH_SHORT).show()
        verileriAl()
    }
}