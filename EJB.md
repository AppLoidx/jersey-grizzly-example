# Дружимся с EJB

[Enterprise Java Beans (коротко)](https://github.com/AppLoidx/Web-Development-Cheats/blob/master/java-ee/EJB.md)

Для начала нам нужно включить зависимость

Переходим в pom.xml и внутри тегов `<dependencies> ... </dependencies>` добавляем:
```xml
           <dependency>
                <groupId>javax</groupId>
                <artifactId>javaee-api</artifactId>
                <version>6.0</version>
            </dependency>
```

Создадим интерфейс EJB:

```java
@Local
public interface LocalEJB {
    @GET
    @Produces(MediaType.TEXT_HTML)
    String getImage();
}
```

Создаем класс `ExampleEJB`:
```java
@Stateless
@Path("/ejb")
public class ExampleEJB implements LocalEJB{

    public String getImage(){
        return "<img src=\"https://i.imgur.com/VBCOMwl.png\" />";
    }
}
```

Теперь вызовем его перейдя по адресу:
```
http://localhost:8080/myapp/ejb
```
![](https://i.imgur.com/GZdvcUO.png)

## Инъекция EJB

Также мы можем добавить EJB в наши другие контроллеры через CDI (`@Inject`)
```java
    @Inject
    private ExampleEJB ejb;
```

Создадим ресурс с инъекцией:
```java
@Path("cdi")
public class ResourceWithCDI {
    
    @Inject
    private ExampleEJB ejb;
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get(){
        return ejb.getImage();
    }
}
```

Результат будет тем же

