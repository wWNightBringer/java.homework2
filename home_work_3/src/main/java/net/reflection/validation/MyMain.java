package net.reflection.validation;

import net.reflection.validation.Interface.Validate;

public class MyMain {
    public static void main(String[] args) throws IllegalAccessException {
        ValidateObject validateObject = new ValidateObject("200", "300000");
        Validate[] validate = new Validate[4];
        validate[0] = new ValidatorMax();
        validate[1] = new ValidatorMin();
        validate[2] = new ValidateNotNull();
        validate[3] = new ValidatorSize();
        for (int i = 0; i < validate.length; i++) {
            validate[i].validator(validateObject);
        }
    }
}
