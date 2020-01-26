package calculator;

import calculator.handler.Calculator;

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
        System.out.println(calc.getOp().getResult());
        in.close();
    }
}
