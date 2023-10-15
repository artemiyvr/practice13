import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.practice13.R
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val sideA = editTextA.text.toString().toDoubleOrNull()
            val sideB = editTextB.text.toString().toDoubleOrNull()

            if (sideA == null || sideB == null) {
                Toast.makeText(this, R.string.enter_values, Toast.LENGTH_SHORT).show()
            } else {
                val hypotenuse = sqrt(sideA.pow(2) + sideB.pow(2))
                val perimeter = sideA + sideB + hypotenuse
                val area = 0.5 * sideA * sideB

                val result = getString(R.string.result_format, hypotenuse, perimeter, area)
                resultTextView.text = result
            }
        }
    }
}
