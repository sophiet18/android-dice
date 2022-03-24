package com.example.androiddice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// the main activity class allows users to roll a dice and view the results
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }

        // Do a dice roll when app starts
        rollDice()
    }

    //this function allows users to roll the dice and update the screen with the result
    private fun rollDice() {
//    create new dice with 6 sides and roll it
        val smollDice = smallDice(3)
        val biggDice = bigDice()
        val smallDiceRoll = smollDice.roll()
        val bigDiceRoll = biggDice.bigRoll()
        // find the imageview in the layout aka the frame that holds the actual image and then codes in the when statements determine the actual image that goes inside
        val diceImage: ImageView = findViewById(R.id.imageView2)
        val diceImage2:ImageView = findViewById(R.id.imageView)
        //    update screen with dice roll
        val drawableResourceSmall = when (smallDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            else -> R.drawable.dice_3
            }
        val drawableResourceBig = when (bigDiceRoll){
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else-> R.drawable.dice_6

        }
        // update the image with the correct drawable resource ID
        diceImage.setImageResource(drawableResourceSmall)
        diceImage2.setImageResource(drawableResourceBig)
//        add content description so that screen readers can read results
        diceImage.contentDescription = smollDice.toString()
        diceImage2.contentDescription = biggDice.toString()

    }
}

class smallDice(val numSides: Int) {
    //   if numSides was a private val, it would only be accessible in the dice class
    fun roll(): Int {
        return (1..numSides).random()
    }
}

class bigDice (){
    val bigSides = listOf(4,5,6)
    fun bigRoll(): Int {
        return bigSides.random()
    }
}