package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerPlane extends Plane {

    private int passengerSeatAmount;
    private int maxWeightPeopleAndLuggage;

//    public PassengerPlane(String model, int maxSpeed, int rangeFlight, int emptyPlaneWeight, double fuelConsumption,
//                          int crewAmount, int passengerSeatAmount, int maxWeightPeopleAndLuggage) {
//        super(model, maxSpeed, rangeFlight, emptyPlaneWeight, fuelConsumption, crewAmount);
//        this.passengerSeatAmount = passengerSeatAmount;
//        this.maxWeightPeopleAndLuggage = maxWeightPeopleAndLuggage;
//    }
}