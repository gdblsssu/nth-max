# Nth Max Project

Проект представляет RESTful сервис на Java (Spring Boot) для работы с Excel файлами, возвращающий N-е максимальное число из списка чисел.

## Требования
- JDK 17+
- Apache Maven
- Docker (опционально)
- IntelliJ IDEA

## Установка и настройка

### Запуск проекта в IntelliJ IDEA

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/gdblsssu/nth-max.git
   cd nth-max
2. Откройте проект в IntelliJ IDEA.
3. Соберите и запустите проект:
   - Откройте класс NthMaxApplication.
   - Нажмите Run.
   - Откройте Swagger UI
   ```bash
   http://localhost:8080/swagger-ui.html

   Тестовые данные находятся по пути:
   ```bash
   src/main/resources/excel/test1.xlsx

### Запуск проекта в Docker
1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/gdblsssu/nth-max.git
   cd nth-max
2. Соберите Docker образ
   ```bash
   docker build -t nth-max-app .
3. Запустите контейнер
   ```bash
   docker run -p 8080:8080 nth-max-app
4. Откройте Swagger UI
   ```bash
   http://localhost:8080/swagger-ui.html

   Тестовые данные находятся по пути:
   ```bash
   /app/excel/test1.xlsx
