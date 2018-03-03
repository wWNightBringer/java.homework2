
По задаче я просил взять за основу пакет `net.wolf.jcadv.lesson3.validation`.

То есть должен быть класс `ValidatorEngine` который принимает объект на валидацию.

Далее есть интерфейс:
```java
public interface Validator {
  void validate(Object object) throws IllegalAccessException
}
```
этот интерфейс реализуется всеми валидаторами конкретных аннотаций (Max, Min, Size, NotNull)

Далее в классе `ValidatorEngine` у нас есть поле
`private List<Validator> validators`
Это поле в конструкторе инициализируем всеми реализациями интерфейса `Validator`.

И в методе `validate` класса `ValidatorEngine`  передаем объект пришедший на валидацию в каждый класс валидатор:

```java
public void validate(Object obj) throws IllegalArgumentException, IllegalAccessException {
    if ( Objects.nonNull(obj) ) {
        for (Validator validator : validators) {
            validator.validate(obj); 
        }
    }
}
```

Все, теперь у нас есть `ValidatorEngine` которым мы можем пользоваться для валидации объектов помеченных аннотациями.
