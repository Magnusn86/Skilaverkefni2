package is.ru.honn.reader.Factories;

import is.ru.honn.reader.ReadHandler;
import is.ru.honn.reader.Reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Created by Maggi on 28/09/16.
 */
public class ReaderFactory {

    ApplicationContext context= new
            ClassPathXmlApplicationContext("/ReaderFactory-spring-config.xml");

    public Reader getReader(String readerType) {

        Reader reader = (Reader) context.getBean(readerType);
        return reader;
    }

    public static void main(String[] args)
    {


    }


}
