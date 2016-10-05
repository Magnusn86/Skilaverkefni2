package is.ru.honn.reader;

import is.ru.honn.reader.Exceptions.ReaderException;

import java.util.List;

/**
 *
 * Abstract class that Implements the Reader interface all functions except parse
 * Parse is implemented in UserReader and VideoReader
 */
abstract public class AbstractReader implements Reader {
    //The handler that calls the read() function
    private ReadHandler readHandler;
    //The URI to request the JSON content from
    private String URI = null;

    //ClientRequest used to retrieve the JSON string form the URI
    private ClientRequest clientRequest = new ClientRequest();

    /**
     * Read calls the getRequest() function in the client request to get the JSON string
     * then calls the parse function the object returned from the parse() function is then
     * sent to the ReadHandler and the object from parse is returned
     * @return the object retrieved from the parse() function
     * @throws ReaderException if the URI and/ or the Handler is not set an exception is thrown
     */
    public Object read() throws ReaderException {

        if ( URI == null) {
            throw new ReaderException("URI is not set.");
        }

        if(readHandler == null) {
            throw new ReaderException("ReadHandler is not set");
        }
        String JSONstring = this.clientRequest.getRequest(URI);

        List<Object> content = (List<Object>) this.parse(JSONstring);

        readHandler.read(content.size(), content);


        return content;

    }

    public void setURI(String URI) {

        this.URI = URI;
    }

    public void setReadHandler(ReadHandler readHandler) {

        this.readHandler = readHandler;
    }

    public String getURI() {
        return this.URI;
    }

    public ReadHandler getReadHandler() {
        return this.readHandler;
    }

}
