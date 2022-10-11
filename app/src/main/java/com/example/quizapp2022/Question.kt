package com.example.quizapp2022

import android.widget.TextView
import com.google.gson.annotations.SerializedName
import org.w3c.dom.Text

data class Question(
    var question: String, var answer : Boolean
)
