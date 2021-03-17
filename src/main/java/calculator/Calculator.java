package calculator;

import exception.MalformedExpressionException;

public interface Calculator
{
  public int getResult() throws MalformedExpressionException; //TODO custom exception class ? since theres no exception named in astah
}
