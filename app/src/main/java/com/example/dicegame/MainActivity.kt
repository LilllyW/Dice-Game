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
        //lvResult.isNestedScrollingEnabled = false
        lvResult.setHasFixedSize(true)

        lvResult.layoutManager = LinearLayoutManager(this) //recyclerview adapter layout show
        lvResult.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
//
//        btn_dice1.setOnClickListener{
////            val num = Random().nextInt(6)
////            dice1.setImageResource(arrImg[num])
////            dice1.tag = num + 1
//            compare(dice1)
//        }
//
//        btn_dice2.setOnClickListener{
////            val num = Random().nextInt(6)
////            dice2.setImageResource(arrImg[num])
////            dice2.tag = num + 1
//            compare(dice2)
//        }
    }

    fun clickCompare(sender: View) { //onClick
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

        //lvResult.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listCompare) -> use when listview arrayadapter
        lvResult.adapter = ListAdapter(listCompare) //recyclerview adapter
    }
}
