package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MilitaryPlaneWeapon implements Serializable {

    private String weaponName;
    private double damage;
    private int weight;
}