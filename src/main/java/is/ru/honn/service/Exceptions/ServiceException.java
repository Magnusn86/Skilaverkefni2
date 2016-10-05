package is.ru.honn.service.Exceptions;

/**
 * Service Exception is used in the service package
 */
public class ServiceException extends Exception {

    public ServiceException()
    {
        super();
    }

    public ServiceException(String message)
    {
        super(message);
    }

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
