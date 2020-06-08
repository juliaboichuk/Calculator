package calculator.handler;

import calculator.model.Number;
import calculator.model.Operation;
import calculator.model.OperationType;

public class Calculator {

    private Operation op = new Operation();

    public Operation getOp() {
        return op;
    }

    public void setOp(Operation op) {
        this.op = op;
    }

    public void checkOperation(String input) {
        for (OperationType c : OperationType.values()) {
            if (input.contains(c.getValue().toString())) {
                op.setOperationType(c);
                return;
            }
        }
        throw new IllegalArgumentException("Illegal operation! The calculator1 can perform operations" +
                "\nof addition, subtraction, multiplication and division with two numbers");
    }

    public void checkOperands(String input) {
        input = input.toUpperCase();
        int endIndex = input.indexOf(op.getOperationType().getValue());
        int startIndex = endIndex + 1;

        Number number;
        try {
            number = new ArabicNumber();
            op.setFirstOperand(number.convertToNumber(input, 0, endIndex));
            op.setSecondOperand(number.convertToNumber(input, startIndex, input.length()));
            op.setArabicNumber(true);
        } catch (NumberFormatException e1) {
            number = new RomanNumber();
            op.setFirstOperand(number.convertToNumber(input, 0, endIndex));
            op.setSecondOperand(number.convertToNumber(input, startIndex, input.length()));
            op.setArabicNumber(false);
        }
    }

    public void validNumberValue(Integer number) {
        if (number < 1 || number > 10)
            throw new IllegalArgumentException("Invalid operand value! The operand value must be between 1 and 10.");
    }

    public void calculate() {
        switch (op.getOperationType()) {
            case ADD:
                op.setResult((double) (op.getFirstOperand() + op.getSecondOperand()));
                break;
            case SUB:
                op.setResult((double) (op.getFirstOperand() - op.getSecondOperand()));
                break;
            case DIV:
                op.setResult((double) op.getFirstOperand() / (double) op.getSecondOperand());
                break;
            case MUL:
                op.setResult((double) (op.getFirstOperand() * op.getSecondOperand()));
                break;
        }
    }
}
