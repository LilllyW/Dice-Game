package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val arrImg = listOf(R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6)
    val listCompare = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //scrolling
        lvResult.setHasFixedSize(true)

        //recyclerview adapter layout show as list
        lvResult.layoutManager = LinearLayoutManager(this)
        lvResult.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    fun clickCompare(sender: View) {
        var dice:ImageView
        if(sender is ImageView) { //click image
            dice = sender
        } else {                  //click button
            dice = if(sender == btn_dice1) dice1 else dice2
        }
        //val dice = if(sender is ImageView) sender else if(sender == btn_dice1) dice1 else dice2

        //random
        val num = Random().nextInt(6)
        dice.setImageResource(arrImg[num])
        dice.tag = num + 1

        val num1 = dice1.tag.toString().toInt()
        val num2 = dice2.tag.toString().toInt()

        //show & compare
        listCompare.add(0,"$num1 ${if(num1 > num2)">" else if(num1 < num2)"<" else "="} $num2")

        lvResult.adapter = ListAdapter(listCompare) //recyclerview adapter
    }
}
