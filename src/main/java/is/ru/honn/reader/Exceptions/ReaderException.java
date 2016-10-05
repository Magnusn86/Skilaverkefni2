package is.ru.honn.reader.Exceptions;


/**
 * This Exception is used used in the Reader implementations
 */
public class ReaderException extends Exception
{
    public ReaderException()
    {
        super();
    }

    public ReaderException(String message)
    {
        super(message);
    }

    public ReaderException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

