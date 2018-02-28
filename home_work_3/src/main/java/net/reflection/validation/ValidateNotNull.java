package net.reflection.validation;

import net.reflection.validation.Interface.Validate;
import net.reflection.validation.annotation.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValidateNotNull implements Validate {

    @Override
    public void validator(Object object) throws IllegalAccessException {
        if(Objects.nonNull(object)){
            Class nClass=object.getClass();
            Field[] field=nClass.getDeclaredFields();
            for(Field f:field) validateFields(f, object);
        }
    }

    @Override
    public void validateFields(Field field, Object o) throws IllegalAccessException {
        Annotation[] annotation=field.getAnnotations();
        for(Annotation a:annotation){
            if(a.annotationType()== NotNull.class){
                NotNull notNull=(NotNull)field.getAnnotation(a.annotationType());
                if(!field.isAccessible()){
                    field.setAccessible(true);
                }
                Object value=field.get(o);
                if(Objects.nonNull(value)){
                    Pattern regex=Pattern.compile(notNull.value());
                    if(!regex.matcher((CharSequence) value).matches()){
                        System.out.println("Enter correct value "+value+" "+notNull.errorMessage());
                    }else
                        System.out.println("Correct notNull");
                }
            }
        }
    }
}
