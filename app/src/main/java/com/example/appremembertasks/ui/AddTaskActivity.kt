package com.example.appremembertasks.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appremembertasks.databinding.ActivityAddTaskBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*
import com.example.appremembertasks.extensions.format
import com.example.appremembertasks.extensions.text

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.date.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()

            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                binding.date.text = Date(it + offset).format()
            }

            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }
    }
}