# rozetka
Фреймворк реализован на языке JAVA, с использованием основных библиотек Selenium + TestNG. Сборка проекта осуществляется при помощи утилиты-сборщика Maven. 
Запуск тестов выполняется автоматически c помощью CI Jenkins каждый час (настройка крона 0 * * * *).

Фреймворк имеет следующую структуру:

/pom.xml - файл для конфигурирования Maven;

/driver - директория, для хранения файлов драйверов к браузерам;

/testng.xml - файл для конфигурирования TestNG, где указывается перечень выполняемых тест кейсов. В данном случае тест кейс TC0001;

/src - "Source"-директория, где хранятся все исходные .java файлы, которые логически разделены на следующие слои-фреймворка;

/src/main/java - директория где хранятся все необходимые исходные .java файлы, кроме самих тестов (файлы с тестами хранятся отдельно в
директории /src/test/java);

/src/main/java/core/BaseTestSettings.class - настройка запуска веб-драйвера;

/src/main/java/core/DbConfig.class - настройка подключения к БД(коннекшн/стейтмент);

/src/main/java/core/Driver.class - конфигурация веб-драйвера;

/src/main/java/core/PropertyConfig.class - для реализации пропертей(log4.properties и test.properties);

/src/main/java/DB/DbQueries.class - методы с запросами к БД;

/src/main/java/uiLayer - директория где сгруппированы Page-объекты;

/src/test/java/ - директория с автотестами. TC0001;
