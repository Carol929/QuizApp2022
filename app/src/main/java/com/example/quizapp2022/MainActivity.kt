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
        wireWidgets()
        //get the first question, set up the textviews
        val scoreText = getString(R.string.main_score)
        textView_score.text = "SCore: $<quiz.score"
        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonString = inputStream.bufferedReader().use{
            it.readText()
        }
        Log.d(TAG, "onCreate: $jsonString")

        val gson = Gson()

        val type = object : TypeToken<List<Question>>() { }.type
        val questionsList = gson.fromJson<List<Question>>(jsonString, type)

        Log.d(TAG, "list: $questionList")
        Log.d(TAG, "test")

        nextQuestion()

        trueButton.setOnClickListener{
            solution = true
        }

        falseButton.setOnClickListener {
            solution = false
        }
        if(solution == questionsList.get(count).answer)
        {
            score++
        }
    }

    private fun wireWidgets() {
        trueButton = findViewById(R.id.button_main_true)
        falseButton = findViewById(R.id.button_main_false)
        question = findViewById(R.id.textView_main_question)
        textView_score = findViewById(R.id.textView_main_score)
    }

    private fun nextQuestion() {
        if(count < questionList.size)
        {
            question.text = questionList.get(count).question
            count++
        }
    }

    private fun end()
    {

    }


}
