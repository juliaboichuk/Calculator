package calculator.handler;

import calculator.model.Number;
import calculator.model.RomanNumeral;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        int s1 = input.intValue();

        while ((s1 > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= s1) {
                sb1.append(currentSymbol.name());
                s1 -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        i = 0;
        StringBuilder sb2 = new StringBuilder();
        int s2 = (int) ((new BigDecimal(input).setScale(1, RoundingMode.CEILING).doubleValue()-input.intValue()) * 10) ;
        if (s2 != 0) {
            while ((s2 > 0) && (i < romanNumerals.size())) {
                RomanNumeral currentSymbol = romanNumerals.get(i);
                if (currentSymbol.getValue() <= s2) {
                    sb2.append(currentSymbol.name());
                    s2 -= currentSymbol.getValue();
                } else {
                    i++;
                }
            }
            return sb1.append(".").append(sb2).toString();
        } else {
            return sb1.toString();
        }
    }
}
