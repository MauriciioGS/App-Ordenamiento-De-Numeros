package com.lira_navarro.examenfinal_ordenamiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lira_navarro.examenfinal_ordenamiento.adapter.NumsAdapter
import lira_navarro.examenfinal_ordenamiento.R
import lira_navarro.examenfinal_ordenamiento.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listaNums = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initElements()
    }

    private fun initElements() {
        binding.etInput.addTextChangedListener( object : TextWatcher {

            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun afterTextChanged(editable: Editable) {
                val currentNum = editable.toString()
                if (currentNum.length > 5){
                    binding.tlInputLayout.error = getString(R.string.helper_text)
                }else
                    binding.tlInputLayout.error = null
            }
        })

        binding.tlInputLayout.setEndIconOnClickListener {
            val num = binding.tlInputLayout.editText?.text.toString()
            if (num != ""){
                listaNums.add(num.toInt())
                binding.tlInputLayout.editText?.text?.clear()
                initRecyclerView()
            }
        }

        binding.btnOrdenamiento1.setOnClickListener {
            if (listaNums.isEmpty()){
                Toast.makeText(baseContext, getString(R.string.alert_empty), Toast.LENGTH_SHORT).show()
            }else{
                binding.frameLayout2.visibility = View.VISIBLE
                binding.tvResultado.text = getString(R.string.menor_mayor)
                binding.tvResultado.visibility = View.VISIBLE
                ordenamiento(1)
            }
        }

        binding.btnOrdenamiento2.setOnClickListener {
            if (listaNums.isEmpty()){
                Toast.makeText(baseContext, getString(R.string.alert_empty), Toast.LENGTH_SHORT).show()
            }else{
                binding.frameLayout2.visibility = View.VISIBLE
                binding.tvResultado.text = getString(R.string.mayor_menor)
                binding.tvResultado.visibility = View.VISIBLE
                ordenamiento(2)
            }
        }
    }

    private fun ordenamiento(tipo: Int) {
        when(tipo){
            1 -> { // Menor a mayor
                val listaOrdenada = listaNums.sorted()
                initRecyclerViewSorted(listaOrdenada.toCollection(ArrayList<Int>()))
            }
            2 -> { // Mayor a menor
                val listaOrdenada = listaNums.sortedDescending()
                initRecyclerViewSorted(listaOrdenada.toCollection(ArrayList<Int>()))
            }
        }
    }

    private fun initRecyclerView(){
        binding.tvIngresados.visibility = View.VISIBLE
        val recyclerView = binding.recyclerNumeros
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NumsAdapter(listaNums)
    }

    private fun initRecyclerViewSorted(lista : ArrayList<Int>){
        val recyclerView = binding.recyclerNumerosOrd
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NumsAdapter(lista)
    }

}