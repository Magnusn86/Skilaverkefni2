package is.ru.honn.rutube.service;

import is.ru.honn.rutube.service.Exceptions.ServiceException;

import java.util.List;

/**
 * Created by Maggi on 21/09/16.
 */
public interface UserService
{
    int addUser(User user) throws ServiceException;
    List<User> getUsers();
}
