package net.reflection.validation.Interface;

import java.lang.reflect.Field;

public interface Validate {
    void validator(Object object) throws IllegalAccessException;
    void validateFields(Field field,Object o) throws IllegalAccessException;
}
