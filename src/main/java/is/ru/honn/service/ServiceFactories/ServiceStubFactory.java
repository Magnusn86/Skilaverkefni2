package is.ru.honn.service.ServiceFactories;

import is.ru.honn.service.ServiceStubs.UserServiceStub;
import is.ru.honn.service.ServiceStubs.VideoServiceStub;

/**
 * Created by Maggi on 28/09/16.
 */
public class ServiceStubFactory {

    private static UserServiceStub userServiceStub = new UserServiceStub();
    private static VideoServiceStub videoServiceStub = new VideoServiceStub();

    public ServiceStubFactory(){}

    public UserServiceStub getUserServiceStub() {
        return userServiceStub;
    }

    public VideoServiceStub getVideoServiceStub() {
        return videoServiceStub;
    }

}
