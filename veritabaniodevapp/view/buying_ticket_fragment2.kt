package com.example.veritabaniodevapp.view

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veritabaniodevapp.R
import com.example.veritabaniodevapp.adapter.vizyonAdapter
import com.example.veritabaniodevapp.databinding.FragmentBuyingTicketFragment2Binding
import com.example.veritabaniodevapp.model.seans
import java.text.SimpleDateFormat
import java.util.Locale


class buying_ticket_fragment2 : Fragment() {

    private var _binding : FragmentBuyingTicketFragment2Binding? = null
    private val binding get() = _binding!!
    private val calender = Calendar.getInstance()
    private var sinema_id : Int? = null
    private var adapter = vizyonAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBuyingTicketFragment2Binding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            sinema_id = buying_ticket_fragment2Args.fromBundle(it).sinemaid
        }

        binding.tarihBtn.setOnClickListener { secimGoster(view) }
        binding.button.setOnClickListener { gerigit(view) }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    fun secimGoster(view: View){
        val tarihSecici = DatePickerDialog(requireContext(),{ DatePicker, year : Int, monthOfYear : Int, dayOfMonth: Int->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year,monthOfYear,dayOfMonth)
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val formattedDate = dateFormat.format(selectedDate.time)
            binding.tarihGoster.text ="Seçilen Tarih:"+formattedDate

            tariheGoreAl(formattedDate)

        },calender.get(Calendar.YEAR),calender.get(Calendar.MONTH),calender.get(Calendar.DAY_OF_MONTH))
        tarihSecici.show()

    }
    fun gerigit(view: View){
        val action = buying_ticket_fragment2Directions.actionBuyingTicketFragment2ToDirectionBottomnav(3)
        Navigation.findNavController(view).navigate(action)
    }
    fun tariheGoreAl(tarih: String){
        val yeniListe = ArrayList<seans>()


        //Tarihteki seanslai apiyle al


        adapter.lsiteyiGuncelle(yeniListe)
    }


}