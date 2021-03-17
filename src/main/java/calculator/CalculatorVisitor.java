package calculator;

import exception.MalformedExpressionException;

public class CalculatorVisitor implements Visitor, Calculator
{


  public int getResult() throws MalformedExpressionException
  {
    return 0;
  }

  public void visit(Operand operand)
  {

  }

  public void visit(Operator operator)
  {

  }

  private void pushOperand(Operand operand){

  }

  private void performOperation(Operator operator) throws MalformedExpressionException {


  }
}
