package it.raffaelemontella.mycalc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var accumulator: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonAC).setOnClickListener { acListener() }
        findViewById<Button>(R.id.buttonSign).setOnClickListener { signListener() }

        findViewById<Button>(R.id.button9).setOnClickListener { digitListener("9")  }
        findViewById<Button>(R.id.button8).setOnClickListener { digitListener("8")  }
        findViewById<Button>(R.id.button7).setOnClickListener { digitListener("7")  }
        findViewById<Button>(R.id.button6).setOnClickListener { digitListener("6")  }
        findViewById<Button>(R.id.button5).setOnClickListener { digitListener("5")  }
        findViewById<Button>(R.id.button4).setOnClickListener { digitListener("4")  }
        findViewById<Button>(R.id.button3).setOnClickListener { digitListener("3")  }
        findViewById<Button>(R.id.button2).setOnClickListener { digitListener("2")  }
        findViewById<Button>(R.id.button1).setOnClickListener { digitListener("1")  }
        findViewById<Button>(R.id.button0).setOnClickListener { digitListener("0")  }

        findViewById<Button>(R.id.buttonDot).setOnClickListener { dotListener() }

        findViewById<Button>(R.id.buttonAdd).setOnClickListener { opListener("add") }
        findViewById<Button>(R.id.buttonMul).setOnClickListener { opListener("mul") }
        findViewById<Button>(R.id.buttonSub).setOnClickListener { opListener("sub") }
        findViewById<Button>(R.id.buttonDiv).setOnClickListener { opListener("div") }

        findViewById<Button>(R.id.buttonRes).setOnClickListener { resListener() }
    }

    private fun acListener() {
        val display = findViewById<TextView>(R.id.textDisplay)
        display.text="0.0"
        accumulator=0.0
        operator=""
    }

    private fun signListener() {
        val display = findViewById<TextView>(R.id.textDisplay)
        display.text=(display.text.toString().toFloat().toDouble()*-1).toString()
    }

    private fun digitListener(key: String) {
        val display = findViewById<TextView>(R.id.textDisplay)
        if (display.text.equals("0.0")) {
            display.text = key
        } else {
            display.text = display.text.toString() + key
        }
    }

    private fun dotListener() {
        val display = findViewById<TextView>(R.id.textDisplay)
        if (display.text.indexOf(".") == -1) {
            display.text = display.text.toString() + "."
        }
    }

    fun opListener(op: String) {



        val display = findViewById<TextView>(R.id.textDisplay)

        if (operator.equals("")) {

            accumulator = display.text.toString().toFloat().toDouble()
            display.text = "0.0"
        } else {

            val operand = display.text.toString().toFloat().toDouble()
            val res = when(op) {
                "add" -> accumulator + operand
                "sub" -> accumulator - operand
                "mul" -> accumulator * operand
                "div" -> accumulator / operand
                else -> Double.NaN
            }

            display.text = "0.0"

            accumulator = res
        }
        operator = op
    }

    private fun resListener() {
        val display = findViewById<TextView>(R.id.textDisplay)


        val operand = display.text.toString().toFloat().toDouble()
        val res = when(operator) {
            "add" -> accumulator + operand
            "sub" -> accumulator - operand
            "mul" -> accumulator * operand
            "div" -> accumulator / operand
            else -> Double.NaN
        }

        display.text = res.toString()

        accumulator = 0.0
        operator = ""
    }
}