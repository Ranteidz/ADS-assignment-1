import calculator.CalculatorVisitor;
import calculator.Token;
import exception.MalformedExpressionException;

import java.util.ArrayList;

public class ClientForExceptions {
    CalculatorVisitor calcvisitor = new CalculatorVisitor();


    public int evaluateExpression(ArrayList<Token> tokenList) throws MalformedExpressionException {
        for (Token token : tokenList) {
            token.accept(calcvisitor);
        }
        return calcvisitor.getResult();
    }
}
