package net.reflection.validation;

import net.reflection.validation.Interface.Validate;
import net.reflection.validation.annotation.Min;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.regex.Pattern;

public class ValidatorMin implements Validate {
    public void validator(Object object) throws IllegalAccessException {
        if(Objects.nonNull(object)){
            Class<?> mClass;
            mClass = object.getClass();
            Field[] field=mClass.getDeclaredFields();
            for (Field f:field) {
                validateFields(f,object);
            }
        }
    }

    public void validateFields(Field f, Object object) throws IllegalAccessException {
        Annotation[] annotation=f.getAnnotations();
        for(Annotation a:annotation){
            if(a.annotationType()== Min.class){
                Min min=(Min)f.getAnnotation(a.annotationType());
                if(!f.isAccessible()){
                    f.setAccessible(true);
                }
                Object value=f.get(object);
                if(Objects.nonNull(value)){
                    Pattern regex=Pattern.compile(min.value());
                    if(!regex.matcher((CharSequence) value).matches()){
                        System.out.println("'Number' Invalid entering number "+value+" "+min.message());
                    }else
                        System.out.println("Correct min");
                }
            }
        }
    }
}
