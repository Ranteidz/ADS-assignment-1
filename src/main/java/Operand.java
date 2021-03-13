public class Operand extends Token
{
  private int value;



  public void accept (CalculatorVisitor visitor){

  }

  public int getValue()
  {
    return value;
  }
}
