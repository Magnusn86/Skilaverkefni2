package is.ru.honn.reader;

import is.ru.honn.reader.Exceptions.ReaderException;

/**
 * Created by Maggi on 21/09/16.
 */
public interface Reader
{
    public Object read() throws ReaderException;
    public Object parse(String content);
    public void setURI(String URI);
    public void setReadHandler(ReadHandler readHandler);
}
