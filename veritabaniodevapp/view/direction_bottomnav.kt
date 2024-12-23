package com.example.veritabaniodevapp.view

import android.app.FragmentManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.databinding.FragmentDirectionBottomnavBinding


class direction_bottomnav : Fragment() {
    private var _binding: FragmentDirectionBottomnavBinding? = null
    private val binding get()= _binding!!
    private var seciliSayfa : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDirectionBottomnavBinding.inflate(inflater,container,false)
        val view =binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{
            seciliSayfa = direction_bottomnavArgs.fromBundle(it).gecilecekEkran
        }
        if(seciliSayfa == 2){
                replaceFragment(actor_director_fragment())
        }else if(seciliSayfa == 3){
                replaceFragment(buying_ticket_fragment1())
        }else if(seciliSayfa == 4){
                replaceFragment(profile_page())
        }else {
            replaceFragment(main_page())
        }


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.filmler -> replaceFragment(main_page())
                R.id.kisiler -> replaceFragment(actor_director_fragment())
                R.id.profil -> replaceFragment(profile_page())
                R.id.bilet -> replaceFragment(buying_ticket_fragment1())

                else ->{

                }
            }
            true
        }
    }



    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = childFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}