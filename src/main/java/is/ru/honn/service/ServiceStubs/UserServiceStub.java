package is.ru.honn.service.ServiceStubs;

import is.ru.honn.Observer.Observer;
import is.ru.honn.Observer.UserObserver;
import is.ru.honn.domain.User;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Saves the Users to an ArrayList which is the "database" in this case
 */
public class UserServiceStub implements UserService {

    //List of observers to notify if a record is added
    private ArrayList<Observer> observers;
    //The list of all the users
    private List<User> users;

    /**
     * Default constructor creates a new ArrayList to hold the Users and adds a UserObserver to the list of observers
     */
    public UserServiceStub() {

        users = new ArrayList<>();
        observers = new ArrayList<>();
        observers.add(new UserObserver());
    }

    /**
     * Adds a user to the ArrayList
     * @param user the user to be added
     * @return the user id of the user that was added
     * @throws ServiceException is thrown if the user already exists
     */
    public int addUser(User user) throws ServiceException {
        for(User u : users) {
            if(u.getUserId() == user.getUserId())
                throw new ServiceException("User already exists!");
        }
        users.add(user);
        notifyObservers(user);

        return user.getUserId();
    }

    /**
     * Gets a user with the given userId
     * @param userId the ID of the user to be retrieved
     * @return the user if found else null
     */
    public User getUser(int userId) {
        for(User u : users) {
            if(u.getUserId() == userId)
                return u;
        }
        return null;
    }

    public List<User> getUsers() {

        return users;
    }

    /**
     * Adds a new observer to be notified if records are added
     * @param observer the new observer to be added
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes the observer
     * @param observer the observer to be removed
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * notifies all the observers if a record is added
     * @param object is the object that was added to the database
     */
    public void notifyObservers(Object object) {
        for(Observer o : observers) {
            o.notifyAdded(object);
        }
    }
}
