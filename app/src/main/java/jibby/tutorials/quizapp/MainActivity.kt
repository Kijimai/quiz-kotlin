package jibby.tutorials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btnStart)
        val etUserName : EditText = findViewById(R.id.etName)

        btnStart.setOnClickListener {
            if(etUserName.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name to start the quiz!", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etUserName.text.toString())
                startActivity(intent)

                // Finishes the current activity, closing it
                finish()
            }
        }
    }
}