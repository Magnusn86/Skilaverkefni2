package is.ru.honn.rutube.reader;

/**
 * Created by Maggi on 21/09/16.
 */
public interface Reader
{
    public Object read();
    public Object parse(String content);
    public void setURI(String URI);
    public void setReadHandler(ReadHandler readHandler);
}
