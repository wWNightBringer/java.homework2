package net.reflection.validation;

import net.reflection.validation.Interface.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyMain {
    private static ValidateEngine validateEngine;
    private static ValidateObject validateObject;

    public static void main(String[] args) throws IllegalAccessException {
        validateObject=new ValidateObject("200","30000000");
        validateEngine = new ValidateEngine();
        validateEngine.validate(validateObject);
    }
}
