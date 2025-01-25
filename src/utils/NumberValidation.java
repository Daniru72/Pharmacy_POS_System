package utils;

public class NumberValidation {

    public boolean NumberValidation(String number) {

        boolean isNumber = number.chars().allMatch(Character::isDigit);

        return isNumber;

    }

}
