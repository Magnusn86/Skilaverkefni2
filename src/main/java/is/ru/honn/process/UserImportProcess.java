package is.ru.honn.process;

import is.ru.honn.domain.User;
import is.ru.honn.reader.Exceptions.ReaderException;
import is.ru.honn.reader.Factories.ReaderFactory;
import is.ru.honn.reader.ReadHandler;
import is.ru.honn.reader.ReadHandlerImplementation.ReadHandlerImp;
import is.ru.honn.reader.Reader;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Uses the RuFramework - the RuAbstractRunner to create a instance of this class with the process.xml file in the
 * root directory
 */
public class UserImportProcess extends RuAbstractProcess {

    Logger log = Logger.getLogger(this.getClass().getName());
    MessageSource msg;
    ApplicationContext ctx= new
            ClassPathXmlApplicationContext("/app.xml");
    private int numberOfUsersRead = 0;
    private ReaderFactory readerFactory;
    private Reader reader;
    private ReadHandler readHandler = new ReadHandlerImp();


    public UserImportProcess() {
    }

    /**
     * Gets the URI from the process.xml using the RuFramework and uses that URI to read and parse the JSON
     * file and saves it to the "database"
     * Logs the process to the message resources
     */
    @Override
    public void startProcess() {

        //Gat ekki sett "messages" í app.xml þurfti annað hvort að vera messages_US eða messages_IS
        //Er á macca veit ekki hvað vesenið var en það þekkti allaveganna ekki messages.
        // Því harðkóðaði í ég app.xml að það væru bara US messages :(
        msg = (MessageSource)ctx.getBean("messageSource");
        log.info(msg.getMessage("processstart",
                new Object[]{this.getProcessContext().getProcessName()},
                Locale.getDefault()));

        this.readerFactory = new ReaderFactory();
        this.reader = readerFactory.getReader("userReader");

        this.reader.setReadHandler(readHandler);

        this.reader.setURI(this.getProcessContext().getImportURL());

        try {
            List<User> users = (List<User>) reader.read();
            numberOfUsersRead = users.size();
        } catch (ReaderException e) {
            e.printStackTrace();
            log.severe(msg.getMessage("processreaderror",
                    new Object[]{this.getProcessContext().getProcessName()},
                    Locale.getDefault()));
        }
    }

    /**
     * Logs the what process is running to the message resources
     */
    @Override
    public void beforeProcess() {

        msg = (MessageSource)ctx.getBean("messageSource");
        log.info(msg.getMessage("processbefore",
                new Object[]{this.getProcessContext().getProcessName()},
                Locale.getDefault()));
    }

    /**
     * Logs how many Users where added to the database
     */
    @Override
    public void afterProcess() {

        msg = (MessageSource)ctx.getBean("messageSource");
        log.info(msg.getMessage("processstartdone",
                new Object[]{this.numberOfUsersRead},
                Locale.getDefault()));

    }
}
