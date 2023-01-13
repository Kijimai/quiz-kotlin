package jibby.tutorials.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val tvPlayerName: TextView = findViewById(R.id.tvPlayerName)
        val tvPlayerScore: TextView = findViewById(R.id.tvPlayerScore)
        val btnResultFinish: Button = findViewById(R.id.btnResultFinish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvPlayerName.text = intent.getStringExtra(Constants.USER_NAME)
        tvPlayerScore.text = "Your score is $correctAnswers out of $totalQuestions"

        btnResultFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}