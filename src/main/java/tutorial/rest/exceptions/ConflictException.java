package tutorial.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Sidhavratha on 26/7/15.
 */
@ResponseStatus(value= HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException{
    public ConflictException(Throwable cause)
    {
        super(cause);
    }
    public ConflictException()
    {
    }
}
