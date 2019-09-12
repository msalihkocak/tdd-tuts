package com.msalihkocak.wordcounter;

import java.util.Arrays;
import java.util.Locale;

public class WordCounter {

    private StringBuilder sentenceBuilder;

    public WordCounter(String sentenceToBeCount){
        this.sentenceBuilder = new StringBuilder(sentenceToBeCount);
    }

    public void addWord(String word) {
        this.sentenceBuilder.append(word);
    }

    public int getUniqueWordsCount() {
        String sentence = sentenceBuilder.toString();
        return sentence.isEmpty() ? 0 : countDistinctWords(stripPunctuation(sentence.toLowerCase(Locale.ENGLISH)));
    }

    private String stripPunctuation(String s){
        return s.replaceAll("\\p{P}", "");
    }

    private int countDistinctWords(String s) {
        return Arrays.stream(s.trim().split("\\s+")).distinct().toArray(String[]::new).length;
    }

    @Override
    public String toString() {
        return sentenceBuilder.toString();
    }
}
