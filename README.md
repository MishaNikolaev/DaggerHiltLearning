**В ветке dagger-hilt находится код внедрения зависимостей с помощью библиотки DaggerHilt**

С помощью hilt мы можем упростить нашу задачу.

Для начала в создаём базовый класс **BaseApplication** с аннотацией **HiltAndroidApp**. 
Все приложения, использующие Hilt, должны содержать Application класс с аннотацией @HiltAndroidApp
``` Kotlin
@HiltAndroidApp
class BaseApplication : Application()
```
Далее нужно указать, что у нас есть базовый класс **BaseApplication** в **AndroidManifest**.

``` Kotlin
<application
        android:name = ".BaseApplication"
  </application>
```

Переходим в **Person.kt** и помечаем класс **Person** аннотацией **Inject constructor** для того, чтобы 
hilt мог найти класс и создать его экземпляр. И то же самое делаем с классом, где у нас прописана вся логика - **PersonCondition**.

Выглядит это так:
``` Kotlin
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

```
В **MainActivity** мы указывем в самом начале аннотацию **@AndroidEntryPoint** для добавления зависимостей (Это некая точка входа, чтобы hilt знал куда вживить Person).
Прописываем аннотацию **@Inject**

Эти инициализации нам не нужны:
``` Kotlin
val personCondition = PersonCondition()
            person = Person(personCondition)
```
Убираем модификатор доступа private в 
``` Kotlin
private latenit var person: Person
```

И получаем:

``` Kotlin
@AndroidEntryPoint 
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var person: Person
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            person.goStudy()
            person.goLunch()
            person.goChill()

        }
    }
}
```
И да, действительно всё работает
![logs](https://github.com/MishaNikolaev/DaggerHiltLearning/blob/master/bandicam%202024-06-20%2014-02-33-644.jpg)

