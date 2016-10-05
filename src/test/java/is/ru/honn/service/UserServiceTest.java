package is.ru.honn.service;

import is.ru.honn.domain.User;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.ServiceStubs.UserServiceStub;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Test the UserService for the following:
 *  Add user, first name, lastname and userId
 *  Add user that fails
 *  Get user that exists
 *  Check if getting a user that does not exists works correctly
 */
public class UserServiceTest extends TestCase {

    public User user1;
    public User user2;
    public UserServiceStub userServiceStub = new UserServiceStub();

    //User(int userId, String firstName, String lastName, String email, String displayName, String birthDate)

    public void setUp() throws Exception {
        super.setUp();
        user1 = new User(1, "jón", "jónsson", "jon@mbl.is", "Jón", "1990-01-01");
        user2 = new User(2, "jóna", "jónsdóttir", "jona@mbl.is", "Jóna", "1991-01-01");


    }


    public void testAddUser() throws Exception {

        int id = userServiceStub.addUser(user1);

        List<User> users = userServiceStub.getUsers();

        User newUser = null;
        for(User u : users) {
            if(u.getUserId() == id) {
                newUser = u;
                break;
            }
        }
        assertEquals(newUser.getUserId(), id);
        assertEquals(user1, newUser);

    }

    public void testGetUsers() throws Exception {

        userServiceStub.addUser(user2);

        List<User> users = userServiceStub.getUsers();

        int id = 2;
        for (User u : users) {
            assertEquals(u.getUserId(),id);
            id--;
        }
    }

    @Test
    public void testAddExistingUser() throws ServiceException {

        String message = null;
        try {
            userServiceStub.addUser(user1);
            userServiceStub.addUser(user1);
        } catch (ServiceException e) {
            message = e.getMessage();
        }
        assertEquals( "User already exists!", message);

    }

    @Test
    public void testGettingNonexistingUser() {

        User user = userServiceStub.getUser(1);

        assertEquals(null, user);
    }
}