package chapter01;

public class WasLastStringLong {

    public static boolean wasLastStringLong;

    private void setWasLastStringLong(boolean result) {
        wasLastStringLong = result;
    }

    public static boolean isStringLong(String input) {
        boolean result = input.length() > 5;
        wasLastStringLong = result;
        return result;
    }

}
