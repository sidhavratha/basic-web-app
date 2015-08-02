package tutorial.core.services.exceptions;

/**
 * Created by Sidhavratha on 26/7/15.
 */
public class AccountExistsException extends RuntimeException {
    public AccountExistsException(Throwable cause)
    {
        super(cause);
    }
    public AccountExistsException(String message, Throwable cause)
    {
        super(message, cause);
    }
    public AccountExistsException(String message)
    {
        super(message);
    }
    public AccountExistsException()
    {
    }
}
