package calculator.handler;

import calculator.model.Number;
import calculator.model.RomanNumeral;

public class RomanNumber implements Number {

    @Override
    public Integer convertToNumber(String input, int startIndex, int endIndex) throws NumberFormatException {
        for (RomanNumeral romanNumeral : RomanNumeral.values()) {
            if (input.substring(startIndex, endIndex).trim().equals(romanNumeral.name()))
                return romanNumeral.getValue();
        }
        throw new NumberFormatException("Invalid number format! Check and try again!");
    }
}
