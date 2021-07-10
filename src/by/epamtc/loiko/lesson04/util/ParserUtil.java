package by.epamtc.loiko.lesson04.util;

import lombok.experimental.UtilityClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson04
 */
@UtilityClass
public final class ParserUtil {

    public static boolean isPattern(String regex, String parameter) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parameter);
        return matcher.find();
    }

    public static int parseIntFromPattern(String regex, String parameter) {
        String str = pullStringValueFromPattern(regex, parameter);
        return isInteger(str) ? Integer.parseInt(str) : -1;
    }

    public static double parseDoubleFromPattern(String regex, String parameter) {
        String str = pullStringValueFromPattern(regex, parameter);
        boolean a = isRealNumber(str);
        return a ? Double.parseDouble(str) : -1.0;
    }

    private boolean isInteger(String parameter) {
        return isPattern(RegexKeeper.INTEGER, parameter);
    }

    private boolean isRealNumber(String parameter) {
        return isInteger(parameter) ? true
                                    : isPattern(RegexKeeper.REAL_NUMBER, parameter);
    }

    public static String pullStringValueFromPattern(String regex, String parameter) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parameter);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "");
        }
        StringBuilder builder = matcher.appendTail(stringBuilder);
        return builder.toString().trim();
    }

    public static String[] pullStringWeaponValueFromPattern(String regex, String parameter) {
        String source = pullStringValueFromPattern(regex, parameter);
        String[] weapons = source.split(";");
        if (weapons.length != 0) {
            weapons[weapons.length - 1] = pullStringValueFromPattern("]", weapons[weapons.length - 1]);
        }
        String[] weaponFieldDescriptionsWithoutSpaces = new String[weapons.length];
        for (int i = 0; i < weaponFieldDescriptionsWithoutSpaces.length; i++) {
            weaponFieldDescriptionsWithoutSpaces[i] = weapons[i].trim();
        }
        return weaponFieldDescriptionsWithoutSpaces;
    }
}