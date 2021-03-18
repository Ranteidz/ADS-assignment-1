package calculator;

import exception.MalformedExpressionException;
import stack.LinkedStack;

import java.util.EmptyStackException;

public class CalculatorVisitor implements Visitor, Calculator {

    private LinkedStack<Token> tokenStack;


    public int getResult() throws MalformedExpressionException {
        int last = ((Operand) tokenStack.pop()).getValue();
        try {
            tokenStack.pop();
            throw new MalformedExpressionException();
        }
        catch (EmptyStackException e)
        {
        }

        return last;
    }

    public void visit(Operand operand) {
        pushOperand(operand);
    }

    public void visit(Operator operator) {
        try {
            performOperation(operator);
        } catch (MalformedExpressionException e) {
            System.out.println(e.getMessage());
        }
    }

    private void pushOperand(Operand operand) {
        tokenStack.push(operand);
    }

    private void performOperation(Operator operator) throws MalformedExpressionException {
        try {
            int result = 0;
            Operand second = (Operand) tokenStack.pop();
            Operand first = (Operand) tokenStack.pop();
            switch (operator.getOperation()) {
                case ADDITION:
                    result = first.getValue() + second.getValue();
                    break;
                case SUBTRACTION:
                    result = first.getValue() - second.getValue();
                    break;
                case DIVISION:
                    result = first.getValue() / second.getValue();
                    break;
                case MULTIPLICATION:
                    result = first.getValue() * second.getValue();
                    break;
            }
            tokenStack.push(new Operand(result));
        }
        catch (EmptyStackException e) {
            throw new MalformedExpressionException();
        }


    }
}
