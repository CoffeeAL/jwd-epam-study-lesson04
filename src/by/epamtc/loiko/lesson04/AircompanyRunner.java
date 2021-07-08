package by.epamtc.loiko.lesson04;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

import by.epamtc.loiko.lesson04.entity.Airport;
import by.epamtc.loiko.lesson04.entity.Plane;
import by.epamtc.loiko.lesson04.util.AirportFactory;

import java.util.List;

/**
 * Авиакомпания. Определить иерархию самолетов. Создать авиакомпанию. Посчитать общую вместимость и грузоподъемность.
 * Провести сортировку самолетов компании на основе одного и нескольких параметров. Найти самолет в компании,
 * соответствующий заданному диапазону параметров потребления горючего.
 * <p>
 * Требования
 * - При реализации иерархии наследования производный класс должен расширять суперкласс новыми свойствами,
 * для чего следует разобраться в предметной области задачи.
 * - Классы-сущности должны быть отделены от классов с методами бизнес-логики.
 * - Источником данных является файл(.txt). Среди данных в файле должна быть заведомо некорректная информация.
 * Должна присутствовать обработка некорректных данных инициализации объекта
 */
public class AircompanyRunner {

    public static void main(String[] args) {
        Airport airport = AirportFactory.createAirportFromFileAsDataSource();
        List<Plane> planes = airport.getPlanes();
        planes.forEach(System.out::println);
    }
}