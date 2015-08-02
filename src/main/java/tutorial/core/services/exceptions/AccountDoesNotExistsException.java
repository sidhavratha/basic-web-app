package tutorial.core.services.exceptions;

/**
 * Created by Sidhavratha on 26/7/15.
 */
public class AccountDoesNotExistsException extends RuntimeException {
    public AccountDoesNotExistsException(Throwable cause)
    {
        super(cause);
    }
    public AccountDoesNotExistsException(String message, Throwable cause)
    {
        super(message, cause);
    }
    public AccountDoesNotExistsException(String message)
    {
        super(message);
    }
    public AccountDoesNotExistsException()
    {
    }
}
