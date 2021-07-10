package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.MilitaryPlaneWeapon;
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
public class MilitaryPlaneWeaponService {

    private MilitaryPlaneWeapon weapon;

    public void checkWeaponFields() throws IllegalFieldValueException {
        if (weapon.getDamage() <= 0 || weapon.getWeight() <= 0) {
            throw new IllegalFieldValueException("Field values should be positive.");
        }
    }
}