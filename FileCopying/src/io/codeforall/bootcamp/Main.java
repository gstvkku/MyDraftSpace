package io.codeforall.bootcamp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/gustavocacau/Documents/test/morta-patati.gif/");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/gustavocacau/Documents/test2/");
        byte[] bytes = new byte[1024];
        int copyBytes = 0;
        while (copyBytes != -1) {
            copyBytes = fileInputStream.read(bytes);
            if (copyBytes != -1) {
                System.out.println(copyBytes);
                fileOutputStream.write(bytes, 0, copyBytes);
            }
        }
    }
}