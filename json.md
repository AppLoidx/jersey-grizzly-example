# Выпустите JSON!

Для работы с JSON данными нам понадобится одна зависимость, которую необходимо раскомментить:
```xml
         <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-json-binding</artifactId>
         </dependency>
```

Теперь сделаем два DTO (data transfer object):

```java
public class Point{
    public Point(){}
    private Integer x;
    private Integer y;

    //  ... getters and setters

    @Override
    public String toString() {
        return "x = " + x + " ,y = " + y;
    }
}
```

```java
public class Message {
    public Message(){}
    public Message(String message, int code){

        this.message = message;
        this.code = code;
    }
    private String message;
    private int code;

    // ... getters and setters

    public void setCode(int code) {
        this.code = code;
    }
}
```

Также сделаем контроллер, который будет принимать json:

```java
@Path("json")
public class JsonReceiver {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message post (Point point) {

        System.out.println("Received point : " + point.toString());

        return new Message("This is message from server", 200);

    }
}
```

`Consumes` - принимаемый тип данных, `Produces` - отправляемый тип данных

То есть, когда придет запрос с телом, то приложение попытается десериализовать его в 
тип `Point`, который стоит у нас в сигнатуре метода

Также мы сказали, что будем возвращать тоже JSON, поэтому, когда мы возвращаем объект
типа `Message`, то оно автоматически сериализуется в JSON

Проверим наш ресурс с помощью cURL:
```
curl -X POST -H "accept: */*" -H "Content-Type: application/json" -d "{\"x\": 12, \"y\": 13 }" "http://localhost:8080/myapp/json" -v
```

Получим:
```
< HTTP/1.1 200 OK
< Content-Type: application/json
< Content-Length: 52
<
{"code":200,"message":"This is message from server"}* Connection #0 to host localhost left intact
```