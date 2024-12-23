package com.example.veritabaniodevapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.actor_director_adapter
import com.example.veritabaniodevapp.databinding.FragmentActorDirectorFragmentBinding
import com.example.veritabaniodevapp.databinding.FragmentProfilePageBinding
import com.example.veritabaniodevapp.model.sanatci
import com.example.veritabaniodevapp.service.apiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class actor_director_fragment : Fragment(), PopupMenu.OnMenuItemClickListener{
    private var _binding : FragmentActorDirectorFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var popup : PopupMenu
    private var adapter = actor_director_adapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActorDirectorFragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        atama(view)
        //sanatcilerial()

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    fun atama(view: View){
        popup = PopupMenu(requireContext(),binding.filterButton)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.meslek_sanatci_menu, popup.menu)
        binding.filterButton.setOnClickListener { filtrele() }


        binding.seachbtn.setOnClickListener { ismeGoreSanatci(binding.searchEditText.text.toString()) }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }
    fun filtrele(){
        popup.show()
        popup.setOnMenuItemClickListener (this)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if(item!!.itemId == R.id.sanatcitumu){
            sanatcilerial()
        }else if(item!!.itemId == R.id.aktor ){
            meslegeGoreSanatcileriAl("aktor")
        }else if(item!!.itemId == R.id.yonetmen){
            meslegeGoreSanatcileriAl("yonetmen")
        }
        return true
    }
    private fun sanatcilerial(){
        val yeniListe = ArrayList<sanatci>()
        binding.progressBar2.isVisible = true
        /*CoroutineScope(Dispatchers.IO).launch {
            val sonuc = try {
                apiService.sanatciApi.tumSanatcilariAl()
            }catch (e: IOException){
                binding.directorsActors.text = "0"
                return@launch
            }
            yeniListe.addAll(sonuc)
        }

         */
        binding.progressBar2.isVisible = true
        adapter.lsiteyiGuncelle(yeniListe)
    }
    private fun ismeGoreSanatci(isim :String){
        var yeniListe = ArrayList<sanatci>()
        //isme gore sanatci ara api


        adapter.lsiteyiGuncelle(yeniListe)
    }

    private fun meslegeGoreSanatcileriAl(meslek : String){
        binding.searchEditText.setText("")
        val yeniListe = ArrayList<sanatci>()

        binding.progressBar2.isVisible = true

        adapter.lsiteyiGuncelle(yeniListe)
    }

}