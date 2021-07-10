package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.Plane;
import by.epamtc.loiko.lesson04.exception.IllegalFieldValueException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PlaneService {

    private Plane plane;

    public void checkPlaneFields() throws IllegalFieldValueException {
        if (plane.getMaxSpeed() <= 0 || plane.getRangeFlight() <= 0 || plane.getEmptyPlaneWeight() <= 0 ||
                plane.getFuelConsumption() <= 0 || plane.getCrewAmount() <= 0) {
            throw new IllegalFieldValueException("Field values should be positive.");
        }
    }
}