package validator;

import validator.annotation.Form;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.regex.Pattern;

public class EngineValidator implements Validator {
    private boolean flag = false;

    @Override
    public boolean validater(Object object) throws IllegalAccessException {
        if (Objects.nonNull(object)) {
            Class vClass = object.getClass();
            Field[] field = vClass.getDeclaredFields();
            for (Field f : field) {
                validatorEngine(f, object);
            }
        }
        return flag;
    }

    @Override
    public void validatorEngine(Field field, Object object) throws IllegalAccessException {

        Annotation[] annotation = field.getAnnotations();
        for (Annotation notice : annotation) {
            if (notice.annotationType() == Form.class) {
                Form form = (Form) field.getAnnotation(notice.annotationType());
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object v = field.get(object);
                if (Objects.nonNull(v)) {
                    Pattern regex = Pattern.compile(form.value());
                    if (!regex.matcher((CharSequence) v).matches()) {
                        System.out.println(form.message());
                    } else {
                        flag = true;
                    }

                }
            }
        }
    }
}
