**Задание: Существуют ли ситуации, когда связи между модулями должны делаться публичными?
Какие метрики вы бы предложили для количественной оценки принципов организации модулей?**

Ответ: Зависимости между модулями должны быть публичными, если мы сохдаем "настраиваемый" модуль путем изменения зависимостей из вне. Например у нас есть модуль (класс), который умеет логировать, но мы предоставляем пользователю модуля возможность выбрать реализацию логера.
Я бы использовал 2 метрики:
1. Количество связей внутри модуля - должно быть высоким, показывает насколько код решающий определенную задачу сфокусирован в одном модуле
2. Количество связей между модулями - должно быть низким, показывает насколько просто будет заменить/изменить определенный модуль