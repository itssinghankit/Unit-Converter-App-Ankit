package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlin.math.roundToInt
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number:Double             //operations is done on it
        val button=findViewById<Button>(R.id.button)
        var from:Double=0.0
        var to:Double=0.0
        val output=findViewById<TextView>(R.id.unit2)
        var spinner1unit:String="Currency"   //because in starting no value is selected also null logic exists
        var spinner2unit:String="INR"
        var spinner3unit:String="INR"

//it join array adapter to spinner1 in starting
        val spinner1: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this, R.array.unitName,R.layout.spinner_layout
        ).also { adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
             spinner1.adapter = adapter
        }

//it join array adapter to spinner2
        val spinner2:Spinner=findViewById(R.id.spinner2)

        ArrayAdapter.createFromResource(this,R.array.currency,R.layout.spinner_layout).also{
            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
            spinner2.adapter=adapter
        }

//it join array adapter to spinner3
        val spinner3:Spinner=findViewById(R.id.spinner3)

        ArrayAdapter.createFromResource(this,R.array.currency,R.layout.spinner_layout2).also{
            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
            spinner3.adapter=adapter
        }
                /***************************************************************/

//it runs when item selected in spinner1 and after selection required units will be displayed in spinner2 and spinner3

        spinner1.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinner1unit= p0?.getItemAtPosition(p2).toString()

                if(spinner1unit=="Currency"){
                    val spinner2:Spinner=findViewById(R.id.spinner2)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.currency,R.layout.spinner_layout).also{
                            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                        spinner2.adapter=adapter
                    }


                    val spinner3:Spinner=findViewById(R.id.spinner3)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.currency,R.layout.spinner_layout2).also{
                            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                        spinner3.adapter=adapter
                    }
                }

                if(spinner1unit=="Temperature"){
                    val spinner2:Spinner=findViewById(R.id.spinner2)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.temp,R.layout.spinner_layout).also{
                            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                        spinner2.adapter=adapter
                    }


                    val spinner3:Spinner=findViewById(R.id.spinner3)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.temp,R.layout.spinner_layout2).also{
                            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                        spinner3.adapter=adapter
                    }
                }

                else if(spinner1unit=="Length"){
                    val spinner2:Spinner=findViewById(R.id.spinner2)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.length,R.layout.spinner_layout).also{
                            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                        spinner2.adapter=adapter
                    }


                    val spinner3:Spinner=findViewById(R.id.spinner3)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.length,R.layout.spinner_layout2).also{
                            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                        spinner3.adapter=adapter
                    }
                }
                else if(spinner1unit=="Weight"){
                    val spinner2:Spinner=findViewById(R.id.spinner2)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.weight,R.layout.spinner_layout).also{
                            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                        spinner2.adapter=adapter
                    }


                    val spinner3:Spinner=findViewById(R.id.spinner3)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.weight,R.layout.spinner_layout2).also{
                            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                        spinner3.adapter=adapter
                    }
                }
                else if(spinner1unit=="Time"){
                    val spinner2:Spinner=findViewById(R.id.spinner2)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.time,R.layout.spinner_layout).also{
                            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                        spinner2.adapter=adapter
                    }


                    val spinner3:Spinner=findViewById(R.id.spinner3)

                    ArrayAdapter.createFromResource(this@MainActivity,R.array.time,R.layout.spinner_layout2).also{
                            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                        spinner3.adapter=adapter
                    }
                }
                                  /**************************************************/
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        spinner2.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinner2unit=p0?.getItemAtPosition(p2).toString()     //it give the selected item in string format initial type is any
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        spinner3.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinner3unit=p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        button.setOnClickListener(){
            val input:EditText=findViewById(R.id.unit1)
            when(spinner1unit){
                "Weight"->{
                    when(spinner2unit){
                        "kg"->from=1.0
                        "lb"->from=2.2
                        "g"->from=1000.0
                        "mg"->from=1000000.0
                    }
                    when(spinner3unit){
                        "kg"->to=1.0
                        "lb"->to=2.2
                        "g"->to=1000.0
                        "mg"->to=1000000.0
                    }
                }
                "Temperature"->{
                    when(spinner2unit){
                        "°C"->from=1.0
                        "°F"->from=33.8
                        "K"->from=273.15
                    }
                    when(spinner3unit){
                        "°C"->to=1.0
                        "°F"->to=33.8
                        "K"->to=273.15
                    }
                }

                "Currency"->{
                    when(spinner2unit){
                        "INR"->from=82.45
                        "USD"->from=1.0
                        "EUR"->from=1.0
                        "JPY"->from=146.69
                    }
                    when(spinner3unit){
                        "INR"->to=82.45
                        "USD"->to=1.0
                        "EUR"->to=1.0
                        "JPY"->to=146.69
                    }
                }
                "Length"->{
                    when(spinner2unit){
                        "km"->from=1.0
                        "m"->from=1000.0
                        "cm"->from=100000.0
                        "mm"->from=1000000.0
                    }
                    when(spinner3unit){
                        "km"->to=1.0
                        "m"->to=1000.0
                        "cm"->to=100000.0
                        "mm"->to=1000000.0
                    }
                }
                "Time"->{
                    when(spinner2unit){
                        "day"->from=1.0
                        "hour"->from=24.0
                        "min"->from=1000.0
                        "sec"->from=1000000.0
                    }
                    when(spinner3unit){
                        "day"->to=1.0
                        "hour"->to=24.0
                        "min"->to=1000.0
                        "sec"->to=1000000.0
                    }
                }
            }

//
            number= input.text.toString().toDouble()     //type of input.text is editabletext
            number=(number*to)/from
            output.text=number.toString()
        }




/*******************************/

    }
}
