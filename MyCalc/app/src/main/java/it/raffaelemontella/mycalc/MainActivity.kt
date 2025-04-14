package it.raffaelemontella.mycalc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button9).setOnClickListener {
            val display = findViewById<TextView>(R.id.textDisplay)
            display.text = "9"
        }

        findViewById<Button>(R.id.buttonAC).setOnClickListener {
            val display = findViewById<TextView>(R.id.textDisplay)
            display.text = "0.0"
        }
    }
}