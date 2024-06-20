package guessing_words.models;

public class WordToGuess {
    private String enteredWord;
    private String wordCategory;
    private String hiddenEnteredWord;

    public WordToGuess(String enteredWord, String wordCategory) {
        this.enteredWord = enteredWord;
        this.wordCategory = wordCategory;
        hiddenEnteredWord = createHiddenWord();
    }

    private String createHiddenWord() {
        return "_ ".repeat(enteredWord.length());
    }

    public String getEnteredWord() {
        return enteredWord;
    }

    public void setEnteredWord(String enteredWord) {
        this.enteredWord = enteredWord;
    }

    public String getWordCategory() {
        return wordCategory;
    }

    public void setWordCategory(String wordCategory) {
        this.wordCategory = wordCategory;
    }

    public String getHiddenEnteredWord() {
        return hiddenEnteredWord;
    }

    public void setHiddenEnteredWord(String hiddenEnteredWord) {
        this.hiddenEnteredWord = hiddenEnteredWord;
    }
}
