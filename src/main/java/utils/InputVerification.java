package utils;

public class InputVerification {

    public static boolean verifyInput(String countryName, String countryCode) {
        if ((countryName.isEmpty() && countryCode.isEmpty()) || (!countryName.isEmpty() && !countryCode.isEmpty()))
            return false;
        if (countryName.isEmpty()) {
            if (!countryCode.matches("^[a-zA-Z\\s]{2,3}")) return false;
        }
        if (countryCode.isEmpty()) {
            if (!countryName.matches("^[a-zA-Z\\s]*$")) return false;
        }
        return true;
    }
}
