package com.example.latihanactivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var edtLength : EditText
    lateinit var edtWidth : EditText
    lateinit var edtHeight : EditText
    lateinit var btnCalculate : Button
    lateinit var tvResult : TextView

    companion object {
        const val state_result = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtLength = findViewById(R.id.edtLength)
        edtHeight = findViewById(R.id.edtHeight)
        edtWidth = findViewById(R.id.edtWidth)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResultCalculate)

        btnCalculate.setOnClickListener (this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(state_result)
            tvResult.text = result
        }
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btnCalculate) {
            val inputLength = edtLength.toString().trim()
            val inputWidth = edtWidth.toString().trim()
            val inputHeight = edtHeight.toString().trim()

            var isEmptyFields = false
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                edtLength.error = "Field ini tidak boleh kosong !!"
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtWidth.error = "Field ini tidak boleh kosong !!"
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edtHeight.error = "Field ini tidak boleh kosong !!"
            }

            if (!isEmptyFields) {
                val volume = inputLength.toDouble() + inputWidth.toDouble() + inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(state_result, tvResult.text.toString())
    }
}