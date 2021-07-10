package by.epamtc.loiko.lesson04.comparator;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

import by.epamtc.loiko.lesson04.entity.Plane;

import java.util.Comparator;

public class PlaneRangeFlightComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return o1.getRangeFlight() > o2.getRangeFlight() ? 1 : o1.getRangeFlight() == o2.getRangeFlight() ? 0 : -1;
    }
}