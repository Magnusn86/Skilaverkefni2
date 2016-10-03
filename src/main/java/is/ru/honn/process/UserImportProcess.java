package is.ru.honn.process;

import is.ru.honn.reader.Exceptions.ReaderException;
import is.ru.honn.reader.Factories.ReaderFactory;
import is.ru.honn.reader.ReadHandler;
import is.ru.honn.reader.ReadHandlerImplementation.ReadHandlerImp;
import is.ru.honn.reader.Reader;
import is.ru.honn.service.UserService;
import is.ru.honn.service.VideoService;
import is.ruframework.process.RuAbstractProcess;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Maggi on 01/10/16.
 */
public class UserImportProcess extends RuAbstractProcess {

    private String importURL;
    private UserService userService;
    private VideoService videoService;
    private ReaderFactory readerFactory = new ReaderFactory();
    private Reader reader;
    private ReadHandler readHandler = new ReadHandlerImp();


    public UserImportProcess(String importURL) {
        this.importURL = importURL;
    }

    @Override
    public void startProcess() {
        //Parse-a og vista gögn

        reader = readerFactory.getReader("userReader");

        reader.setReadHandler(readHandler);

        reader.setURI(importURL);

        try {
            reader.read();
        } catch (ReaderException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void beforeProcess() {

        //Sækja gögn frá url-inu
        System.out.println("before");

    }

    @Override
    public void afterProcess() {
        //????
        System.out.println("after");

    }
}
