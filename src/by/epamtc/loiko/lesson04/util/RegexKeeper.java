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
    public static final String PLANE_WEIGHT = ".*weight.*-\\s*";
    public static final String CREW_AMOUNT = ".*crew.*\\s*-\\s*";
    public static final String MAX_LOADED_PLANE = ".*takeoff.*-\\s*";
    public static final String FUEL_CONSUMPTION = ".*fuel.*-\\s*";
    public static final String TYPE = "type\\s*-\\s*";
}