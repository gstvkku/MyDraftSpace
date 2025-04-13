package io.codeforall.bootcamp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Pojo pojo = mapper.readValue(new URL("https://ipinfo.io/json"), Pojo.class);
            System.out.println(pojo.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
