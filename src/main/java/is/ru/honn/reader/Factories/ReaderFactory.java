package is.ru.honn.reader.Factories;

import is.ru.honn.reader.Reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Uses spring framework the return the correct type of Reader
 */
public class ReaderFactory {

    //used in the spring framework defines which file it uses
    ApplicationContext context= new
            ClassPathXmlApplicationContext("/ReaderFactory-spring-config.xml");

    /**
     * Returns the type of Reader which is specified in the readerType parameter
     * Uses spring framework to figure out which type it is returning
     * @param readerType the type of reader that we want to return
     * @return a Reader class instance for the type specified either User or Video
     */
    public Reader getReader(String readerType) {

        Reader reader = null;

        reader = (Reader) context.getBean(readerType);
        return reader;
    }

    public static void main(String[] args)
    {


    }


}
