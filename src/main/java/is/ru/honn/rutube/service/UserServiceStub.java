package is.ru.honn.rutube.service;

import is.ru.honn.rutube.service.Exceptions.ServiceException;

import java.util.List;

/**
 * Created by Maggi on 21/09/16.
 */
public class UserServiceStub implements UserService {

    public int addUser(User user) throws ServiceException {
        return 0;
    }

    public List<User> getUsers() {
        return null;
    }
}
