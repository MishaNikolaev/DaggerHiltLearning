**В ветке master находится код внедрения зависимостей без использования библиотки DaggerHilt**

У нас есть класс **Person**, который внутри себя содержит логику из класса **PersonCondition** 
Выглядит это так:
``` Kotlin
class Person(private val condition: PersonCondition) {  

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
```
В **MainActivity** мы инициализируем оба класса для получения доступа к **PersonCondition**

``` Kotlin
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
```
И да, действительно всё работает
![logs](https://github.com/MishaNikolaev/DaggerHiltLearning/blob/master/bandicam%202024-06-20%2014-02-33-644.jpg)

