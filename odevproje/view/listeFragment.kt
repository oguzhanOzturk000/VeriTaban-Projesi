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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odevproje.R
import com.example.odevproje.adapter.listeAdapter
import com.example.odevproje.databinding.FragmentListeBinding
import com.example.odevproje.model.liste
import com.example.odevproje.model.listefilm
import com.example.odevproje.service.apiServis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class listeFragment : Fragment() {
    private var _binding : FragmentListeBinding? = null
    private val binding get() = _binding!!
    private var listeId :Int? = null
    private val listeid get() = listeId!!
    private var adapter = listeAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListeBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            listeId = listeFragmentArgs.fromBundle(it).listeid
        }
        atamalar(view)
        verilericagir(view)

    }
    fun atamalar(view: View){
        binding.edit.setOnClickListener { editeTiklandi(view) }
        binding.sil.setOnClickListener { sileTiklandi(view) }
        binding.geriBtn.setOnClickListener {
            val action = listeFragmentDirections.actionListeFragmentToFeedFragment()
            Navigation.findNavController(view).navigate(action)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun verilericagir(view : View){
        binding.progressBar2.isVisible=true
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val sonuc = apiServis.listelerApi.findListById(listeId!!)
                withContext(Dispatchers.Main){
                    binding.baslik.text = sonuc.isim
                    binding.aciklama.text = sonuc.aciklama
                    binding.progressBar2.isVisible=false
                }
            }catch (e: Exception) {
                e.printStackTrace()
            }
            try {
                val sonuc = apiServis.listefilmsApi.listedeiFilmleriBul(listeid)
                withContext(Dispatchers.Main){
                    val yeniListe = ArrayList<listefilm>()
                    yeniListe.addAll(sonuc)
                    adapter.listeyiGuncelle(yeniListe)
                }
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }
    fun editeTiklandi(view: View){
        val builder = AlertDialog.Builder(requireContext())
        val dialogLayout = LayoutInflater.from(requireContext()).inflate(R.layout.edit_text_layout, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.et_EditText)
        val aciklamaText= dialogLayout.findViewById<EditText>(R.id.dc_EditText.div(1))
        with(builder){
            setTitle("Listeyi düzenleyin")
            setPositiveButton("Tamam"){dialog, which ->
                val listeisim = editText.text.toString()
                val listeaciklama = aciklamaText.text.toString()
                if(listeisim.length > 25 || listeisim.isNullOrBlank()){
                    Toast.makeText(requireContext(),"Liste adi 25 karakterden uzun ya da boş olamaz ", Toast.LENGTH_SHORT).show()
                }else{
                    //api ile liste editle
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val degisecekListe = apiServis.listelerApi.findListById(listeid)
                            val yeniListe = liste(degisecekListe.id,listeisim,degisecekListe.film_sayisi,listeaciklama,degisecekListe.ortalama_puan,degisecekListe.sahipid,degisecekListe.olusturulma_tarihi)
                            apiServis.listelerApi.editList(yeniListe , yeniListe.id!!)
                        }catch (e: Exception) {
                            e.printStackTrace()
                        }

                    }
                    binding.baslik.text = listeisim
                    binding.aciklama.text = listeaciklama
                    Toast.makeText(context,"Liste güncellendi", Toast.LENGTH_SHORT).show()
                }
            }
            setNegativeButton("İptal"){dialog, which ->

            }
            setView(dialogLayout).show()
        }
    }

    fun sileTiklandi(view: View){
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Listeyi silmek istediğinize emin misiniz?")
            .setPositiveButton("Sil"){dialog,which->
                //sil
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        apiServis.listelerApi.listeyiSil(listeid)
                    }catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                Toast.makeText(context,"Liste silindi" , Toast.LENGTH_SHORT).show()
                val action = listeFragmentDirections.actionListeFragmentToFeedFragment()
                Navigation.findNavController(view).navigate(action)
            }.setNegativeButton("İptal"){dialog,which->

            }.show()
    }
}