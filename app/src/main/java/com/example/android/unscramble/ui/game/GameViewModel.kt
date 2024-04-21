package com.example.android.unscramble.ui.game

//ViewModelпозволяет данным приложения сохраняться при изменении конфигурации.
import android.util.Log
import androidx.lifecycle.ViewModel
//раздел 10
//https://web.archive.org/web/20230924133701/https://developer.android.com/codelabs/basic-android-kotlin-training-viewmodel#7

class GameViewModel : ViewModel() {
//    val msg = "GameViewModel created!"

private var wordsList: MutableList<String> = mutableListOf() // не работает если прописать их перед функциями -
    private lateinit var currentWord: String // после блока инициализации

    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }
    /* пример, не инициализируется!
//    private var wordsList: MutableList<String> = mutableListOf()
//    private lateinit var currentWord: String
    */


    /*Предупреждение .
    Никогда не открывайте изменяемые поля данных из своего класса ViewModel—
    убедитесь, что эти данные нельзя изменить из другого класса.
    Изменяемые данные внутри ViewModelвсегда должны быть private.*/
    private var _score = 0
    val score: Int
        get() = _score
//    private var score = 0
    private var _currentWordCount = 0
     val currentWordCount: Int
         get() = _currentWordCount
//    public val currentScrambledWord = "test"

//    // Declare private mutable variable that can only be modified
//// within the class it is declared.
    private var _count = 0
//
//    // Declare another public immutable field and override its getter method.
//// Return the private property's value in the getter method.
//// When count is accessed, the get() function is called and
//// the value of _count is returned.
    val count: Int
        get() = _count
//
//  private var _currentScrambledWord = "test" // не работает если if находится вне while
    private lateinit var _currentScrambledWord: String // = не работает если if находится в цикле while, приложение не запускается
    val currentScrambledWord: String
        get() = _currentScrambledWord


    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }


   private fun getNextWord() {
      currentWord = allWordsList.random()
       val tempWord = currentWord.toCharArray()
       tempWord.shuffle()

       while (tempWord.toString().equals(currentWord, false)) {
           tempWord.shuffle()
       }
       if (wordsList.contains(currentWord)) {
           getNextWord()
       } else {
           _currentScrambledWord = String(tempWord)
           ++_currentWordCount
           wordsList.add(currentWord)
       }
//       tempWord.shuffle()
    }

    fun nextWord(): Boolean {
        return if (_currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }
    private fun increaseScore() {
        _score += SCORE_INCREASE
    }
    fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentWord, true)) {
            increaseScore()
            return true
        }
        return false
    }

    fun reinitializeData() {
        _score = 0
        _currentWordCount = 0
        wordsList.clear()
        getNextWord()
    }
}