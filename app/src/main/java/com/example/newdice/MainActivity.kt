package com.example.newdice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
    }

    //this function allows users to roll the dice and update the screen with the result
    private fun rollDice() {
//    create new dice with 6 sides and roll it
        val dice = Dice(6)
        //    update screen with dice roll
        val diceImage: ImageView = findViewById(R.id.imageView2)
        diceImage.setImageResource(R.drawable.dice_2)

            }
}

class Dice(val numSides: Int) {
    //   if numSides was a private val, it would only be accessible in the dice class
    fun smollRoll(): Int {
        return (1..numSides).random()
    }
}