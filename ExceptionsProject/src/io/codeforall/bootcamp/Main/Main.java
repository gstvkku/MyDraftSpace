package io.codeforall.bootcamp.Main;

import io.codeforall.bootcamp.Exceptions.FileException;
import io.codeforall.bootcamp.Exceptions.FileNotFoundException;
import io.codeforall.bootcamp.Exceptions.NotEnoughPermissonsException;
import io.codeforall.bootcamp.Exceptions.NotEnoughSpaceException;
import io.codeforall.bootcamp.Files.FileManager;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager(1);
        try {
            fileManager.login();
            fileManager.createFile("Whatever");
            fileManager.logOut();
            fileManager.getFile("Whatever");
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnoughPermissonsException exception) {
            System.out.println(exception.getMessage());
        } catch (NotEnoughSpaceException exception) {
            System.out.println(exception.getMessage());
        } catch (FileException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
