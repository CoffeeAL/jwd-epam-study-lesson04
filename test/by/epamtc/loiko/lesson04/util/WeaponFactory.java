package by.epamtc.loiko.lesson04.util;

import by.epamtc.loiko.lesson04.entity.MilitaryPlaneWeapon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
public class WeaponFactory {

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

    public static MilitaryPlaneWeapon createWeapon() {
        MilitaryPlaneWeapon weapon = MilitaryPlaneWeapon.builder()
                .weaponName("Rocket")
                .damage(13.0)
                .weight(2)
                .build();
        return weapon;
    }

    public static MilitaryPlaneWeapon createInvalidWeapon() {
        MilitaryPlaneWeapon weapon = MilitaryPlaneWeapon.builder()
                .weaponName("Rocket")
                .damage(13.0)
                .weight(-10)
                .build();
        return weapon;
    }
}