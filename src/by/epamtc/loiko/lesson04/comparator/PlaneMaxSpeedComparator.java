package by.epamtc.loiko.lesson04.comparator;

import by.epamtc.loiko.lesson04.entity.Plane;

import java.util.Comparator;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class PlaneMaxSpeedComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return o1.getMaxSpeed() > o2.getMaxSpeed() ? 1 : o1.getMaxSpeed() == o2.getMaxSpeed() ? 0 : -1;
    }
}
