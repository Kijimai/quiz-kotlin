package jibby.tutorials.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    private var progressBar: ProgressBar? = null
    private var tvProgressText: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivCurrentImage: ImageView? = null

    private var tvChoice1: TextView? = null
    private var tvChoice2: TextView? = null
    private var tvChoice3: TextView? = null
    private var tvChoice4: TextView? = null

    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.pbProgressBar)
        tvProgressText = findViewById(R.id.tvProgressText)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivCurrentImage = findViewById(R.id.ivCurrentImage)

        tvChoice1 = findViewById(R.id.tvChoice1)
        tvChoice2 = findViewById(R.id.tvChoice2)
        tvChoice3 = findViewById(R.id.tvChoice3)
        tvChoice4 = findViewById(R.id.tvChoice4)

        tvChoice1?.setOnClickListener(this)
        tvChoice2?.setOnClickListener(this)
        tvChoice3?.setOnClickListener(this)
        tvChoice4?.setOnClickListener(this)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnSubmit?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        setQuestion()
    }

    private fun setQuestion() {
        // Reset all options background when new question is set
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivCurrentImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgressText?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvChoice1?.text = question.optionOne
        tvChoice2?.text = question.optionTwo
        tvChoice3?.text = question.optionThree
        tvChoice4?.text = question.optionFour

        if(mCurrentPosition == mQuestionsList!!.size - 1) {
            btnSubmit?.text = "Finish"
        } else {
            btnSubmit?.text = "Submit"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvChoice1?.let{
            options.add(0, it)
        }
        tvChoice2?.let{
            options.add(1, it)
        }
        tvChoice3?.let{
            options.add(2, it)
        }
        tvChoice4?.let{
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(ContextCompat.getColor(this, R.color.black))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.choice_border_bg)
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(ContextCompat.getColor(this, R.color.white))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.choice_border_bg_highlighted)
    }

    override fun onClick(view: View?) {
        when(view?.id) {

            R.id.tvChoice1 ->  {
                tvChoice1?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.tvChoice2 ->  {
                tvChoice2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tvChoice3 ->  {
                tvChoice3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tvChoice4 ->  {
                tvChoice4?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }

                        else -> {
                            Toast.makeText(this, "Congrats, you've made it to the end!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, ResultsActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(question!!.correctAnswer, R.drawable.choice_border_correct)
                        answerView(mSelectedOptionPosition, R.drawable.choice_border_incorrect)
                    } else {
                        mCorrectAnswers++
                        answerView(mSelectedOptionPosition, R.drawable.choice_border_correct)
                    }

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit?.text = "Finish"
                    } else {
                        btnSubmit?.text = "Next Question"
                    }
                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when(answer) {
            1 -> {
                tvChoice1?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvChoice2?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvChoice3?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvChoice4?.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}