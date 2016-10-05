package is.ru.honn.service;

import is.ru.honn.domain.User;
import is.ru.honn.service.Exceptions.ServiceException;

import java.util.List;

/**
 * A interface for adding Users to database, retrieving saved objects in the database
 */
public interface UserService
{
    /**
     * Adds the user given as a parameter to the database
     * @param user the user to be added
     * @return returns the userId of the user added
     * @throws ServiceException if the user already exists the exception is thrown
     */
    int addUser(User user) throws ServiceException;

    /**
     * Gets all the users in the database and returns them
     * @return all users in the database
     */
    List<User> getUsers();

    /**
     * Gets a user by user ID
     * @param userId the ID of the user to be retrieved
     * @return the user with the given Id
     */
    User getUser(int userId);
}
