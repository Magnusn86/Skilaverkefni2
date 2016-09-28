package is.ru.honn.reader.Exceptions;

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

