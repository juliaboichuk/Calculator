package calculator.handler;

import calculator.model.Number;
import calculator.model.RomanNumeral;

import java.util.List;

public class RomanNumber implements Number {

    @Override
    public Integer convertToNumber(String input, int startIndex, int endIndex) throws NumberFormatException {
        for (RomanNumeral romanNumeral : RomanNumeral.values()) {
            if (input.substring(startIndex, endIndex).trim().equals(romanNumeral.name()))
                return romanNumeral.getValue();
        }
        throw new NumberFormatException("Invalid number format! Check and try again!");
    }

    public String convertToRomanNumber(Double input) {
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb1 = new StringBuilder();

        while ((input > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= input) {
                sb1.append(currentSymbol.name());
                input -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb1.toString();

    }
}
