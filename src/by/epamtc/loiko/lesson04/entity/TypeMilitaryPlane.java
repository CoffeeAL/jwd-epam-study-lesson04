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
@ToString
public enum TypeMilitaryPlane {

    BOMBER("бомбардировщик"),
    FIGHTER("истребитель"),
    FIGHTER_BOMBER("истребитель-бомбардировщик");

    private String name;
}