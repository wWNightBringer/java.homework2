package net.reflection.validation;

import net.reflection.validation.annotation.Max;
import net.reflection.validation.annotation.Min;
import net.reflection.validation.annotation.NotNull;
import net.reflection.validation.annotation.Size;

public class ValidateObject {
    @Max
            (value = "([1-5]{1})([0,4]{1,2})$",
                    message = "too big number")
    @Min
            (value = "(.{2,5})$",
                    message = "too little number")
    @NotNull
            (value = "(.+)$",
                    errorMessage = "PLS enter number")
    private String number;
    @Size
            (min = ".{5,}$",
                    max = ".{0,50}$",
                    message = "Incorrect number")
    @NotNull
            (value = "(.+)$",
                    errorMessage = "PLS enter right number")
    private String line;

    public ValidateObject(String number, String line) {
        this.number = number;
        this.line = line;
    }

    public String getNumber() {
        return number;
    }

    public String getLine() {
        return line;
    }
}
