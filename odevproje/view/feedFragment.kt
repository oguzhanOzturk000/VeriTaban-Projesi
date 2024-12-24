package com.example.odevproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.odevproje.R
import com.example.odevproje.adapter.feedAdapter
import com.example.odevproje.databinding.FragmentFeedBinding
import com.example.odevproje.databinding.FragmentListeBinding
import com.example.odevproje.model.gonderilecekListe
import com.example.odevproje.model.liste
import com.example.odevproje.service.apiServis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Objects


class feedFragment : Fragment() {
    private var _binding : FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private var adapter = feedAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener { listeAra(binding.editTextText.text.toString()) }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
        binding.floatingActionButton.setOnClickListener { listeYarat(view) }
        verileriAl(view)


    }
    private fun atamalar(view: View){


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun verileriAl(view: View){
        val yeniListe = ArrayList<liste>()
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val sonuc = apiServis.listelerApi.tumListeleriAl()
            if (sonuc.isSuccessful) {
                sonuc.body()?.let { body ->
                    yeniListe.addAll(body)
                    withContext(Dispatchers.Main) {
                        adapter.listeyiGuncelle(yeniListe)
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                withContext(Dispatchers.Main) {
                    // Hata durumunu göster
                }
            }
        }
    }
    fun listeAra(aranacakList:String){
        binding.progressBar.isVisible = true
        val yollanacak = ArrayList<liste>()
        if(!binding.editTextText.text.toString().isNullOrBlank()){
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val sonuc = apiServis.listelerApi.isimdenListeAra(aranacakList)
                    withContext(Dispatchers.Main) {
                        yollanacak.addAll(sonuc)
                        adapter.listeyiGuncelle(yollanacak)
                        binding.progressBar.isVisible = false
                    }
                }catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

    }
    fun listeYarat(view: View){
       val action = feedFragmentDirections.actionFeedFragmentToOlustur()
        Navigation.findNavController(view).navigate(action)
    }


}