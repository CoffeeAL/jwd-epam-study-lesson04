package by.epamtc.loiko.lesson04.util;

import by.epamtc.loiko.lesson04.entity.Aircompany;
import by.epamtc.loiko.lesson04.entity.MilitaryPlane;
import by.epamtc.loiko.lesson04.entity.MilitaryPlaneWeapon;
import by.epamtc.loiko.lesson04.entity.PassengerPlane;
import by.epamtc.loiko.lesson04.entity.Plane;
import by.epamtc.loiko.lesson04.entity.TypeMilitaryPlane;

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
import static by.epamtc.loiko.lesson04.util.ParserUtil.pullStringWeaponValueFromPattern;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.AMOUNT_PASSENGERS;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.CREW_AMOUNT;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.FUEL_CONSUMPTION;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.MAX_LOADED_PLANE;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.MAX_SPEED;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.MODEL_PATTERN;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.INTEGER;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.PLANE_WEIGHT;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.RANGE_FLIGHT;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.REAL_NUMBER;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.TYPE;
import static by.epamtc.loiko.lesson04.util.RegexKeeper.WEAPON;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

public final class AircompanyFactory<T extends Plane> {

    private static List<Plane> planes = new ArrayList<>();
    private static final String RESOURCE_FILE = "datasource.txt";

    public static Aircompany createAirportFromFileAsDataSource() {
        AircompanyFactory factory = new AircompanyFactory();
        try {
            InputStream inputStream = factory.getFileFromResourcesAsStream(RESOURCE_FILE);
            readInputStream(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return new Aircompany("Ireland", "Ryanair", planes);
    }

    private InputStream getFileFromResourcesAsStream(String fileName) throws FileNotFoundException {
        ClassLoader classLoader = AircompanyFactory.class.getClassLoader();
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
                continue;
            }
            if (isPattern(MAX_SPEED, parameter)) {
                int maxSpeed = parseIntFromPattern(MAX_SPEED, parameter);
                plane.setMaxSpeed(maxSpeed);
                continue;
            }
            if (isPattern(RANGE_FLIGHT, parameter)) {
                int rangeFlight = parseIntFromPattern(RANGE_FLIGHT, parameter);
                plane.setRangeFlight(rangeFlight);
                continue;
            }
            if (isPattern(CREW_AMOUNT, parameter)) {
                int crewAmount = parseIntFromPattern(CREW_AMOUNT, parameter);
                plane.setCrewAmount(crewAmount);
                continue;
            }
            if (isPattern(PLANE_WEIGHT, parameter)) {
                int emptyPlaneWeight = parseIntFromPattern(PLANE_WEIGHT, parameter);
                plane.setEmptyPlaneWeight(emptyPlaneWeight);
                continue;
            }
            if (isPattern(FUEL_CONSUMPTION, parameter)) {
                double fuelConsumption = parseDoubleFromPattern(FUEL_CONSUMPTION, parameter);
                plane.setFuelConsumption(fuelConsumption);
                continue;
            }
            if (isPattern(AMOUNT_PASSENGERS, parameter) && plane instanceof PassengerPlane) {
                int passengersAmount = parseIntFromPattern(AMOUNT_PASSENGERS, parameter);
                ((PassengerPlane) plane).setPassengerSeatAmount(passengersAmount);
                continue;
            }
            if (isPattern(MAX_LOADED_PLANE, parameter) && plane instanceof PassengerPlane) {
                int maxLoadedPlaneWeight = parseIntFromPattern(MAX_LOADED_PLANE, parameter);
                ((PassengerPlane) plane).setMaxTakeoffWeight(maxLoadedPlaneWeight);
                continue;
            }
            if (isPattern(TYPE, parameter) && plane instanceof MilitaryPlane) {
                String type = pullStringValueFromPattern(TYPE, parameter);
                //TODO reduce code
                if (type.equals(TypeMilitaryPlane.BOMBER.getName())) {
                    ((MilitaryPlane) plane).setType(TypeMilitaryPlane.BOMBER);
                } else if (type.equals(TypeMilitaryPlane.FIGHTER.getName())) {
                    ((MilitaryPlane) plane).setType(TypeMilitaryPlane.FIGHTER);
                } else if (type.equals(TypeMilitaryPlane.FIGHTER_BOMBER.getName())) {
                    ((MilitaryPlane) plane).setType(TypeMilitaryPlane.FIGHTER_BOMBER);
                }
                continue;
            }
            if (isPattern(WEAPON, parameter) && plane instanceof MilitaryPlane) {
                String[] weapons = pullStringWeaponValueFromPattern(WEAPON, parameter);
                MilitaryPlaneWeapon weapon = createWeapon(weapons);
                if (canBeWeapon(weapon)) {
                    ((MilitaryPlane) plane).addWeapon(weapon);
                }
                continue;
            }
        }
        return planes.add(plane);
    }

    private static MilitaryPlaneWeapon createWeapon(String[] weaponDescription) {
        MilitaryPlaneWeapon weapon = new MilitaryPlaneWeapon();
        for (int i = 0; i < weaponDescription.length; i++) {
            if (i == 0) {
                weapon.setWeaponName(weaponDescription[i]);
            } else if (i == 1 && ParserUtil.parseDoubleFromPattern(REAL_NUMBER, weaponDescription[i]) != -1.0) {
                weapon.setDamage(Double.valueOf(weaponDescription[i].trim()));
            } else if (i == 2 && ParserUtil.parseIntFromPattern(INTEGER, weaponDescription[i]) != -1) {
                weapon.setWeight(Integer.valueOf(weaponDescription[i].trim()));
            }
        }
        return weapon;
    }

    private static boolean canBeWeapon(MilitaryPlaneWeapon weapon) {
        return weapon.getDamage() > 0 && weapon.getWeight() > 0;
    }
}