package com.example.odevproje.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.odevproje.R
import com.example.odevproje.databinding.FragmentOlusturBinding
import com.example.odevproje.model.gonderilecekListe
import com.example.odevproje.service.apiServis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class olustur : Fragment() {
    private var _binding : FragmentOlusturBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOlusturBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener { listeOlustur(view) }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun listeOlustur(view:View){

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val liste = gonderilecekListe(binding.baslik.text.toString(), 0,binding.aciklama.text.toString(), 0.0,1,"24/12/2024")
                apiServis.listelerApi.makeList(liste)
                withContext(Dispatchers.Main){
                    Toast.makeText(context,"Liste oluşturuldu", Toast.LENGTH_SHORT).show()
                    val action = olusturDirections.actionOlusturToFeedFragment()
                    Navigation.findNavController(view).navigate(action)
                }
            }catch (e: Exception) {
                e.printStackTrace()
            }

        }



    }
}