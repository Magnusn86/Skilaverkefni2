package is.ru.honn.reader;

import is.ru.honn.reader.Exceptions.ReaderException;

/**
 * Created by Maggi on 21/09/16.
 */
abstract public class AbstractReader implements Reader {

    private ReadHandler readHandler;
    private String URI;

    private ClientRequest clientRequest = new ClientRequest();

    // Ætti að kalla á ClientRequest of fær til baka JSON streng
    // - kallar svo í parse og skilar objectinu úr parse
    public Object read() throws ReaderException {

        if ( URI == null) {
            throw new ReaderException("URI is not set.");
        }

        String JSONstring = this.clientRequest.getRequest(URI);

        Object content = this.parse(JSONstring);

        return content;

    }

    public void setURI(String URI) {

        this.URI = URI;
    }

    public void setReadHandler(ReadHandler readHandler) {

        this.readHandler = readHandler;
    }
}
