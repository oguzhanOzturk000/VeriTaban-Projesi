package com.example.veritabaniodevapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.add_to_listAdapter
import com.example.veritabaniodevapp.databinding.FragmentAddToListBinding
import com.example.veritabaniodevapp.model.kayitliKullanici
import com.example.veritabaniodevapp.model.liste
import com.example.veritabaniodevapp.service.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class addToList : Fragment() {
    private var _binding : FragmentAddToListBinding? = null
    private val binding get() = _binding!!
    private var filmid: Int? =null
    private var adapter = add_to_listAdapter(arrayListOf(),filmid!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddToListBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            filmid = addToListArgs.fromBundle(it).filmid
        }

        binding.button.setOnClickListener { geriGit(view) }
        listeleriAl()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }
    fun geriGit(view: View){
        val action = addToListDirections.actionAddToListToMovieFragment(filmid!!)
        Navigation.findNavController(view).navigate(action)
    }
    fun listeleriAl(){
        val yeniListe = ArrayList<liste>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = try {
                apiService.listelerApi.listeleriAlSahip(kayitliKullanici.id!!)
            }catch (e : IOException){
                println(e.localizedMessage)
                binding.progressBar5.isVisible = false
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
            binding.progressBar5.isVisible = false
        }
        adapter.lsiteyiGuncelle(yeniListe)
    }


}