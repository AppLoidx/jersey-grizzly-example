# Дружимся с EJB

Для начала нам нужно включить зависимость

Переходим в pom.xml и внутри тегов `<dependencies> ... </dependencies>` добавляем:
```xml
           <dependency>
                <groupId>javax</groupId>
                <artifactId>javaee-api</artifactId>
                <version>6.0</version>
            </dependency>
```
Для начала сделаем интерфейс EJB:
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
