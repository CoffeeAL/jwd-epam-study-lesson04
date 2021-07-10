package by.epamtc.loiko.lesson04;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

import by.epamtc.loiko.lesson04.entity.Aircompany;
import by.epamtc.loiko.lesson04.entity.Plane;
import by.epamtc.loiko.lesson04.exception.NullAircompanyException;
import by.epamtc.loiko.lesson04.exception.NullServiceException;
import by.epamtc.loiko.lesson04.service.AircompanyService;
import by.epamtc.loiko.lesson04.util.AircompanyFactory;

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
        Aircompany aircompany = AircompanyFactory.createAirportFromFileAsDataSource();
        AircompanyService service = new AircompanyService(aircompany);
        System.out.println(aircompany);
        try {
            printReport(service);
        } catch (NullAircompanyException | NullServiceException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void printReport(AircompanyService service) throws NullAircompanyException, NullServiceException {
        printTotalPassengersReport(service);
        printMaxTakeoffWeightReport(service);
        printFastestPlaneReport(service);
    }

    public static void printTotalPassengersReport(AircompanyService service)
            throws NullAircompanyException, NullServiceException {
        AircompanyService.checkNotNullService(service);
        StringBuilder totalPassengersReport = new StringBuilder();
        totalPassengersReport.append("Max passengers amount that could be transported by the aircompany is ");
        totalPassengersReport.append(findTotalPassengersSeatsAmount(service));
        System.out.println(totalPassengersReport);
    }

    private static int findTotalPassengersSeatsAmount(AircompanyService service) throws NullAircompanyException {
        return service.findTotalSeatAmount();
    }

    public static void printMaxTakeoffWeightReport(AircompanyService service)
            throws NullAircompanyException, NullServiceException {
        AircompanyService.checkNotNullService(service);
        StringBuilder maxPassengersAndLuggageWeight = new StringBuilder();
        maxPassengersAndLuggageWeight.append("Total max takeoff weight is ");
        maxPassengersAndLuggageWeight.append(findMaxTakeoffWeight(service));
        System.out.println(maxPassengersAndLuggageWeight);
    }

    private static int findMaxTakeoffWeight(AircompanyService service) throws NullAircompanyException {
        return service.findTotalTakeoffWeight();
    }

    public static void printFastestPlaneReport(AircompanyService service)
            throws NullAircompanyException, NullServiceException {
        AircompanyService.checkNotNullService(service);
        StringBuilder fastestPlane = new StringBuilder();
        fastestPlane.append("The fastest plane in the aircompany is ");
        fastestPlane.append(findFastest(service));
        System.out.println(fastestPlane);
    }

    private static Plane findFastest(AircompanyService service) throws NullAircompanyException {
        return service.findFastestPlane();
    }
}