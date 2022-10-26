package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this, R.array.unitName,R.layout.spinner_layout
        ).also { adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
             spinner.adapter = adapter
        }




    }
}
