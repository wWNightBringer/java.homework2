package net.reflection.validation;

import net.reflection.validation.Interface.Validate;
import net.reflection.validation.annotation.Size;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValidatorSize implements Validate {

    @Override
    public void validator(Object object) throws IllegalAccessException {
        if (Objects.nonNull(object)) {
            Class<?> sClass = object.getClass();
            Field[] field = sClass.getDeclaredFields();
            for (Field f : field) {
                validateFields(f, object);
            }
        }
    }

    @Override
    public void validateFields(Field field, Object o) throws IllegalAccessException {
        Annotation[] annotation = field.getAnnotations();
        for (Annotation a : annotation) {
            if (a.annotationType() == Size.class) {
                Size size = (Size) field.getAnnotation(a.annotationType());
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object value = field.get(o);
                if (Objects.nonNull(value)) {
                    Pattern pattern = Pattern.compile(size.min());
                    Pattern pattern1 = Pattern.compile(size.max());
                    if (!pattern.matcher((CharSequence) value).matches() || !pattern1.matcher((CharSequence) value).matches()) {
                        System.out.println("'Line' Invalid enter number " + value + " " + size.message());
                    } else
                        System.out.println("Correct size");
                }
            }
        }
    }
}
