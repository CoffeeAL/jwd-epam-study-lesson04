package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.MilitaryPlane;
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
public class MilitaryPlaneService {

    private MilitaryPlane militaryPlane;
    private PlaneService planeService = new PlaneService(militaryPlane);
    private MilitaryPlaneWeaponService weaponService;

    public boolean addWeapon(MilitaryPlaneWeapon weapon) throws IllegalFieldValueException {
        if (weapon == null) {
            return false;
        }
        weaponService = new MilitaryPlaneWeaponService(weapon);
        weaponService.checkWeaponFields();
        return militaryPlane.addWeapon(weapon);
    }

    public void checkMilitaryPlaneFields() throws IllegalFieldValueException {
        planeService.checkPlaneFields();
        if (militaryPlane.getType() == null) {
            throw new IllegalFieldValueException("Type of plane not specified.");
        }
    }
}