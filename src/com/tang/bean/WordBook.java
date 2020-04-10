package com.tang.bean;

import java.util.Objects;

/**
 * @author LindaBlack
 */
public class WordBook {
    private Integer id;
    private String wordName;
    private String wordMeaning;
    private String wordPhonetic;

    @Override
    public String toString() {
        return "WordBook{" +
                "id=" + id +
                ", wordName='" + wordName + '\'' +
                ", wordMeaning='" + wordMeaning + '\'' +
                ", wordPhonetic='" + wordPhonetic + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        WordBook book = (WordBook) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(wordName, book.wordName) &&
                Objects.equals(wordMeaning, book.wordMeaning) &&
                Objects.equals(wordPhonetic, book.wordPhonetic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wordName, wordMeaning, wordPhonetic);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public void setWordMeaning(String wordMeaning) {
        this.wordMeaning = wordMeaning;
    }

    public String getWordPhonetic() {
        return wordPhonetic;
    }

    public void setWordPhonetic(String wordPhonetic) {
        this.wordPhonetic = wordPhonetic;
    }
}
