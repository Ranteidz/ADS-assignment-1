import calculator.Operand;
import calculator.Operator;
import calculator.Token;
import exception.MalformedExpressionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private ArrayList<Token> tokens;
    private ClientForExceptions client = new ClientForExceptions();

    @BeforeEach
    void setUp() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        tokens = null;
    }

    @Test
    void evaluateGoodExpression() throws MalformedExpressionException {
        tokens.add(new Operand(7));
        tokens.add(new Operand(4));
        tokens.add(new Operand(-3));
        tokens.add(new Operator(Operator.Operation.MULTIPLICATION));
        tokens.add(new Operand(1));
        tokens.add(new Operand(5));
        tokens.add(new Operator(Operator.Operation.ADDITION));
        tokens.add(new Operator(Operator.Operation.DIVISION));
        tokens.add(new Operator(Operator.Operation.MULTIPLICATION));
        assertEquals(-14, client.evaluateExpression(tokens));
    }

    @Test
    void divisionByZero() throws MalformedExpressionException {
        //can't really test this because the exception is caught in the operation visit method
        tokens.add(new Operand(7));
        tokens.add(new Operand(0));
        tokens.add(new Operator(Operator.Operation.DIVISION));
        assertThrows(MalformedExpressionException.class, () -> client.evaluateExpression(tokens));
    }

    @Test
    void evaluateExpressionMoreOperators() {
        tokens.add(new Operand(7));
        tokens.add(new Operand(4));
        tokens.add(new Operand(-3));
        tokens.add(new Operator(Operator.Operation.MULTIPLICATION));
        tokens.add(new Operand(1));
        tokens.add(new Operand(5));
        tokens.add(new Operator(Operator.Operation.ADDITION));
        tokens.add(new Operator(Operator.Operation.DIVISION));
        tokens.add(new Operator(Operator.Operation.MULTIPLICATION));
        tokens.add(new Operator(Operator.Operation.MULTIPLICATION));
        assertThrows(MalformedExpressionException.class, () -> client.evaluateExpression(tokens));
    }

    @Test
    void evaluateExpressionMoreOperands() {
        tokens.add(new Operand(7));
        tokens.add(new Operand(4));
        tokens.add(new Operand(-3));
        tokens.add(new Operator(Operator.Operation.MULTIPLICATION));
        tokens.add(new Operand(1));
        tokens.add(new Operand(5));
        tokens.add(new Operator(Operator.Operation.ADDITION));
        assertThrows(MalformedExpressionException.class, () -> client.evaluateExpression(tokens));
    }

    @Test
    void emptyTokens() {
        assertThrows(MalformedExpressionException.class, () -> client.evaluateExpression(tokens));
    }
}