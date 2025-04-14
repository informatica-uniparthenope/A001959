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

        operator = op

        val display = findViewById<TextView>(R.id.textDisplay)

        if (operator.equals("")) {

            accumulator = display.text.toString().toFloat().toDouble()
            display.text = "0.0"
        } else {
            var res: Double = 0.0
            val operand = display.text.toString().toFloat().toDouble()
            when(op) {
                "add" -> res = accumulator + operand
                "sub" -> res = accumulator - operand
                "mul" -> res = accumulator * operand
                "div" -> res = accumulator / operand
            }

            display.text = "0.0"

            accumulator = res
        }
    }

    private fun resListener() {
        val display = findViewById<TextView>(R.id.textDisplay)

        var res: Double = 0.0
        val operand = display.text.toString().toFloat().toDouble()
        when(operator) {
            "add" -> res = accumulator + operand
            "sub" -> res = accumulator - operand
            "mul" -> res = accumulator * operand
            "div" -> res = accumulator / operand
        }

        display.text = res.toString()

        accumulator = 0.0
    }
}