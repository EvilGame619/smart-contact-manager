package com.scm20.demo.validation;

import com.scm20.demo.Exceptions.WrongPasswordException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static java.lang.Character.*;

public class PasswordValidator implements ConstraintValidator<CheckPassword,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(!(s.length()>7)) return false;
        if(!hasUpperCase(s)) return false;
        if(!hasLowerCase(s)) return false;
        if(!hasSpecialCharacter(s)) return false;
        return true;
    }

    public boolean hasUpperCase(String s){
        for (char c:s.toCharArray()){
            if (isUpperCase(c)) return true;
        }
        return false;
    }
    public boolean hasLowerCase(String s){
        for (char c:s.toCharArray()){
            if (isLowerCase(c)) return true;
        }
        return false;
    }
    public boolean hasSpecialCharacter(String s){
        for (char c:s.toCharArray()){
            if (isLetterOrDigit(c)) return true;
        }
        return false;
    }
}
