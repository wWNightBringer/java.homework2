package net.reflection.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyReflection extends Abstract{



    @Override
    public void tellAbout(Class<?> klass) {
        System.out.printf("Методы класса:%n");

        Method[] methods = klass.getDeclaredMethods();
        for (Method method : methods) {
            aboutMethod(method);
        }
    }

    private void aboutMethod(Method method) {
        System.out.printf("\tМетод '%s';%n", method.getName());

        System.out.printf("\t\tМодификаторы %s;%n", Modifier.toString(method.getModifiers()));

        System.out.printf("\t\tТип возвращаемого значения %s;%n", method.getReturnType().getName());

        aboutAnnotation("\t\t", method.getAnnotations());

        Parameter[] parameters = method.getParameters();
        aboutParameters(parameters);
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        aboutExceptions(exceptionTypes);
    }

    private void aboutExceptions(Class<?>[] exceptionTypes) {
        System.out.printf("\t\tИсключения: %s;%n",
                Stream.of(exceptionTypes)
                        .map(Class::toString)
                        .collect(Collectors.joining(","))
        );
    }

    private void aboutParameters(Parameter[] parameters) {
        System.out.printf("\t\tПараметры метода: %s;%n",
                Stream.of(parameters)
                        .map(Parameter::toString)
                        .collect(Collectors.joining(","))
        );
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> vClass=Class.forName("net.reflection.validation.ValidatorMax");
        new MyReflection().tellAbout(vClass);
    }
}
