package is.ru.honn.reader;

import is.ru.honn.reader.Exceptions.ReaderException;
import is.ru.honn.reader.Factories.ReaderFactory;
import is.ru.honn.reader.ReadHandlerImplementation.ReadHandlerImp;
import is.ru.honn.reader.Readers.UserReader;
import is.ru.honn.reader.Readers.VideoReader;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Test the reader for the following:
 *  Test the reader
 *  Factory reads the reader.xml correctly
 *  Exception if URI is wrong
 *  Exception if handler is not set
 *  Check the number of lines read matches with file
 */
public class ReaderTest extends TestCase {

    public ClientRequest clientRequest = new ClientRequest();
    public Reader reader;
    public ReaderFactory readerFactory = new ReaderFactory();
    public ReadHandler readHandler = new ReadHandlerImp();

    String JSONstring;

    public void setUp() throws Exception {
        super.setUp();


    }

    @Test
    public void testReaderFactory(){

        Reader videoReader = readerFactory.getReader("videoReader");

        VideoReader videoReader1 = new VideoReader();
        System.out.println(videoReader1.getClass().getName());
        assertEquals(videoReader.getClass().getName(),videoReader1.getClass().getName() );

        Reader userReader = readerFactory.getReader("userReader");
        UserReader userReader1 = new UserReader(videoReader1);

        assertEquals(userReader.getClass().getName(),userReader1.getClass().getName() );

    }
    @Test
    public void testReaderURINotSet(){

        this.reader = readerFactory.getReader("userReader");

        String message = null;
        try {
            reader.read();
        } catch (ReaderException e) {
            message = e.getMessage();
        }

        assertEquals( "URI is not set.", message);

    }

    @Test
    public void testReadHandlerNotSet(){

        this.reader = readerFactory.getReader("userReader");
        this.reader.setURI("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650");

        String message = null;
        try {
            reader.read();
        } catch (ReaderException e) {
            message = e.getMessage();
        }

        assertEquals( "ReadHandler is not set", message);


    }

    @Test
    public void testReadingUsers(){

        this.reader = readerFactory.getReader("userReader");
        this.reader.setURI("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650");
        this.reader.setReadHandler(readHandler);

        List<Object> content = null;
        try {
            content =  (List<Object>) reader.read();
        } catch (ReaderException e) {
            assertEquals(0,1);
        }

        assertEquals(content.size(), 50);

    }


}