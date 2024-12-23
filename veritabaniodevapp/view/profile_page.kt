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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.R.*
import com.example.veritabaniodevapp.adapter.profile_page_adapter
import com.example.veritabaniodevapp.databinding.FragmentProfilePageBinding
import com.example.veritabaniodevapp.model.kayitliKullanici
import com.example.veritabaniodevapp.model.liste
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class profile_page : Fragment() {
    private var _binding : FragmentProfilePageBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth : FirebaseAuth
    private var adapter = profile_page_adapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfilePageBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.logOutButton.setOnClickListener { logout(view) }
        binding.userName.text = kayitliKullanici.mail
        binding.listCount.text = "Liste sayısı:" +kayitliKullanici.listeSayisi
        binding.movieCount.text = "İzlenen film sayisi:" + kayitliKullanici.izlenenFilmSayisi
        binding.addListButton.setOnClickListener { createList(view) }

        verileriAl()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun logout(view: View){
        auth.signOut()
        kayitliKullanici.kullaniciad = null
        kayitliKullanici.mail = null
        kayitliKullanici.listeSayisi = null
        kayitliKullanici.izlenenFilmSayisi = null
        kayitliKullanici.id = null
        Toast.makeText(context,"Çıkış yapıldı" , Toast.LENGTH_SHORT).show()
        val action = direction_bottomnavDirections.actionDirectionBottomnavToLoginFragment()
        Navigation.findNavController(view).navigate(action)
    }
    fun verileriAl(){
        val yeniListe = ArrayList<liste>()



        adapter.listeyiGncelle(yeniListe)
    }
    fun createList(view: View){
        val builder = AlertDialog.Builder(requireContext())
        val dialogLayout = LayoutInflater.from(requireContext()).inflate(R.layout.edit_text_layout, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.et_EditText)
        val aciklamaText= dialogLayout.findViewById<EditText>(R.id.dc_EditText.div(1))
        with(builder){
            setTitle("Yeni liste oluşturun")
            setPositiveButton("Tamam"){dialog, which ->
                val listeisim = editText.text.toString()
                val listeaciklama = aciklamaText.text.toString()
                if(listeisim.length > 15){
                    Toast.makeText(requireContext(),"Liste adi 15 karakterden uzun olamaz", Toast.LENGTH_SHORT).show()
                }else{
                    //api ile liste oluşturma



                    verileriAl()
                }
            }
            setNegativeButton("İptal"){dialog, which ->

            }
            setView(dialogLayout).show()
        }

    }
}