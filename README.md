Nth Max Project
Проект представляет RESTful сервис на Java (Spring Boot) для работы с Excel файлами, возвращающий N-е максимальное число из списка чисел.

Требования
JDK 17+
Apache Maven
Docker (опционально)
IntelliJ IDEA
Запуск проекта в IntelliJ IDEA
Клонируйте репозиторий:

bash
Копировать код
git clone https://github.com/username/nth-max.git
cd nth-max
Откройте проект в IntelliJ IDEA.

Соберите и запустите проект:

Откройте класс NthMaxApplication.
Нажмите Run.
Откройте Swagger UI для тестирования.

Для тестирования API используйте следующие пути:

Тестовые данные: src/main/resources/excel/test1.xlsx
Пример запроса:
bash
Копировать код
GET /api/v1/get_nth_max?path=src/main/resources/excel/test1.xlsx&n=5
Запуск проекта в Docker
Клонируйте репозиторий:

bash
Копировать код
git clone https://github.com/username/nth-max.git
cd nth-max
Соберите Docker образ:

bash
Копировать код
docker build -t nth-max-app .
Запустите контейнер:

bash
Копировать код
docker run -v /абсолютный/путь/к/excel:/app/excel -p 8080:8080 nth-max-app
Откройте Swagger UI для тестирования.

Для тестирования API используйте следующие пути:

Тестовые данные: /app/excel/test1.xlsx
Пример запроса:
bash
Копировать код
GET /api/v1/get_nth_max?path=/app/excel/test1.xlsx&n=5
