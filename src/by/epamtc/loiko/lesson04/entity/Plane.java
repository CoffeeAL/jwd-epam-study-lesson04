package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Plane implements Serializable {

    private String model;
    private int maxSpeed;
    private int rangeFlight;
    private int emptyPlaneWeight;
    private double fuelConsumption;
    private int crewAmount;

    @Override
    public String toString() {
        return "model = " + model + ", max speed = " + maxSpeed + ", range flight = " + rangeFlight +
                ", empty plane weight = " + emptyPlaneWeight + ", fuel consumption = " + fuelConsumption +
                ", crew amount = " + crewAmount + ", ";
    }
}