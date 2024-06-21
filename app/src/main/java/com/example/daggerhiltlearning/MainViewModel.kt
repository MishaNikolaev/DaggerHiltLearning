package com.example.daggerhiltlearning

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val person: Person
): ViewModel() {

    init {
        Log.d("MyLog", "MainViewModel instance id: $person")
    }

    fun coding(){
        person.goStudy()
    }
}