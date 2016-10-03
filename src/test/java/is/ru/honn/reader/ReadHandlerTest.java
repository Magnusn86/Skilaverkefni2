package is.ru.honn.reader;

import is.ru.honn.reader.Factories.ReaderFactory;
import junit.framework.TestCase;

/**
 * Created by Maggi on 01/10/16.
 */
public class ReadHandlerTest extends TestCase {

    protected void setUp() {

    }

    public void test1() {
        ReaderFactory factory = new ReaderFactory();
        Reader reader = factory.getReader("videoReader");

        //reader.setReadHandler(this);
        //reader.read();


    }
}