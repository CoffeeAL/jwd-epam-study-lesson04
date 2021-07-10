package by.epamtc.loiko.lesson04.comparator;

import by.epamtc.loiko.lesson04.entity.PassengerPlane;

import java.util.Comparator;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class PlaneMaxWeightComparator implements Comparator<PassengerPlane> {

    @Override
    public int compare(PassengerPlane o1, PassengerPlane o2) {
        return o1.getMaxTakeoffWeight() > o2.getMaxTakeoffWeight()
                ? 1
                : o1.getMaxTakeoffWeight() == o2.getMaxTakeoffWeight() ? 0 : -1;
    }
}