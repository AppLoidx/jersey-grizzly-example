# Приглашаем к себе статические файлы

Иногда нужно чтобы пиложение имело не только бэкенд, но и какой-то фронт енд.

Чтобы приложение показывало статические файлы (например, html) - нам нужно добавить конфигурацию:
```java
        CLStaticHttpHandler handler = new CLStaticHttpHandler(Main.class.getClassLoader(), "/static/");
        server.getServerConfiguration().addHttpHandler(handler, "/front/");
```

Общая картина в Main будет такой:
```java
public class Main {

    public static final String BASE_URI = "http://localhost:8080/myapp/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("com.apploidxxx");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();

        // setting up the static files
        CLStaticHttpHandler handler = new CLStaticHttpHandler(Main.class.getClassLoader(), "/static/");
        server.getServerConfiguration().addHttpHandler(handler, "/front/");

        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}

```

Создаем папку `resources/static` в `src/main`

Добавляем в этот `static` какой-нибудь HTML и называем index.html

Теперь перейдя по адресу:
```
http://localhost:8080/front/
```
![](https://i.imgur.com/e91KC54.png)

Наши статические файлы могут состоять не только из HTML, но и включать в себя разные css, js

Создадим в папке `static` папку `anime` и добавим туда пару файлов css, js и картинки

И перейдя по адресу:
```
http://localhost:8080/front/anime/
```
![](https://i.imgur.com/A5v2BkL.png)

К тому же, мы можем получить доступ и к самим картинкам, например:
```
http://localhost:8080/front/anime/img/2.jpg
```
