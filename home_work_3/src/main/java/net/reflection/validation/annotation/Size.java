package net.reflection.validation.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Size {
    String min() default "";
    String max()default "";
    String message() default "";
}
