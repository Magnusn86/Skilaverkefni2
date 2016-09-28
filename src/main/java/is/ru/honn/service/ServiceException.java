package is.ru.honn.service;

/**
 * Created by Maggi on 21/09/16.
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
