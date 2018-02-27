package net.reflection.validation;

import net.reflection.validation.annotation.Max;
import net.reflection.validation.annotation.Min;
import net.reflection.validation.annotation.NotNull;
import net.reflection.validation.annotation.Size;

public class ValidateObject {
    @Max
            (value = "{10-1000}",
                    message = "Too big number")
    @Min
            (value = "{0-550}",
                    message = "Too little number")
    @NotNull
            (value = "{1-3}",
                    errorMessage = "PLS enter number")
    private String number;
    @Size
            (min = "{10}",
                    max = "{50}",
                    message = "Incorrect number")
    @NotNull
            (value = "{0-100}",
                    errorMessage = "PLS enter number")
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
