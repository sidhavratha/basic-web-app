package tutorial.core.services.exceptions;

/**
 * Created by Sidhavratha on 26/7/15.
 */
public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(Throwable cause)
    {
        super(cause);
    }
    public BlogNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
    public BlogNotFoundException(String message)
    {
        super(message);
    }
    public BlogNotFoundException()
    {
    }
}
