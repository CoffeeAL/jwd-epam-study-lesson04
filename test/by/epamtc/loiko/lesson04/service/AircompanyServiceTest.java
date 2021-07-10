package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.entity.Aircompany;
import by.epamtc.loiko.lesson04.entity.MilitaryPlane;
import by.epamtc.loiko.lesson04.entity.PassengerPlane;
import by.epamtc.loiko.lesson04.entity.Plane;
import by.epamtc.loiko.lesson04.exception.IllegalFieldValueException;
import by.epamtc.loiko.lesson04.exception.InvalidLimitFuelConsumptionException;
import by.epamtc.loiko.lesson04.exception.NegativeValueException;
import by.epamtc.loiko.lesson04.exception.NullAircompanyException;
import by.epamtc.loiko.lesson04.exception.NullPlaneException;
import by.epamtc.loiko.lesson04.exception.NullServiceException;
import by.epamtc.loiko.lesson04.util.PlaneFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class AircompanyServiceTest {

    private PassengerPlane passengerPlane;
    private MilitaryPlane militaryPlane;
    private Aircompany aircompany;
    private AircompanyService service;

    @Before
    public void createAircompany() {
        passengerPlane = PlaneFactory.createPassengerPlane();
        militaryPlane = PlaneFactory.createMilitaryPlane();
        List<Plane> planes = new ArrayList<>();
        planes.add(passengerPlane);
        planes.add(militaryPlane);
        aircompany = new Aircompany("Japan", "Japan AIR", planes);
        service = new AircompanyService(aircompany);
    }

    @Test
    public void checkFindTotalSeatsAmount() throws NullAircompanyException, IllegalFieldValueException, NullPlaneException {
        PassengerPlane additionalPlane = PlaneFactory.createAdditionalPassengerPlane();
        service.addPlane(additionalPlane);
        int expectedResultForSumSeats = 274;
        int actualResult = service.findTotalSeatAmount();
        Assert.assertTrue(expectedResultForSumSeats == actualResult);
    }

    @Test
    public void checkFindTotalTakeoffWeight() throws NullAircompanyException, IllegalFieldValueException, NullPlaneException {
        PassengerPlane additionalPlane = PlaneFactory.createAdditionalPassengerPlane();
        service.addPlane(additionalPlane);
        int expectedResultForSumMaxTakeoffWeight = 106000;
        int actualResult = service.findTotalTakeoffWeight();
        Assert.assertTrue(expectedResultForSumMaxTakeoffWeight == actualResult);
    }

    @Test
    public void checkFindPlanesWithLimitedFuelConsumption() throws NullAircompanyException, NegativeValueException {
        Assert.assertTrue(service.getAircompany().getPlanes().size() == 2);
        List<Plane> limitedFuelConsumptionPlanes = service.findPlanesWithLimitedFuelConsumption(15);
        Assert.assertTrue(limitedFuelConsumptionPlanes.size() == 1);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeLimitForFuelException() throws NullAircompanyException, NegativeValueException {
        service.findPlanesWithLimitedFuelConsumption(-15.0);
    }

    @Test
    public void checkFindPlanesWithDoubleLimitedFuelConsumption()
            throws NullAircompanyException, IllegalFieldValueException, NullPlaneException, InvalidLimitFuelConsumptionException, NegativeValueException {
        PassengerPlane additionalPlane = PlaneFactory.createAdditionalPassengerPlane();
        service.addPlane(additionalPlane);
        Assert.assertTrue(service.getAircompany().getPlanes().size() == 3);
        List<Plane> planesWithLimitedFuelConsumption = service.findPlanesWithLimitedFuelConsumption(20.0, 25.0);
        Assert.assertTrue(planesWithLimitedFuelConsumption.size() == 1);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeOneOfLimitForFuelException() throws NullAircompanyException, NegativeValueException, InvalidLimitFuelConsumptionException {
        service.findPlanesWithLimitedFuelConsumption(-15.0, 12.0);
    }

    @Test(expected = InvalidLimitFuelConsumptionException.class)
    public void checkIllegalIntervalOfLimitsForFuelException() throws NullAircompanyException, NegativeValueException, InvalidLimitFuelConsumptionException {
        service.findPlanesWithLimitedFuelConsumption(15.0, 12.0);
    }

    @Test
    public void checkFindPlanesWithFarRangeFlight()
            throws NullAircompanyException, IllegalFieldValueException, NullPlaneException, NegativeValueException {
        PassengerPlane additionalPlane = PlaneFactory.createAdditionalPassengerPlane();
        service.addPlane(additionalPlane);
        Assert.assertTrue(service.getAircompany().getPlanes().size() == 3);
        List<Plane> farRangeFlightPlanes = service.findPlanesWithFarRangeFlight(4400);
        Assert.assertTrue(farRangeFlightPlanes.size() == 1);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeValueForFarRangeFlightLimit() throws NullAircompanyException, NegativeValueException {
        service.findPlanesWithFarRangeFlight(-3400);
    }

    @Test
    public void checkFindSpaciousPlanes()
            throws NullAircompanyException, IllegalFieldValueException, NullPlaneException, NegativeValueException {
        PassengerPlane additionalPlane = PlaneFactory.createAdditionalPassengerPlane();
        service.addPlane(additionalPlane);
        Assert.assertTrue(service.getAircompany().getPlanes().size() == 3);
        List<PassengerPlane> spaciousPlanes = service.findSpaciousPlanes(130);
        Assert.assertTrue(spaciousPlanes.size() == 1);
    }

    @Test(expected = NegativeValueException.class)
    public void checkNegativeValueOfSeatsForFindSpaciousPlanes() throws NullAircompanyException, NegativeValueException {
        service.findSpaciousPlanes(-56);
    }

    @Test
    public void checkFastestPlane() throws NullAircompanyException, IllegalFieldValueException, NullPlaneException {
        PassengerPlane additionalPlane = PlaneFactory.createAdditionalPassengerPlane();
        service.addPlane(additionalPlane);
        Assert.assertTrue(service.getAircompany().getPlanes().size() == 3);
        Plane fastestPlane = service.findFastestPlane();
        Assert.assertTrue(fastestPlane.getMaxSpeed() == 2000);
    }

    @Test(expected = IllegalFieldValueException.class)
    public void checkAddInvalidPlane() throws NullAircompanyException, IllegalFieldValueException, NullPlaneException {
        MilitaryPlane invalidPlane = PlaneFactory.createInvalidPlane();
        service.addPlane(invalidPlane);
    }

    @Test(expected = NullPlaneException.class)
    public void checkAddNullAsPlane() throws NullAircompanyException, IllegalFieldValueException, NullPlaneException {
        service.addPlane(null);
    }

    @Test(expected = NullServiceException.class)
    public void checkNullService() throws NullServiceException {
        AircompanyService.checkNotNullService(null);
    }

    @Test(expected = NullAircompanyException.class)
    public void checkNullAircompany() throws NullAircompanyException {
        service.setAircompany(null);
        service.checkNotNullAircompany();
    }
}