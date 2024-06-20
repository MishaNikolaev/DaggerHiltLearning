package com.example.daggerhiltlearning

import android.util.Log
import javax.inject.Inject

class Person @Inject constructor(private val condition: PersonCondition) {

    fun goStudy(){
        condition.code()
    }

    fun goChill(){
        condition.sleep()
    }
    fun goLunch(){
        condition.eat()
    }
}

/*@Inject constructor() indicates that hilt can find classes and create exemplar*/

class PersonCondition @Inject constructor(){
    fun sleep(){
        Log.d("tag", "Some logic with sleep part here...")
    }
    fun eat(){
        Log.d("tag", "Some logic with eat part here...")
    }
    fun code(){
        Log.d("tag", "Some logic with code part here...")
    }
}