package com.example.veritabaniodevapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.databinding.FragmentLoginFragmentBinding
import com.example.veritabaniodevapp.model.kayitliKullanici
import com.example.veritabaniodevapp.model.kullanici
import com.example.veritabaniodevapp.service.apiService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class login_fragment : Fragment() {
    private var _binding : FragmentLoginFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginFragmentBinding.inflate(inflater , container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.girisBtn.setOnClickListener { girisYap(view) }
        binding.kayTolBtn.setOnClickListener { kayitol(view) }
        val guncelKullanici = auth.currentUser
        if(guncelKullanici!= null){
            kayitliKullanici.kullaniciad = auth.currentUser!!.email
            kayitliKullanici.mail = auth.currentUser!!.email

            // apiyle kullaniciyi memory e kaydet

            val action = login_fragmentDirections.actionLoginFragmentToDirectionBottomnav(1)
            Navigation.findNavController(view).navigate(action)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun girisYap(view: View){
        val mail = binding.mailTextView.text.toString()
        val password = binding.sifreTextView.text.toString()
        if (!mail.isNullOrBlank() && !password.isNullOrBlank()){
            auth.signInWithEmailAndPassword(mail , password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        kayitliKullanici.mail = mail
                        kayitliKullanici.kullaniciad = mail

                        //apide kayıtlı kullanicinin bilgileri alinir


                        Toast.makeText(context,"Giriş başarılı!" , Toast.LENGTH_SHORT).show()
                        val action = login_fragmentDirections.actionLoginFragmentToDirectionBottomnav()
                        Navigation.findNavController(view).navigate(action)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context,it.localizedMessage , Toast.LENGTH_SHORT).show()
                }
        }else{
            Toast.makeText(context,"Mail ve şifre giriniz" , Toast.LENGTH_SHORT).show()
        }


    }

    fun kayitol(view: View){
        val mail = binding.mailTextView.text.toString()
        val password = binding.sifreTextView.text.toString()
        if(!mail.isNullOrBlank() && !password.isNullOrBlank() ){
            auth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener{
                    if(it.isSuccessful){
                        kayitliKullanici.mail = mail
                        kayitliKullanici.kullaniciad = mail
                        kayitliKullanici.listeSayisi = 0
                        kayitliKullanici.izlenenFilmSayisi = 0

                        //postgrese kaydedilecek
                        val yeniKullanici = kullanici(null,auth.currentUser!!.email,auth.currentUser!!.email ,0,0 )

                        /*CoroutineScope(Dispatchers.IO).launch{
                            try{
                                apiService.kullanicilarApi.kullaniciYarat(yeniKullanici)
                            }catch (e: Exception) {
                                e.printStackTrace()
                            }

                        }

                         */


                        Toast.makeText(context,"Kayıt başarılı!" , Toast.LENGTH_SHORT).show()
                        val action = login_fragmentDirections.actionLoginFragmentToDirectionBottomnav(1)
                        Navigation.findNavController(view).navigate(action)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context,it.localizedMessage , Toast.LENGTH_SHORT).show()
                }
        }else{
            Toast.makeText(context,"Mail ve şifre giriniz" , Toast.LENGTH_SHORT).show()
        }


    }

}