package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.PassengerPlane;
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
public class PassengerPlaneService {

    private PassengerPlane passengerPlane;
    private PlaneService planeService = new PlaneService(passengerPlane);

    public void checkPassengerPlaneFields() throws IllegalFieldValueException {
        planeService.checkPlaneFields();
        if (passengerPlane.getPassengerSeatAmount() <= 0 || passengerPlane.getMaxTakeoffWeight() <= 0) {
            throw new IllegalFieldValueException("Fields of a passenger plane should be positive");
        }
        if (passengerPlane.getMaxTakeoffWeight() < passengerPlane.getEmptyPlaneWeight()) {
            throw new IllegalFieldValueException("Max takeoff weight of a passenger plane can not be less than" +
                                                 " empty weight of plane");
        }
    }
}