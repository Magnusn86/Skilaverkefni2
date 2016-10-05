package is.ru.honn.Observer;

import is.ru.honn.domain.User;
import is.ru.honn.domain.Video;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.ServiceStubs.UserServiceStub;
import is.ru.honn.service.ServiceStubs.VideoServiceStub;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test that the Observer works for Users
 */
public class UserObserverTest extends TestCase {

    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public UserServiceStub userServiceStub = new UserServiceStub();
    public VideoServiceStub videoServiceStub = new VideoServiceStub(userServiceStub);

    public User user1 = new User(1, "jón", "jónsson", "jon@mbl.is", "Jón", "1990-01-01");
    public User user2 = new User(2, "jóna", "jónsdóttir", "jona@mbl.is", "Jóna", "1991-01-01");

    protected void setUp() {

        System.setOut(new PrintStream(outContent));
    }

    /**
     * Check that the observer prints out the newly added user
     */
    @Test
    public void testAddingUser() {
        try {
            userServiceStub.addUser(user1);

        } catch (ServiceException e) {
            assertEquals(0,1);
        }
        assertEquals("New user added: \nUser ID: "+ user1.getUserId()+ ", Name: " + user1.getFirstName() + " " + user1.getLastName() + "\n",
                outContent.toString());
        System.setOut(null);
    }
}