package is.ru.honn.service.ServiceStubs;

import is.ru.honn.domain.User;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maggi on 21/09/16.
 */
public class UserServiceStub implements UserService {

    private List<User> users;

    public UserServiceStub() {
        users = new ArrayList<>();
    }

    public int addUser(User user) throws ServiceException {
        for(User u : users) {
            if(u.getUserId() == user.getUserId())
                throw new ServiceException("User already exists!");
        }
        users.add(user);
        return user.getUserId();
    }

    public List<User> getUsers() {

        return users;
    }
}
