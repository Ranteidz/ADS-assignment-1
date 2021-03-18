package calculator;

public class Operator extends Token
{
  private Operation operation;

  public Operator(Operation operation) {
    this.operation = operation;
  }

  public enum Operation{
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
