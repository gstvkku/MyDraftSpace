package io.codeforall.bootcamp.Files;

import io.codeforall.bootcamp.Exceptions.FileException;
import io.codeforall.bootcamp.Exceptions.FileNotFoundException;
import io.codeforall.bootcamp.Exceptions.NotEnoughPermissonsException;
import io.codeforall.bootcamp.Exceptions.NotEnoughSpaceException;

public class FileManager {
    private File[] files;
    private final int maxFiles;
    private boolean isLoggedIn;

    public FileManager(int maxFiles) {
        this.maxFiles = maxFiles;
        this.files = new File[maxFiles];
    }

    public void login() {
        isLoggedIn = true;
    }

    public void logOut() {
        isLoggedIn = false;
    }

    public File getFile(String fileName) throws FileException {
        if (!isLoggedIn) {
            throw new NotEnoughPermissonsException("You need to be logged in.");
        }
        for (File file : files) {
            if (file == null) {
                continue;
            }
            if (fileName.equals(file.getFileName())) {
                System.out.println("File found.");
                return file;
            }
        }
        throw new FileNotFoundException("File not found.");
    }

    public void createFile(String name) throws FileException {
        if (!isLoggedIn) {
            throw new NotEnoughPermissonsException("You need to be logged in.");
        }
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = new File(name);
                System.out.println("File Created.");
                return;
            }
            throw new NotEnoughSpaceException("You have no more space to create files.");
        }
    }
}
