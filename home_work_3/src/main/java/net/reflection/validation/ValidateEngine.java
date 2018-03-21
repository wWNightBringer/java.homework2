package net.reflection.validation;

import net.reflection.validation.Interface.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidateEngine {
    private final List<Validate> list;

    public ValidateEngine() {
        list = new ArrayList<>();
        list.add(new ValidateNotNull());
        list.add(new ValidatorMax());
        list.add(new ValidatorMin());
        list.add(new ValidatorSize());
    }

    public void validate(Object obj) throws IllegalAccessException {
        if (Objects.nonNull(obj)) {
            for (Validate validator : list) {
                validator.validator(obj);
            }
        }

    }
}
