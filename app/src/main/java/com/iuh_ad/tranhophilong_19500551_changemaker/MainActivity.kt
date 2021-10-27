package com.iuh_ad.tranhophilong_19500551_changemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.Int as Int1

class MainActivity : AppCompatActivity() {

    private lateinit var tx_20_dolar:TextView
    private lateinit var tx_price:TextView
    private lateinit var tx_10_dolar:TextView
    private lateinit var tx_5_dolar:TextView
    private lateinit var tx_1_dolar:TextView
    private lateinit var tx_25_cen:TextView
    private lateinit var tx_10_cen:TextView
    private lateinit var tx_5_cen:TextView
    private lateinit var tx_1_cen:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tx_20_dolar=findViewById(R.id.dolar_20)
        tx_price=findViewById(R.id.price)
        tx_10_dolar=findViewById(R.id.dolar_10)
        tx_5_dolar=findViewById(R.id.dolar_5)
        tx_1_dolar=findViewById(R.id.dolar_1)
        tx_25_cen=findViewById(R.id.cen_25)
        tx_10_cen=findViewById(R.id.cen_10)
        tx_5_cen=findViewById(R.id.cen_5)
        tx_1_cen=findViewById(R.id.cen_1)
        val btn_1 = findViewById<Button>(R.id.btn_1)
        val btn_clear = findViewById<Button>(R.id.btn_clear)
        val btn_2 = findViewById<Button>(R.id.btn_2)
        val btn_3 = findViewById<Button>(R.id.btn_3)
        val btn_4 = findViewById<Button>(R.id.btn_4)
        val btn_5 = findViewById<Button>(R.id.btn_5)
        val btn_6 = findViewById<Button>(R.id.btn_6)
        val btn_7 = findViewById<Button>(R.id.btn_7)
        val btn_8 = findViewById<Button>(R.id.btn_8)
        val btn_9 = findViewById<Button>(R.id.btn_9)
        val btn_0 = findViewById<Button>(R.id.btn_0)

       click(btn_1,getString(R.string._1))
        click(btn_2,getString(R.string._2))
        click(btn_3,getString(R.string._3))
        click(btn_4,getString(R.string._4))
        click(btn_5,getString(R.string._5))
        click(btn_6,getString(R.string._6))
        click(btn_7,getString(R.string._7))
        click(btn_8,getString(R.string._8))
        click(btn_9,getString(R.string._9))
        click(btn_0,getString(R.string._0))

        btn_clear.setOnClickListener {
            tx_price.setText(getResources().getString(R.string.p))
            tx_20_dolar.setText(getResources().getString(R.string._20))
            tx_10_dolar.setText(getResources().getString(R.string._10))
            tx_5_dolar.setText(getResources().getString(R.string._5dolar))
            tx_1_dolar.setText(getResources().getString(R.string._1dolar))
            tx_25_cen.setText(getResources().getString(R.string._25c))
            tx_10_cen.setText(getResources().getString(R.string._10c))
            tx_5_cen.setText(getResources().getString(R.string._5c))
            tx_1_cen.setText(getResources().getString(R.string._1c))
        }

    }
    fun click(btn:Button,value:String) {
        btn.setOnClickListener {
            setPrice(value)
            setChange()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("txprice",tx_price.text.toString())
        outState.putString("tx20dolar",tx_20_dolar.text.toString())
        outState.putString("tx10dolar",tx_10_dolar.text.toString())
        outState.putString("tx5dolar",tx_5_dolar.text.toString())
        outState.putString("tx1dolar",tx_1_dolar.text.toString())
        outState.putString("tx25cen",tx_25_cen.text.toString())
        outState.putString("tx10cen",tx_10_cen.text.toString())
        outState.putString("tx5cen",tx_5_cen.text.toString())
        outState.putString("tx1cen",tx_1_cen.text.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tx_price.text= savedInstanceState.getString("txprice")
        tx_20_dolar.text= savedInstanceState.getString("tx20dolar")
        tx_10_dolar.text= savedInstanceState.getString("tx10dolar")
        tx_5_dolar.text= savedInstanceState.getString("tx5dolar")
        tx_1_dolar.text= savedInstanceState.getString("tx1dolar")
        tx_25_cen.text= savedInstanceState.getString("tx25cen")
        tx_10_cen.text= savedInstanceState.getString("tx10cen")
        tx_5_cen.text= savedInstanceState.getString("tx5cen")
        tx_1_cen.text= savedInstanceState.getString("tx1cen")

    }

    fun removeDot(s1: String, char: Char): String {
        var result = ""
        for (c in s1) {
            if (c != char) {
                result += c
            }
        }
        return result
    }

    fun setPrice(value: String) {
        tx_price = findViewById(R.id.price)
        val n_price_present=tx_price.text.length
        if(n_price_present==12){
            val myToast = Toast.makeText(this, "So qua lon!", Toast.LENGTH_SHORT)
            // show the Toast
            myToast.show()
            return
        }

        tx_price.text = tx_price.text.toString() +value
//        val n_price = tx_price.text.length
        val num = tx_price.text
        if (num.length >= 3) {
            val dot_str = '.'
            val first_str = num.take(num.length - 2).toString()
            tx_price.text = removeDot(first_str, dot_str) + getString(R.string.dot) + num.takeLast(2)
        }
    }

    fun setChange() {
        tx_20_dolar = findViewById(R.id.dolar_20)
        tx_10_dolar = findViewById(R.id.dolar_10)
        tx_5_dolar = findViewById(R.id.dolar_5)
        tx_1_dolar=findViewById(R.id.dolar_1)
        tx_25_cen=findViewById(R.id.cen_25)
        tx_10_cen=findViewById(R.id.cen_10)
        tx_5_cen=findViewById(R.id.cen_5)
        tx_1_cen=findViewById(R.id.cen_1)

        val first_num :kotlin.Int
        val tx_price = findViewById<TextView>(R.id.price)
//        val n_price = tx_price.text.length
        val num = tx_price.text
        var firststr=num
        if (num.length>=3) {
            firststr = num.take(num.length - 3)
           val secondstr=num.takeLast(2)
            val secondnum=Integer.parseInt(secondstr.toString())
            val arrcen=change(secondnum,25,10,5,1)
            tx_25_cen.text=getString(R.string._25c)+arrcen[0].toString()
            tx_10_cen.text=getString(R.string._10c)+arrcen[1].toString()
            tx_5_cen.text=getString(R.string._5c)+arrcen[2].toString()
            tx_1_cen.text=getString(R.string._1c)+arrcen[3].toString()
        }

        first_num=Integer.parseInt(firststr.toString())
        val arrdolar=change(first_num,20,10,5,1)
        tx_20_dolar.text= getString(R.string._20)+arrdolar[0].toString()
        tx_10_dolar.text=getString(R.string._10)+arrdolar[1].toString()
        tx_5_dolar.text=getString(R.string._5dolar)+arrdolar[2].toString()
        tx_1_dolar.text=getString(R.string._1dolar)+arrdolar[3].toString()


    }

    fun change(firstnum:kotlin.Int, a:kotlin.Int, b:kotlin.Int, c:kotlin.Int, d:kotlin.Int):MutableList<kotlin.Int>{
        val nums = mutableListOf(a,b,c)
        val nums_div=mutableListOf(b,c,d)
        val ar: MutableList<Int1> = ArrayList()
        var temp=firstnum
        var i=0
        ar.add(temp/nums[i])
        while( i<=2){
            temp=temp%nums[i]
            ar.add(temp/nums_div[i])
            i++
        }
        return ar

    }




}





