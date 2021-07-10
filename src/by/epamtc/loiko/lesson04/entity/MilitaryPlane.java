package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MilitaryPlane extends Plane {

    private TypeMilitaryPlane type;
    private List<MilitaryPlaneWeapon> weapons = new ArrayList<>();

    public boolean addWeapon(MilitaryPlaneWeapon weapon) {
        return weapons.add(weapon);
    }

    @Override
    public String toString() {
        return "MilitaryPlane {" + super.toString() + "type = " + type + ", weapons = " + weapons + "}";
    }
}