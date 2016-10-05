package is.ru.honn.reader;

import is.ru.honn.reader.Exceptions.ReaderException;

/**
 * A interface which is used to read JSON strings and parse them into either User or Video objects
 */
public interface Reader
{
    /**
     * Uses client request to retrieve the JSON string
     * calls the parse() to parse the JSON file
     * should call a readHandler to save the objects from the JSON file
     * @return the object that was parsed
     * @throws ReaderException is thrown if the URI or readHandler is not set
     */
    Object read() throws ReaderException;

    /**
     * Parses a JSON string (content) and returns the contents as Object
     * @param content a JSON string or a string that needs to be parsed
     * @return the object from the JSON string
     */
    Object parse(String content);

    /**
     * sets the URI from which the JSON file is to be retrieved from
     * @param URI the URI that the JSON file is requested from
     */
    void setURI(String URI);

    /**
     * Sets the readHandler which saves the objects from the read() function
     * @param readHandler the handler to use to save to the database
     */
    void setReadHandler(ReadHandler readHandler);

    //for debug purposes
    String getURI();
}
