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
        return Integer.parseInt(str);
    }

    public static double parseDoubleFromPattern(String regex, String parameter) {
        String str = pullStringValueFromPattern(regex, parameter);
        return Double.parseDouble(str);
    }

    public static String pullStringValueFromPattern(String regex, String parameter) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parameter);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, "");
        }
        StringBuilder builder = matcher.appendTail(stringBuilder);
        return builder.toString();
    }
}