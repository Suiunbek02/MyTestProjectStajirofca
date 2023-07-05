package com.example.mynewtestproject.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.mynewtestproject.R

import com.example.mynewtestproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private val list: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayAdapter = ArrayAdapter(
            this,
            R.layout.item_test,
            list
        )

        with(binding) {
            lv.adapter = arrayAdapter
            btn.setOnClickListener {
                list.add(et.text.trim().toString())
                et.text.clear()
                arrayAdapter.notifyDataSetChanged()
            }

            lv.apply {
             setOnItemClickListener { _, _, id, _ ->
                 et.setText(list[id])
                 list.removeAt(id)
             }
                setOnItemLongClickListener { _, _, id, _ ->
                    list.removeAt(id)
                    arrayAdapter.notifyDataSetChanged()
                    return@setOnItemLongClickListener true
                }
            }
        }
    }
}

