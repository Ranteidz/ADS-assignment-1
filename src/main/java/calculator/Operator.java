package calculator;

public class Operator extends Token
{
  private Operation operation;

  enum Operation{
    ADDITION,
    SUBTRACTION,
    DIVISION,
    MULTIPLICATION
  }

  public void accept(CalculatorVisitor visitor){
      visitor.visit(this);
  }

  public Operation getOperation()
  {
return operation;
  }
}
