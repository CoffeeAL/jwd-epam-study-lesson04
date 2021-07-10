package by.epamtc.loiko.lesson04.util;

import lombok.experimental.UtilityClass;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
@UtilityClass
public final class RegexKeeper {

    public static final String MODEL_PATTERN = "model\\s*-\\s*";
    public static final String MAX_SPEED = "max.*\\s*speed\\s*-\\s*";
    public static final String RANGE_FLIGHT = "range\\s*fl.*\\s*-\\s*";
    public static final String AMOUNT_PASSENGERS = ".*\\s*passenger.*\\s*-\\s*";
    public static final String PLANE_WEIGHT = "\\s*plane\\s*weight\\s*-\\s*";
    public static final String CREW_AMOUNT = ".*crew.*\\s*-\\s*";
    public static final String MAX_LOADED_PLANE = "\\s*takeoff\\s*weight\\s*-\\s*";
    public static final String FUEL_CONSUMPTION = ".*fuel.*-\\s*";
    public static final String TYPE = "type\\s*-\\s*";
    public static final String WEAPON = "weapon\\s*-\\s*\\[\\s*";
    public static final String INTEGER = "[0?|[[1-9]0-9]*]";
    public static final String REAL_NUMBER = "[0|[[1-9]0-9]+][\\.,]?[0-9]*";
}