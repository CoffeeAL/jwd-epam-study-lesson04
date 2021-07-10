package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircompany implements Serializable {

    private String country;
    private String name;
    private List<Plane> planes = new ArrayList<>();

    public int findTotalPassengersSeatAmount() {
        int totalPassengersSeatAmount = 0;
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                totalPassengersSeatAmount += ((PassengerPlane) plane).getPassengerSeatAmount();
            }
        }
        return totalPassengersSeatAmount;
    }

    public int findTotalTakeoffWeight() {
        int totalTakeoffWeight = 0;
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                totalTakeoffWeight += ((PassengerPlane) plane).getMaxTakeoffWeight();
            }
        }
        return totalTakeoffWeight;
    }

    public List<Plane> findPlanesWithLimitedFuelConsumption(double limitFuelConsumption) {
        List<Plane> limitedFuelConsumptionPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane.getFuelConsumption() <= limitFuelConsumption) {
                limitedFuelConsumptionPlanes.add(plane);
            }
        }
        return limitedFuelConsumptionPlanes;
    }

    public List<Plane> findPlanesWithLimitedFuelConsumption(double lowerLimitFuelConsumption, double upperLimitFuelConsumption) {
        List<Plane> limitedFuelConsumptionPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            double fuelConsumption = plane.getFuelConsumption();
            if (fuelConsumption >= lowerLimitFuelConsumption && fuelConsumption <= upperLimitFuelConsumption) {
                limitedFuelConsumptionPlanes.add(plane);
            }
        }
        return limitedFuelConsumptionPlanes;
    }

    public List<Plane> findPlanesWithFarRangeFlight(int minimalRangeFlight) {
        List<Plane> farFlyablePlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane.getRangeFlight() >= minimalRangeFlight) {
                farFlyablePlanes.add(plane);
            }
        }
        return farFlyablePlanes;
    }

    public List<PassengerPlane> findSpaciousPlanes(int minimalPassengersAmount) {
        List<PassengerPlane> spaciousPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane && ((PassengerPlane) plane).getPassengerSeatAmount() >= minimalPassengersAmount) {
                spaciousPlanes.add((PassengerPlane) plane);
            }
        }
        return spaciousPlanes;
    }

    @Override
    public String toString() {
        StringBuilder listOfPlanes = new StringBuilder();
        for (Plane plane : planes) {
            listOfPlanes.append(plane + "\n");
        }
        return "Aircompany: country = " + country + ", name = " + name + ", planes = \n" + listOfPlanes;
    }
}