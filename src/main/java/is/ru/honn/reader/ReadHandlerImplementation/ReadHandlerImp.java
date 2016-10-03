package is.ru.honn.reader.ReadHandlerImplementation;

import is.ru.honn.reader.Factories.ReaderFactory;
import is.ru.honn.reader.ReadHandler;
import is.ru.honn.reader.Reader;
import is.ru.honn.reader.Readers.UserReader;

/**
 * Created by Maggi on 28/09/16.
 */
public class ReadHandlerImp implements ReadHandler {

    ReaderFactory factory = new ReaderFactory();

    public void read(int count, Object object) {


        Reader reader = factory.getReader("videoReader");

        reader.setReadHandler(this);
        reader.read();
    }



    public static void main(String args[]){

    }
}
