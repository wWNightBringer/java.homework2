package net.reflection.validation;

import net.reflection.validation.Interface.Validate;
import net.reflection.validation.annotation.Max;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValidatorMax implements Validate {
    public void validator(Object object) throws IllegalAccessException {
        if (Objects.nonNull(object)) {
            Class<?> vClass = object.getClass();
            Field[] field = vClass.getDeclaredFields();
            for (Field f : field) {
                validateFields(f, object);
            }
        }
    }

    public void validateFields(Field f, Object object) throws IllegalAccessException {
        Annotation[] annotation = f.getAnnotations();
        for (Annotation a : annotation) {
            if (a.annotationType() == Max.class) {
                Max max = (Max) f.getAnnotation(a.annotationType());
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                Object value = f.get(object);
                if (Objects.nonNull(value)) {
                    Pattern not = Pattern.compile(max.value());
                    if (!not.matcher((CharSequence) value).matches()) {
                        System.out.println("'Number' Error validate of value " + value + " " + max.message());
                    }else
                        System.out.println("Correct max");

                }
            }
        }
    }

}
