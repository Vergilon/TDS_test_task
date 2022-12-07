package mobilechecker;

public interface IMobileNumberChecker {

    boolean checkNumber(String number);

    default String prepareNumber(String rawNumber) {
        return rawNumber.replaceAll("\\(|\\)|\\s|-", "");
    }
}
