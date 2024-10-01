package com.scm20.demo.Exceptions;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String message) {super(message);}
}
