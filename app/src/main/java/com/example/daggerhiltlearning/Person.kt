package com.example.daggerhiltlearning

import android.util.Log

class Person(private val condition: PersonCondition) {  /* <- This means that my
    Person class depends on the PersonResponsibilities class.
    There can be as many such dependencies as you like, because there are times when Person is needed
    in different fragments activity. This is what the hilt library will simplify. */

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

class PersonCondition{
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