package by.epamtc.loiko.lesson04.util;

import by.epamtc.loiko.lesson04.entity.MilitaryPlane;
import by.epamtc.loiko.lesson04.entity.MilitaryPlaneWeapon;
import by.epamtc.loiko.lesson04.entity.PassengerPlane;
import by.epamtc.loiko.lesson04.entity.TypeMilitaryPlane;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class PlaneFactory {

    public static PassengerPlane createPassengerPlane() {
        PassengerPlane plane = PassengerPlane.builder()
                .model("Boeing-747")
                .maxSpeed(800)
                .passengerSeatAmount(170)
                .fuelConsumption(14.7)
                .rangeFlight(4230)
                .emptyPlaneWeight(15000)
                .maxTakeoffWeight(30000)
                .crewAmount(10)
                .build();
        return plane;
    }

    public static PassengerPlane createAdditionalPassengerPlane() {
        PassengerPlane additionalPlane = PassengerPlane.builder()
                .model("CRJ-200")
                .maxTakeoffWeight(76000)
                .rangeFlight(3500)
                .fuelConsumption(17.5)
                .passengerSeatAmount(104)
                .maxSpeed(950)
                .crewAmount(7)
                .emptyPlaneWeight(45000)
                .build();
        return additionalPlane;
    }

    public static MilitaryPlane createMilitaryPlane() {
        List<MilitaryPlaneWeapon> weapons = WeaponFactory.createWeaponsForMilitaryPlane();
        MilitaryPlane plane = MilitaryPlane.builder()
                .model("МиГ-29")
                .maxSpeed(2000)
                .fuelConsumption(20.7)
                .rangeFlight(4500)
                .emptyPlaneWeight(15000)
                .crewAmount(2)
                .type(TypeMilitaryPlane.FIGHTER_BOMBER)
                .weapons(weapons)
                .build();
        return plane;
    }

    public static MilitaryPlane createInvalidPlane() {
        List<MilitaryPlaneWeapon> weapons = WeaponFactory.createWeaponsForMilitaryPlane();
        MilitaryPlane plane = MilitaryPlane.builder()
                .model("МиГ-29")
                .maxSpeed(2000)
                .fuelConsumption(-20.7)
                .rangeFlight(0)
                .emptyPlaneWeight(15000)
                .crewAmount(-2)
                .type(TypeMilitaryPlane.FIGHTER_BOMBER)
                .weapons(weapons)
                .build();
        return plane;
    }

    public static List<MilitaryPlaneWeapon> createWeaponsForMilitaryPlane() {
        MilitaryPlaneWeapon firstWeapon = MilitaryPlaneWeapon.builder()
                .weaponName("Rocket")
                .damage(13.0)
                .weight(2)
                .build();
        MilitaryPlaneWeapon secondWeapon = MilitaryPlaneWeapon.builder()
                .weaponName("Bomb")
                .damage(56.0)
                .weight(10)
                .build();
        List<MilitaryPlaneWeapon> weapons = new ArrayList<>();
        weapons.add(firstWeapon);
        weapons.add(secondWeapon);
        return weapons;
    }
}