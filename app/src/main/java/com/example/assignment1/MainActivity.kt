package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.graphics.Color
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.ColorDrawable
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var score = 0
    var colorList = listOf(
        arrayOf("Black", Color.BLACK),
        arrayOf("Blue", Color.BLUE),
        arrayOf("Cyan", Color.CYAN),
        arrayOf("DarKGray", Color.DKGRAY),
        arrayOf("Gray", Color.GRAY),
        arrayOf("LightGray", Color.LTGRAY),
        arrayOf("Green", Color.GREEN),
        arrayOf("Yellow", Color.YELLOW),
        arrayOf("Red", Color.RED),
        arrayOf("Magenta", Color.MAGENTA)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initQuestion()
        setListeners()
    }

    private fun setListeners() {

        val left = findViewById<TextView>(R.id.left_box)
        val right = findViewById<TextView>(R.id.right_box)
        val clickableViews: List<View> = listOf(left, right)

        for (item in clickableViews) {
            item.setOnClickListener {
                onClick(it)
            }
        }
    }


    fun onClick(view: View) {
        val ans = colorList[0][1] as Int
        val color = (view.background as ColorDrawable).getColor()
        if (color == ans ) {
            score += 1
        } else {
            score -= 1
        }
        initQuestion()
    }
    fun initQuestion() {
        val left = findViewById<TextView>(R.id.left_box)
        val right = findViewById<TextView>(R.id.right_box)
        val label = findViewById<TextView>(R.id.target_color)
        val scoreText = findViewById<TextView>(R.id.score)

        colorList = colorList.shuffled()
        var q = listOf(colorList[0], colorList[1]).shuffled()
        left.setBackgroundColor(q[0][1] as Int)
        right.setBackgroundColor(q[1][1] as Int)

        label.text = colorList[0][0] as String
        scoreText.text = score.toString()

    }

}