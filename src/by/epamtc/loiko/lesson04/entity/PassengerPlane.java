package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PassengerPlane extends Plane {

    private int passengerSeatAmount;
    private int maxTakeoffWeight;

    @Override
    public String toString() {
        return "PassengerPlane {" + super.toString() + "seats amount = " + passengerSeatAmount +
                ", max takeoff weight = " + maxTakeoffWeight + "}";
    }
}