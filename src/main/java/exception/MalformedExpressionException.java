package exception;

public class MalformedExpressionException extends Exception {
    public MalformedExpressionException ()
    {
        super("Your expression was not written correctly. Please revise it.");
    }
}
