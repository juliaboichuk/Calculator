package calculator.handler;

import calculator.model.Number;

public class ArabicNumber implements Number {

    @Override
    public Integer convertToNumber(String input, int startIndex, int endIndex) throws NumberFormatException {
        return Integer.valueOf(input.substring(startIndex, endIndex).trim());
    }
}
