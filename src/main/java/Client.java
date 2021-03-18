import calculator.CalculatorVisitor;
import calculator.Token;
import exception.MalformedExpressionException;

import java.util.ArrayList;

public class Client
{


  CalculatorVisitor calcvisitor = new CalculatorVisitor();


  public int evaluateExpression(ArrayList<Token> tokenList){
    try {
    for (Token token:tokenList) {
      token.accept(calcvisitor);
    }
      return calcvisitor.getResult();
    } catch (MalformedExpressionException e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }
}
