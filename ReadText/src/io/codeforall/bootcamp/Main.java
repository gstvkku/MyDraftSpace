package io.codeforall.bootcamp;

import java.io.FileNotFoundException;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WordReader wordReader = new WordReader("/Users/gustavocacau/Documents/test/textTest.txt/");

        for (String word : wordReader) {
            System.out.println(word);
        }

        Iterator<String> iterator = wordReader.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}