# Однажды в автобусе

## Условие 

- Ограничение времени: 1 cекунда
- Ограничение памяти: 256Mb
- Ввод: стандартный ввод или input.txt
- Вывож: стандартный вывод или output.txt

Иван Иванов летит из страны А в страну Б, и хочет скачать фильмы в дорогу. Он знает время прибытия, время отправления и разницу в часовых поясах. Помогите Ивану определить, сколько времени он проведет в самолете.

### Формат ввода

На вход подается 3 строки: Время отправления (от 0:00, до 23:59) Время прибытия (от 0:00 до 23:59) Разница в часовых поясах (от -12 до +14)

### Формат вывода

Нужно вывести время в полете: "<количество_часов>:<количество_минут>" (минимальное неотрицательное).

### Пример 1
Ввод:
12:00
13:05
0
Вывод:
1:05

### Пример 2
Ввод:
12:00
13:00
0
Вывод:
1:00

### Пример 3
Ввод:
0:00
6:25
0
Вывод:
6:25

### Пример 4
Ввод:
1:00
12:50
0
Вывод:
11:50

## Моя реализация

- Время: 224ms
- Память: 15.12Mb
- Ввод: стандартный ввод
- Вывож: стандартный вывод
- Тестов 16/17

Код в файле Main.java


