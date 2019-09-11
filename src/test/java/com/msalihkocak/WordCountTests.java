package com.msalihkocak;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordCountTests {

    private WordCounter counter;

    @Before
    public void setUp() throws Exception {
        this.counter = new WordCounter("");
    }

    @Test
    public void emptyStringHasNoWords(){
        assertEquals(0, counter.getUniqueWordsCount());
    }

    @Test
    public void oneWordStringHasOneWord(){
        counter.addWord("Hi");
        assertEquals(1, counter.getUniqueWordsCount());
    }

    @Test
    public void multiWordStringHasMultiWord(){
        counter.addWord("Hi this is me");
        assertEquals(4, counter.getUniqueWordsCount());
    }

    @Test
    public void multiWordWithDuplicatesHasUniqueWords(){
        counter.addWord("Hi this is me and me");
        assertEquals(5, counter.getUniqueWordsCount());
    }

    @Test
    public void multiWordWithDuplicatesAndPunctuationHasUniqueWords(){
        counter.addWord("Hi this is me and me.");
        assertEquals(5, counter.getUniqueWordsCount());
    }

    @Test
    public void multiWordWithDuplicatesAndPunctuationAndTrimmedHasUniqueWords(){
        counter.addWord("    Hi   this     is     me     and     me.     ");
        assertEquals(5, counter.getUniqueWordsCount());
    }

    @Test
    public void multiWordWithMixedCaseAndDuplicatesAndPunctuationHasCorrectCount(){
        counter.addWord("Hi this is me and me. This Is Susan. I SAID THIS IS SUSAN");
        assertEquals(8, counter.getUniqueWordsCount());
    }
}
