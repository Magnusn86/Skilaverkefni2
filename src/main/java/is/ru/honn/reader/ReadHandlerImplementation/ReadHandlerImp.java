package is.ru.honn.reader.ReadHandlerImplementation;

import is.ru.honn.domain.User;
import is.ru.honn.reader.ReadHandler;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.ServiceStubs.UserServiceStub;
import is.ru.honn.service.ServiceStubs.VideoServiceStub;

import java.util.List;

/**
 * The implementation of ReadHandler to read the Users and videos from the JSON file / URI
 */
public class ReadHandlerImp implements ReadHandler {

    UserServiceStub userServiceStub;
    VideoServiceStub videoServiceStub;
    public ReadHandlerImp() {
        this.userServiceStub = new UserServiceStub();
        this.videoServiceStub = new VideoServiceStub(userServiceStub);
    }


    /**
     * Adds the objects from the parameter from the functions and saves them to the "database"
     * in this case that is the appropriate service. This function is called from AbstractReader function read()
     *
     * @param count number of objects in the object parameter
     * @param object is the object to add to the database
     */
    public void read(int count, Object object) {


        List<User> users;

        users = (List<User>) object;


        for(User u : users) {
            try {
                userServiceStub.addUser(u);
            } catch (ServiceException e ) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

    }


    public static void main(String args[]){

    }
}

