package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.PassengerPlane;
import by.epamtc.loiko.lesson04.exception.IllegalFieldValueException;
import by.epamtc.loiko.lesson04.util.PlaneFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class PassengerPlaneServiceTest {

    private PassengerPlane plane;
    private PlaneService planeService;
    private PassengerPlaneService service;

    @Before
    public void createPassengerPlane() {
        plane = PlaneFactory.createPassengerPlane();
        planeService = new PlaneService(plane);
        service = new PassengerPlaneService(plane, planeService);
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkPassengerPlaneFieldsForNegativeValues() throws IllegalFieldValueException {
        service.getPassengerPlane().setPassengerSeatAmount(-60);
        service.checkPassengerPlaneFields();
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkPassengerPlaneFieldsForZeroValue() throws IllegalFieldValueException {
        service.getPassengerPlane().setMaxTakeoffWeight(0);
        service.checkPassengerPlaneFields();
    }

    @Test
    public void checkAllPositivePassengerPlaneFieldsValues() throws IllegalFieldValueException {
        service.checkPassengerPlaneFields();
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkIllegalValueForMaxTakeoffWeight() throws IllegalFieldValueException {
        service.getPassengerPlane().setMaxTakeoffWeight(10000);
        service.checkPassengerPlaneFields();
    }
}