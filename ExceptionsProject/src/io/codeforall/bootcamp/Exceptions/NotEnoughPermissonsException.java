package io.codeforall.bootcamp.Exceptions;

public class NotEnoughPermissonsException extends FileException{
    public NotEnoughPermissonsException(String str) {
        super(str);
    }
}
