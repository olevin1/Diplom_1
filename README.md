<h1 align="center"> Diplom_1 </h1>
<h2 align="center"> Задание 1: юнит-тесты </h2>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3> О проекте </h3>

<p align="justify"> 
  В проекте тестируется приложение Stellar Burgers, которое помогает заказать бургер.
</p>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3> Что реализовано </h3>

В рамках Задания 1 выполнено следующее:

* Подключены необходимые библиотеки: Jacoco, Mockito, JUnit 4.
* Покрыты юнит-тестами классы Bun, Burger, Ingredient, IngredientType.
* Использованы в работе моки, стабы и параметризация.
* Подготовлен отчет Jacoco.

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3> Технологии </h3>

* Java 11
* JUnit 4.13.2
* Mockito 5.2.0
* Maven 3.8.1
* Jacoco 0.8.7
* Byte-buddy 1.14.2
* Commons-lang3 3.12.0

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

<h3> Как работать с проектом </h3>

Никаких дополнительных настроек проекта не требуется, юнит-тесты готовы к запуску.

| Действие                                | Как выполняется                                                                                                                                                            |
|-----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Запустить юнит-тесты                    | Выполни команду *mvn clean test*                                                                                                                                           |
| Посмотреть отчет по покрытию в браузере | Выполни команду *mvn verify* <br/>Найди в папке *target/site/jacoco/* файл *index.html*, <br/>нажми на него правой кнопкой мыши и выбери Open In — Browser — твой браузер. |