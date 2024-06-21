**В ветке dagger-hilt-viewmodel находится пример viewmodel с использованием hilt**

В предыдущих ветках классы Person и PersonCondition были нашими. Однако, если мы будем использовать какую-либо
библиотеку, то у нас не будет доступа к классу и мы не сможем инициализировать конструктор.
Представим, что Person и PersonCondition не мои классы. Убираем оттуда **@Inject**.
```Kotlin
class Person (private val condition: PersonCondition) {

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
Теперь нам нужно сделать так, чтобы hilt всё это инициализировал. Создадим object Module.
Пометим его аннотацией **@Module**
Указываем аннотацию **@InstallIn** на то, где будет установлен этот модуль. 
![components](https://github.com/MishaNikolaev/DaggerHiltLearning/blob/dagger-hilt-viewmodel/component-hierarchy.jpg)
Выбираем SingletonComponent, чтобы доступ был в любом месте. 
Прописывем аннотацию **Provides**. Получаем:
```Kotlin
@Module
@InstallIn (SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun providePerson(personCondtion : PersonCondition) : Person{
        return Person(personCondtion)
    }

    @Provides
    fun providePersonCondition() : PersonCondition{
        return PersonCondition()
    }

}
```
Теперь у нас всё будет работать также как с Inject constructor().

Пример ViewModel:
```Kotlin
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
```
Тогда в **MainActivity** мы можем вызвать *coding()* через mainViewmodel:
```Kotlin
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var person: Person
    val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainViewModel.coding()
        }
    }
}
```
И всё работает!
![logs](https://github.com/MishaNikolaev/DaggerHiltLearning/blob/dagger-hilt-viewmodel/logscreen.jpg)


