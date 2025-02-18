package io.codeforall.bootcamp.Exceptions;

public class NotEnoughSpaceException extends FileException{
    public NotEnoughSpaceException(String str) {
        super(str);
    }
}
