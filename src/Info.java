//Класс должен находить какую-либо информацию в нашем csv файле

/*
Этот класс должен на вход получить fileName и считать все строки в List типа Employee.

1. Метод, который возвращает среднее значение зарплат.
2. Получить работников, которые получают зарплату ниже средней.
3. Получить работников, которые являются женщинами и являются сеньорами
4. Получить медианную зарплату всех мужчин.
5. Получить медианную зарплату всех женщин.
6. Получить список женщин, зарплата которых выше средней зарплаты мужчин, являющимися сеньорами
 */

import java.util.ArrayList;
import java.util.List;

public class Info {
    private List<Employee> data;

    public Info(String fileName) {
        data = new ArrayList<>();
        //Считываем файл, получаем объекты, добавляем в список
    }


}