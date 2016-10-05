package is.ru.honn.Observer;

import is.ru.honn.domain.User;

/**
 * Watches the UserServiceStub, if a User is added it is printed out to console.
 */
public class UserObserver implements Observer {

    /**
     * Prints Out if a user is added as well as basc information such as userId, userName
     * @param object the object is the User that is added,  isused to print out information about the newly added User
     */
    @Override
    public void notifyAdded(Object object) {
        System.out.println("New user added: ");
        System.out.println("User ID: " + ((User) object).getUserId() + ", Name: " + ((User) object).getFirstName() + " " + ((User) object).getLastName());


    }
}
