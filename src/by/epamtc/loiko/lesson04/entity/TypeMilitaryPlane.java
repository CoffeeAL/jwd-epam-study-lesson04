package by.epamtc.loiko.lesson04.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum TypeMilitaryPlane {

    BOMBER("bomber"),
    FIGHTER("fighter"),
    FIGHTER_BOMBER("fighter-bomber");

    private String name;

    @Override
    public String toString() {
        return name;
    }
}