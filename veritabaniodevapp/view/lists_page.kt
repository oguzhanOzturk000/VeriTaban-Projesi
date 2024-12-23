package com.example.veritabaniodevapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.list_page_movieadapter
import com.example.veritabaniodevapp.adapter.main_page_movie_adapter
import com.example.veritabaniodevapp.adapter.profile_page_adapter
import com.example.veritabaniodevapp.databinding.FragmentListsPageBinding
import com.example.veritabaniodevapp.model.film
import com.example.veritabaniodevapp.model.liste
import com.example.veritabaniodevapp.model.listefilm

class lists_page : Fragment() {
    private var _binding : FragmentListsPageBinding? = null
    private val binding get() = _binding!!
    private var adapter = list_page_movieadapter(arrayListOf())
    private var listeid : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListsPageBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            listeid = lists_pageArgs.fromBundle(it).listeid
        }
        binding.button.setOnClickListener { gerigit(view) }
        binding.deleteBtn.setOnClickListener { deletelist() }
        binding.editBtn.setOnClickListener { editlist() }
        listeyiAl()
        filmleriAl()
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    fun listeyiAl(){

    }
    fun filmleriAl(){
        val yeniListe = ArrayList<listefilm>()


        adapter.listeyiGuncelle(yeniListe)
    }
    fun editlist(){
        val builder = AlertDialog.Builder(requireContext())
        val dialogLayout = LayoutInflater.from(requireContext()).inflate(R.layout.edit_text_layout, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.et_EditText)
        val aciklamaText= dialogLayout.findViewById<EditText>(R.id.dc_EditText.div(1))
        with(builder){
            setTitle("Listeyi değiştirin")
            setPositiveButton("Uygula"){dialog, which ->
                val listeisim = editText.text.toString()
                val listeaciklama = aciklamaText.text.toString()
                if(listeisim.length > 15){
                    Toast.makeText(requireContext(),"Liste adi 15 karakterden uzun olamaz", Toast.LENGTH_SHORT).show()
                }else{
                    //api ile liste oluşturma



                    listeyiAl()
                }
            }
            setNegativeButton("İptal"){dialog, which ->

            }
            setView(dialogLayout).show()
        }

        filmleriAl()
    }
    fun deletelist(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Listeyi silmek istediğinize emin misiniz?")
            .setPositiveButton("Sil"){dialog,which->
                //sil


                val action = lists_pageDirections.actionListsPageToDirectionBottomnav()
                Navigation.findNavController(requireView()).navigate(action)
            }.setNegativeButton("İptal"){dialog,which->

            }.show()


    }
    fun gerigit(view: View){
        val action =  lists_pageDirections.actionListsPageToDirectionBottomnav(4)
        Navigation.findNavController(view).navigate(action)
    }

}