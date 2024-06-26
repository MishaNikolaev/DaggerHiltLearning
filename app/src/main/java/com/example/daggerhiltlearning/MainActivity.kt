package com.example.daggerhiltlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.daggerhiltlearning.ui.theme.DaggerHiltLearningTheme

class MainActivity : ComponentActivity() {
    private lateinit var person: Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val personCondition = PersonCondition()
            person = Person(personCondition)

            person.goStudy()
            person.goLunch()
            person.goChill()

        }
    }
}