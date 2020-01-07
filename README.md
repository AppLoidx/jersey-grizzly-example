# jersey-grizzly-example

Для начала нам нужно подключить все необходимые зависимости и создать точки входа.

К счастью существует Maven и архитипы, котроые позволяет не делать это самому, а лишь сказать загрузить 
какой-то архитип. Это похоже на `git clone`, иными словами там находятся шаблоны для начала работы.

Все это добро можно сделать через консоль, либо через IDE.

Здесь мы будем использовать IDEA

## Подготовка рабочего пространства

*Нажимаем создать новый проект, и находим вкладку Maven слева*

![](https://i.imgur.com/TwNHTO3.png)

*Теперь нам нужно найти нужный нам архитип: **org.glassfish.jersey.archetypes:jersey-quickstart-grizzly2***

![](https://i.imgur.com/tejBgPM.png)

Далее, нужно будет ввести название проекта и прочее.

После заполнения всех форм нажимаем Finish, после чего IDEA запустит специальную команду для Maven, которая настроит рабочее пространство

Рекомендую нажать "Enable auto-import", когда IDEA спрости вас об этом в всплывающем окне.

## Проверка

После того как Maven закончит у нас уже будут некоторые файлы: `Main`, `MyResource`

Все что нам сейчас нужно сделать это запустить `Main`

Затем переходим по адресу:
```
http://localhost:8080/myapp/myresource
```
![](https://i.imgur.com/QewxbXq.png)

## Попробуем создать свой ресурс

Создадим класс `CustomResource`
```java
@Path("custom")
public class CustomResource {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get(){
        return "<img src=\"https://i.imgur.com/VBCOMwl.png\" />";
    }
}
```

Как видно из аннотации, он будет возвращать html-разметку.

Переходим по адресу:
```
http://localhost:8080/myapp/custom
```
![](https://i.imgur.com/PYnlxel.png)

[Использование EJB](EJB.md)
