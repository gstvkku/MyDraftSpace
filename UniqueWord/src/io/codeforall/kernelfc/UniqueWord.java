package io.codeforall.kernelfc;

import java.util.HashSet;
import java.util.Iterator;

public class UniqueWord implements Iterable<String>{
    public HashSet<String> myWords;
    private String[] separatedWords;

    public UniqueWord(String word) {
        separatedWords = word.split(" ");
        myWords = new HashSet<>();
        add();
    }

    public void add() {
        for (int i = 0; i < separatedWords.length; i++) {
            myWords.add(separatedWords[i]);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return myWords.iterator();
    }
}
