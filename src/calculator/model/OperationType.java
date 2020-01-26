package calculator.model;

public enum OperationType {
    ADD('+'), SUB('-'), DIV('/'), MUL('*');

    private Character value;

    OperationType(Character value) {
        this.value = value;
    }

    public Character getValue() {
        return value;
    }
}
