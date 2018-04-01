package validator;

import java.lang.reflect.Field;

public interface Validator {
    boolean validater(Object o) throws IllegalAccessException;

    void validatorEngine(Field field, Object object) throws IllegalAccessException;
}
