package calculator;

import calculator.handler.Calculator;
import calculator.handler.RomanNumber;
import calculator.model.Number;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input:");
        String input = in.nextLine();

        Calculator calc = new Calculator();
        try {
            calc.checkOperation(input);
            calc.checkOperands(input);
            calc.validNumberValue(calc.getOp().getFirstOperand());
            calc.validNumberValue(calc.getOp().getSecondOperand());
            calc.calculate();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            exit(0);
        }

        System.out.println("Output:");
        if (calc.getOp().isArabicNumber()) {
            System.out.println(BigDecimal.valueOf(calc.getOp().getResult()).setScale(1, RoundingMode.CEILING).doubleValue());
        } else {
            RomanNumber result = new RomanNumber();
            System.out.println(result.convertToRomanNumber(calc.getOp().getResult()));
        }

        in.close();
    }
}
