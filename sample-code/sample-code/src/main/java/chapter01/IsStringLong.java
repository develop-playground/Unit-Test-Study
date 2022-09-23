package chapter01;

public class IsStringLong {

    public static boolean isStringLongBefore(String input) {
        if (input.length() > 5) {
            return true;
        }
        return false;
    }

    public static boolean isStringLongAfter(String input) {
        return input.length() > 5;
    }

}
