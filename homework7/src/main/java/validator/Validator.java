package validator;

import java.lang.reflect.Field;

public interface Validator {
    int validater(Object o) throws IllegalAccessException;

    void validatorEngine(Field field, Object object) throws IllegalAccessException;
}
