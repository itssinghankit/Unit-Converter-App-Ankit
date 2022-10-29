package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number:Double           //operations is done on it
        val button=findViewById<Button>(R.id.button)
        var from=0.0
        var to=0.0
        var input:EditText=findViewById(R.id.unit1)
        val output=findViewById<TextView>(R.id.unit2)
        var spinner1unit="Currency"   //because in starting no value is selected also null logic exists
        var spinner2unit="INR"
        var spinner3unit="INR"

//it join array adapter to spinner1 in starting
        val spinner1: Spinner = findViewById(R.id.spinner)

        ArrayAdapter.createFromResource(
            this, R.array.unitName,R.layout.spinner_layout
        ).also { adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
             spinner1.adapter = adapter
        }

//it join array adapter to spinner2
        var spinner2:Spinner=findViewById(R.id.spinner2)

        ArrayAdapter.createFromResource(this,R.array.currency,R.layout.spinner_layout).also{
            adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
            spinner2.adapter=adapter
        }

//it join array adapter to spinner3
        var spinner3:Spinner=findViewById(R.id.spinner3)

        ArrayAdapter.createFromResource(this,R.array.currency,R.layout.spinner_layout2).also{
            adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
            spinner3.adapter=adapter
        }
                /***************************************************************/

//it runs when item selected in spinner1 and after selection required units will be displayed in spinner2 and spinner3

        spinner1.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinner1unit= p0?.getItemAtPosition(p2).toString()
                output.text=input.text     //output and input get equal as both units are same

                spinner2=findViewById(R.id.spinner2)
                spinner3=findViewById(R.id.spinner3)

                when (spinner1unit) {
                    "Currency" -> {
                        spinner2=findViewById(R.id.spinner2)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.currency,R.layout.spinner_layout).also{ adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                            spinner2.adapter=adapter
                        }


                        spinner3=findViewById(R.id.spinner3)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.currency,R.layout.spinner_layout2).also{ adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                            spinner3.adapter=adapter
                        }
                    }
                    "Temperature" -> {
                        spinner2=findViewById(R.id.spinner2)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.temp,R.layout.spinner_layout).also{ adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                            spinner2.adapter=adapter
                        }


                        spinner3=findViewById(R.id.spinner3)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.temp,R.layout.spinner_layout2).also{ adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                            spinner3.adapter=adapter
                        }
                    }
                    "Length" -> {
                        spinner2=findViewById(R.id.spinner2)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.length,R.layout.spinner_layout).also{ adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                            spinner2.adapter=adapter
                        }


                        spinner3=findViewById(R.id.spinner3)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.length,R.layout.spinner_layout2).also{ adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                            spinner3.adapter=adapter
                        }
                    }
                    "Weight" -> {
                        spinner2=findViewById(R.id.spinner2)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.weight,R.layout.spinner_layout).also{ adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                            spinner2.adapter=adapter
                        }


                        spinner3=findViewById(R.id.spinner3)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.weight,R.layout.spinner_layout2).also{ adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                            spinner3.adapter=adapter
                        }
                    }
                    "Time" -> {
                        spinner2=findViewById(R.id.spinner2)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.time,R.layout.spinner_layout).also{ adapter -> adapter.setDropDownViewResource(R.layout.spinner_layout_dd)
                            spinner2.adapter=adapter
                        }


                        spinner3=findViewById(R.id.spinner3)

                        ArrayAdapter.createFromResource(this@MainActivity,R.array.time,R.layout.spinner_layout2).also{ adapter->adapter.setDropDownViewResource(R.layout.spinner_layout_dd2)
                            spinner3.adapter=adapter
                        }
                    }
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
                                    /******* After selection of units **********/

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

                         /*********** When button is clicked*********/
        button.setOnClickListener{

            input=findViewById(R.id.unit1)

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
                        "min"->from=1440.0
                        "sec"->from=86400.0
                    }
                    when(spinner3unit){
                        "day"->to=1.0
                        "hour"->to=24.0
                        "min"->to=1440.0
                        "sec"->to=86400.0
                    }
                }
            }

            if (spinner1unit=="Temperature"){
                number=input.text.toString().toDouble()
                if(spinner2unit=="°C" && spinner3unit=="K")
                {
                    number=(number+273.15)

                }
                else if(spinner2unit=="K" && spinner3unit=="°C")
                {
                    number=(number-273.15)
                }
                else if(spinner2unit=="°C" && spinner3unit=="°F")
                {
                    number=((number*9)/5+32)
                }
                else if(spinner2unit=="°F" && spinner3unit=="°C")
                {
                    number=((number-32)*5/9)
                }
                else if(spinner2unit=="°F" && spinner3unit=="K")
                {
                    number=((number+459.67)/1.8)
                }
                else if(spinner2unit=="K" && spinner3unit=="°F")
                {
                    number=((number*1.8)-459.67)
                }

                number=String.format("%.6f",number).toDouble()
                output.text=number.toString()


            }
            else{

            number= input.text.toString().toDouble() //type of input.text is editable text
            number=(number*to)/from
                number=String.format("%.6f",number).toDouble()  //to show precision value till n places and it will round of value
            output.text=number.toString()}
        }


    }
}
