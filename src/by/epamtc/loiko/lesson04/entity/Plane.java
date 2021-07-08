package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Plane implements Serializable {

    private String model;
    private int maxSpeed;
    private int rangeFlight;
    private int emptyPlaneWeight;
    private double fuelConsumption;
    private int crewAmount;
}