package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.Plane;
import by.epamtc.loiko.lesson04.exception.IllegalFieldValueException;
import by.epamtc.loiko.lesson04.util.PlaneFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class PlaneServiceTest {

    private Plane plane;
    private PlaneService service;

    @Before
    public void createPlane() {
        plane = PlaneFactory.createPassengerPlane();
        service = new PlaneService(plane);
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkNegativeValueForPlaneField() throws IllegalFieldValueException {
        service.getPlane().setCrewAmount(-10);
        service.checkPlaneFields();
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkZeroValueForPlaneField() throws IllegalFieldValueException {
        service.getPlane().setMaxSpeed(0);
        service.checkPlaneFields();
    }

    @Test
    public void checkAllPositiveFieldValuesForPlaneField() throws IllegalFieldValueException {
        service.checkPlaneFields();
        Assert.assertNotNull(plane);
    }
}