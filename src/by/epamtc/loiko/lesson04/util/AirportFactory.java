package by.epamtc.loiko.lesson04.util;

import by.epamtc.loiko.lesson04.entity.Airport;
import by.epamtc.loiko.lesson04.entity.MilitaryPlane;
import by.epamtc.loiko.lesson04.entity.PassengerPlane;
import by.epamtc.loiko.lesson04.entity.Plane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static by.epamtc.loiko.lesson04.util.ParserUtil.isPattern;
import static by.epamtc.loiko.lesson04.util.ParserUtil.parseDoubleFromPattern;
import static by.epamtc.loiko.lesson04.util.ParserUtil.parseIntFromPattern;
import static by.epamtc.loiko.lesson04.util.ParserUtil.pullStringValueFromPattern;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.AMOUNT_PASSENGERS;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.CREW_AMOUNT;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.FUEL_CONSUMPTION;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.MAX_LOADED_PLANE;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.MAX_SPEED;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.MODEL_PATTERN;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.PLANE_WEIGHT;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.RANGE_FLIGHT;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

public final class AirportFactory<T extends Plane> {

    private static List<Plane> planes = new ArrayList<>();
    private static final String RESOURCE_FILE = "datasource.txt";

    public static Airport createAirportFromFileAsDataSource() {
        AirportFactory factory = new AirportFactory();
        try {
            InputStream inputStream = factory.getFileFromResourcesAsStream(RESOURCE_FILE);
            readInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return new Airport("Belarus", "Minsk-2", 3, 15, planes);
    }

    private InputStream getFileFromResourcesAsStream(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = AirportFactory.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new FileNotFoundException("File " + fileName + " not found");
        } else {
            return inputStream;
        }
    }

    private static void readInputStream(InputStream inputStream) throws IOException {
        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(streamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parameters = line.split(", ");
                if (parameters[0].equals("passenger")) {
                    PassengerPlane passengerPlane = new PassengerPlane();
                    addPlane(passengerPlane, parameters);
                } else if (parameters[0].equals("military")) {
                    MilitaryPlane militaryPlane = new MilitaryPlane();
                    addPlane(militaryPlane, parameters);
                }
            }
        }
    }

    private static <T extends Plane> boolean addPlane(T plane, String[] parameters) {
        for (String parameter : parameters) {
            if (isPattern(MODEL_PATTERN, parameter)) {
                String model = pullStringValueFromPattern(MODEL_PATTERN, parameter);
                plane.setModel(model);
            }
            if (isPattern(MAX_SPEED, parameter)) {
                int maxSpeed = parseIntFromPattern(MAX_SPEED, parameter);
                plane.setMaxSpeed(maxSpeed);
            }
            if (isPattern(RANGE_FLIGHT, parameter)) {
                int rangeFlight = parseIntFromPattern(RANGE_FLIGHT, parameter);
                plane.setRangeFlight(rangeFlight);
            }
            if (isPattern(CREW_AMOUNT, parameter)) {
                int crewAmount = parseIntFromPattern(CREW_AMOUNT, parameter);
                plane.setCrewAmount(crewAmount);
            }
            if (isPattern(PLANE_WEIGHT, parameter)) {
                int emptyPlaneWeight = parseIntFromPattern(PLANE_WEIGHT, parameter);
                plane.setEmptyPlaneWeight(emptyPlaneWeight);
            }
            if (isPattern(FUEL_CONSUMPTION, parameter)) {
                double fuelConsumption = parseDoubleFromPattern(FUEL_CONSUMPTION, parameter);
                plane.setFuelConsumption(fuelConsumption);
            }
            if (isPattern(AMOUNT_PASSENGERS, parameter) && plane instanceof PassengerPlane) {
                int passengersAmount = parseIntFromPattern(AMOUNT_PASSENGERS, parameter);
                ((PassengerPlane) plane).setPassengerSeatAmount(passengersAmount);
            }
            if (isPattern(MAX_LOADED_PLANE, parameter) && plane instanceof PassengerPlane) {
                int maxLoadedPlaneWeight = parseIntFromPattern(MAX_LOADED_PLANE, parameter);
                ((PassengerPlane) plane).setMaxWeightPeopleAndLuggage(maxLoadedPlaneWeight);
            }
        }
        return planes.add(plane);
    }
}