package calculator;

public class Operator
{
  private Operation operation;

  enum Operation{

  }

  public void accept(CalculatorVisitor visitor){

  }

  public Operation getOperation()
  {
return operation;
  }
}
