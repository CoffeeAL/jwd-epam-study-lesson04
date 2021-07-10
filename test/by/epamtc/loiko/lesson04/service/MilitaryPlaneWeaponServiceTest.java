package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.MilitaryPlaneWeapon;
import by.epamtc.loiko.lesson04.exception.IllegalFieldValueException;
import by.epamtc.loiko.lesson04.util.WeaponFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

public class MilitaryPlaneWeaponServiceTest {

    private MilitaryPlaneWeapon weapon;
    private MilitaryPlaneWeaponService service;

    @Before
    public void createWeapon() {
        weapon = WeaponFactory.createWeapon();
        service = new MilitaryPlaneWeaponService(weapon);
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkNegativeValueForFields() throws IllegalFieldValueException {
        service.getWeapon().setDamage(-14.0);
        service.checkWeaponFields();
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkZeroValueForField() throws IllegalFieldValueException {
        service.getWeapon().setWeight(0);
        service.checkWeaponFields();
    }

    @Test
    public void checkAllValidValuesForWeaponFields() throws IllegalFieldValueException {
        service.checkWeaponFields();
    }
}