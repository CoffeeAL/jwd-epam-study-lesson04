package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.MilitaryPlane;
import by.epamtc.loiko.lesson04.entity.MilitaryPlaneWeapon;
import by.epamtc.loiko.lesson04.exception.IllegalFieldValueException;
import by.epamtc.loiko.lesson04.util.PlaneFactory;
import by.epamtc.loiko.lesson04.util.WeaponFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class MilitaryPlaneServiceTest {

    private MilitaryPlane plane;
    private PlaneService planeService;
    private MilitaryPlaneService service;
    private MilitaryPlaneWeapon weapon;
    private MilitaryPlaneWeaponService weaponService;

    @Before
    public void createMilitaryPlane() {
        plane = PlaneFactory.createMilitaryPlane();
        planeService = new PlaneService(plane);
        weapon = new MilitaryPlaneWeapon("Bomb", 58.6, 13);
        weaponService = new MilitaryPlaneWeaponService(weapon);
        service = new MilitaryPlaneService(plane, planeService, weaponService);
    }

    @Test
    public void checkAddWeapon() throws IllegalFieldValueException {
        MilitaryPlaneWeapon weapon = WeaponFactory.createWeapon();
        Assert.assertTrue(service.getMilitaryPlane().getWeapons().size() == 2);
        service.addWeapon(weapon);
        Assert.assertTrue(service.getMilitaryPlane().getWeapons().size() == 3);
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkAddNegativeFieldsValueInWeapon() throws IllegalFieldValueException {
        MilitaryPlaneWeapon invalidWeapon = WeaponFactory.createInvalidWeapon();
        service.addWeapon(invalidWeapon);
    }

    @Test
    public void checkAddNullWeapon() throws IllegalFieldValueException {
        Assert.assertFalse(service.addWeapon(null));
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkMilitaryPlaneFieldsForNegativeValues() throws IllegalFieldValueException {
        service.getMilitaryPlane().setMaxSpeed(-60);
        service.checkMilitaryPlaneFields();
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkMilitaryPlaneFieldsForZeroValue() throws IllegalFieldValueException {
        service.getMilitaryPlane().setCrewAmount(0);
        service.checkMilitaryPlaneFields();
    }

    @Test
    public void checkAllPositiveMilitaryPlaneFieldsValues() throws IllegalFieldValueException {
        service.checkMilitaryPlaneFields();
    }
}