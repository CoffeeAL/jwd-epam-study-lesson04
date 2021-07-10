package by.epamtc.loiko.lesson04.service;

import by.epamtc.loiko.lesson04.comparator.PlaneMaxSpeedComparator;
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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class AircompanyService {

    private Aircompany aircompany;

    public int findTotalSeatAmount() throws NullAircompanyException {
        checkNotNullAircompany();
        return aircompany.findTotalPassengersSeatAmount();
    }

    public int findTotalTakeoffWeight() throws NullAircompanyException {
        checkNotNullAircompany();
        return aircompany.findTotalTakeoffWeight();
    }

    public List<Plane> findPlanesWithLimitedFuelConsumption(double fuelConsumption)
            throws NullAircompanyException, NegativeValueException {
        checkNotNullAircompany();
        if (fuelConsumption < 0) {
            throw new NegativeValueException("Fuel consumption cannot be negative.");
        }
        return aircompany.findPlanesWithLimitedFuelConsumption(fuelConsumption);
    }

    public List<Plane> findPlanesWithLimitedFuelConsumption(double lowerLimitFuelConsumption, double upperLimitFuelConsumption)
            throws NullAircompanyException, InvalidLimitFuelConsumptionException, NegativeValueException {
        checkNotNullAircompany();
        if (lowerLimitFuelConsumption < 0 || upperLimitFuelConsumption < 0) {
            throw new NegativeValueException("Fuel consumption cannot be negative.");
        }
        if (upperLimitFuelConsumption < lowerLimitFuelConsumption) {
            throw new InvalidLimitFuelConsumptionException("Upper limit cannot be lower than lower limit.");
        }
        return aircompany.findPlanesWithLimitedFuelConsumption(lowerLimitFuelConsumption, upperLimitFuelConsumption);
    }

    public List<Plane> findPlanesWithFarRangeFlight(int requiredRangeFlight)
            throws NegativeValueException, NullAircompanyException {
        checkNotNullAircompany();
        if (requiredRangeFlight < 0) {
            throw new NegativeValueException("Range flight can not be negative.");
        }
        return aircompany.findPlanesWithFarRangeFlight(requiredRangeFlight);
    }

    public List<PassengerPlane> findSpaciousPlanes(int minimalAmountPassengers) throws NegativeValueException, NullAircompanyException {
        checkNotNullAircompany();
        if (minimalAmountPassengers < 0) {
            throw new NegativeValueException("Amount of passengers can not be negative.");
        }
        return aircompany.findSpaciousPlanes(minimalAmountPassengers);
    }

    public Plane findFastestPlane() throws NullAircompanyException {
        checkNotNullAircompany();
        Comparator<Plane> comparator = new PlaneMaxSpeedComparator();
        Collections.sort(aircompany.getPlanes(), comparator.reversed());
        return aircompany.getPlanes().get(0);
    }

    public void sortPlanesByMaxSpeed() throws NullAircompanyException {
        checkNotNullAircompany();
        aircompany.sortPlanesByMaxSpeed();
    }

    public boolean addPlane(Plane plane) throws NullPlaneException, IllegalFieldValueException, NullAircompanyException {
        checkNotNullAircompany();
        if (plane == null) {
            throw new NullPlaneException("A plane for adding is absent.");
        }
        PlaneService planeService = new PlaneService(plane);
        if (plane instanceof PassengerPlane) {
            new PassengerPlaneService((PassengerPlane) plane, planeService).checkPassengerPlaneFields();
        } else {
            //TODO remove null from args
            new MilitaryPlaneService((MilitaryPlane) plane, planeService, null).checkMilitaryPlaneFields();
        }
        return aircompany.getPlanes().add(plane);
    }

    public void checkNotNullAircompany() throws NullAircompanyException {
        if (aircompany == null) {
            throw new NullAircompanyException("Aircompany not found");
        }
    }

    public static void checkNotNullService(AircompanyService service) throws NullServiceException {
        if (service == null) {
            throw new NullServiceException("Service is null.");
        }
    }
}