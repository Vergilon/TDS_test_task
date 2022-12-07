package mobilechecker.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobilechecker.IMobileNumberChecker;

public class RussianMobileNumberChecker implements IMobileNumberChecker {

    private final String RUSSIAN_NUMBER_REGEXP = "^(\\+7|7|8)(\\d{10})$";

    @Override
    public boolean checkNumber(String number) {
        Pattern pattern = Pattern.compile(RUSSIAN_NUMBER_REGEXP);
        var readyNumber = prepareNumber(number);
        Matcher matcher = pattern.matcher(readyNumber);
        return matcher.matches();
    }
}
