package com.example.quizapp2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    private lateinit var quiz: Quiz
    lateinit var trueButton: Button
    lateinit var falseButton: Button
    lateinit var question: TextView
    lateinit var textView_score: TextView
    var solution = false
    lateinit var questionList: List<Question>
    var score = 0
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestions()
        wireWidgets()
        //get the first question, set up the textviews
        val scoreText = getString(R.string.main_score)
        textView_score.text = "SCore: $<quiz.score"
        trueButton.setOnClickListener{
            solution = true
        }

        falseButton.setOnClickListener {
            solution = false
        }

    }

    private fun wireWidgets() {
        trueButton = findViewById(R.id.button_main_true)
        falseButton = findViewById(R.id.button_main_false)
        question = findViewById(R.id.textView_main_question)
        textView_score = findViewById(R.id.textView_main_score)
    }

    private fun loadQuestions() {
        /*
        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonString = inputStream.bufferedReader().use{
            it.readText()
        }
        Log.d(TAG, "onCreate: $jsonString")

        val gson = Gson()

        val type = object : TypeToken<List<Question>>() { }.type
        val questions = gson.fromJson<List<Question>>(jsonString, type)

        //create the quiz object from the list of questions
        quiz = Quiz(questions)*/
        if(count < questionList.size)
        {
            question.text = questionList(count).getQuestion()

        }
    }


}
