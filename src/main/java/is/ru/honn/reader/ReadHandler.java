package is.ru.honn.reader;


/**
 * A interface for ReadHandlers they are used to save objects to database, read the JSON string and parse it.
 */
public interface ReadHandler
{

    /**
     * Iterates through the object and saves the object to a database
     * @param count number of instances in the object
     * @param object the object to be saved
     */
    public void read(int count, Object object);
}


