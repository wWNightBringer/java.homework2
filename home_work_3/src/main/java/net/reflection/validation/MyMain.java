package net.reflection.validation;

public class MyMain {
    private static ValidateEngine validateEngine;
    private static ValidateObject validateObject;

    public static void main(String[] args) throws IllegalAccessException {
        validateObject=new ValidateObject("200","30000000");
        /**
        Я не вижу этого ValidateEngine класса. Где он?
        **/
        validateEngine = new ValidateEngine();
        validateEngine.validate(validateObject);
    }
}
