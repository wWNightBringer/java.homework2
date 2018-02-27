package net.reflection.reflection;

import java.lang.annotation.Annotation;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Abstract  {
    public abstract void tellAbout(Class<?> klass);

    protected void aboutAnnotation(String prefix, Annotation[] annotations) {
        if (annotations.length != 0) {
            System.out.printf("%sАннотация(и): %s;%n", prefix,
                    Stream.of(annotations)
                            .map(Annotation::toString)
                            .collect(Collectors.joining(", ")));
        } else {
            System.out.printf("%sАннотации отсутсвуют;%n", prefix);
        }
    }
}
