package net.reflection.validation.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface NotNull {
    String value() default "";
    String  errorMessage() default "";
}
