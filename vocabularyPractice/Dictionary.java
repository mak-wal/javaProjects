package com.example.buttonandlabel.vocabularyPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Dictionary {

    private HashMap<String,String> wordPair;
    private List<String> listOfWords;
    InputView inputView;

    public Dictionary () {
        this.listOfWords = new ArrayList<>();
        this.wordPair = new HashMap<>();
    }

    public String get(String word) {
        return this.wordPair.get(word);
    }

    public void add(String word,String translation){
        if (!this.wordPair.containsKey(word)){
            this.listOfWords.add(word);
        }
        this.wordPair.put(word,translation);
    }
    public String getRandom () {
        Random random = new Random();
        return this.listOfWords.get(random.nextInt(this.listOfWords.size()));
    }
}
