package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MilitaryPlane extends Plane {

    private TypeMilitaryPlane type;
    private List<MilitaryPlaneWeapon> weapons = new ArrayList<>();

    public MilitaryPlane(String model, int maxSpeed, int rangeFlight, int emptyPlaneWeight, double fuelConsumption,
                         int crewAmount, TypeMilitaryPlane type) {
        super(model, maxSpeed, rangeFlight, emptyPlaneWeight, fuelConsumption, crewAmount);
        this.type = type;
    }
}