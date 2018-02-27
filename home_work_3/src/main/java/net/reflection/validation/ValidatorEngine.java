package net.reflection.validation;

import net.reflection.validation.annotation.Max;
import net.reflection.validation.annotation.Min;
import net.reflection.validation.annotation.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValidatorEngine {
    public void validate(Object object) throws IllegalAccessException {
        if (Objects.nonNull(object)) {
            Class<?> vClass = object.getClass();
            Field[] field = vClass.getDeclaredFields();
            for (Field f : field) {
                validateFields(f, object);
            }
        }
    }

    private void validateFields(Field f, Object object) throws IllegalAccessException {
        Annotation[] annotation = f.getAnnotations();
        for (Annotation a : annotation) {
            if (a.annotationType() == NotNull.class && a.annotationType() == Max.class && a.annotationType() == Min.class) {
                NotNull notNull = (NotNull) f.getAnnotation(a.annotationType());
                Max max = (Max) f.getAnnotation(a.annotationType());
                Min min = (Min) f.getAnnotation(a.annotationType());
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                Object value = f.get(object);
                if (Objects.nonNull(value)) {
                    Pattern not = Pattern.compile(notNull.value());
                    Pattern ma = Pattern.compile(String.valueOf(max.value()));
                    Pattern mi = Pattern.compile(String.valueOf(min.value()));
                    if (!not.matcher((CharSequence) value).matches() && !ma.matcher((CharSequence) value).matches()
                            && !mi.matcher((CharSequence) value).matches()) {
                        System.out.println("Error validate of value " + value + " " + notNull.errorMessage() + " or incorrect number " +
                                max.message() + " or " + min.message());


                    }

                }
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        ValidateObject validateObject=new ValidateObject("300","Hello all world");
        ValidatorEngine engine=new ValidatorEngine();
        engine.validate(validateObject);
    }
}
