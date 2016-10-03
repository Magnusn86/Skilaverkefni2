package is.ru.honn.reader;

/**
 * Created by Maggi on 21/09/16.
 */
abstract public class AbstractReader implements Reader {

    private ReadHandler readHandler;
    private String URI;

    // Ætti að kalla á ClientRequest of fær til baka JSON streng
    // - kallar svo í parse og skilar objectinu úr parse
    public Object read() {

        return null;
    }

    public void setURI(String URI) {

        this.URI = URI;
    }

    public void setReadHandler(ReadHandler readHandler) {

        this.readHandler = readHandler;
    }
}
