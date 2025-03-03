package io.codeforall.bootcamp;

import javax.xml.transform.Source;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class WordReader implements Iterable<String>{
    private FileInputStream file;
    private String result;
    char[] buffer;

    public WordReader(String file) throws FileNotFoundException {
        this.file = new FileInputStream(file);

    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }
}
