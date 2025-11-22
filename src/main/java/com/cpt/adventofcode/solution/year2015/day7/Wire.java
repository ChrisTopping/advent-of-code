package com.cpt.adventofcode.solution.year2015.day7;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class Wire {

    @Getter
    private final String name;
    private final Operator operator;
    private final String[] operands;
    @Getter
    @Setter
    private Integer value;

    public Wire(String name, String operation) {
        this.name = name;
        this.operator = Operator.fromOperation(operation);
        operands = operator.getOperands(operation);

        if (operator.equals(Operator.SET) && this.operands[0].matches("\\d+")) {
            value = Integer.parseInt(this.operands[0]);
        }
    }

    public int evaluate(Map<String, Wire> wires) {
        if (value != null) return value;

        int result = switch (operator) {
            case AND, OR, LSHIFT, RSHIFT -> operator.apply(parseOperand(operands[0], wires), parseOperand(operands[1], wires));
            case NOT, SET -> operator.apply(parseOperand(operands[0], wires), 0);
        };

        this.value = result;
        return result;
    }

    private int parseOperand(String operand, Map<String, Wire> wires) {
        if (operand.matches("\\d+")) {
            return Integer.parseInt(operand);
        } else {
            return wires.get(operand).evaluate(wires);
        }
    }

}
