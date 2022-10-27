package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner1: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this, R.array.unitName,R.layout.spinner_layout
        ).also { adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
             spinner1.adapter = adapter
        }

        val spinner2:Spinner=findViewById(R.id.spinner2)

        ArrayAdapter.createFromResource(this,R.array.length,R.layout.spinner_layout).also{
            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
            spinner2.adapter=adapter
        }


        val spinner3:Spinner=findViewById(R.id.spinner3)

        ArrayAdapter.createFromResource(this,R.array.length,R.layout.spinner_layout2).also{
            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
            spinner3.adapter=adapter
        }


    }
}
