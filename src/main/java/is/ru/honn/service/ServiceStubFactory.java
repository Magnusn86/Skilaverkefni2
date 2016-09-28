package is.ru.honn.service;

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
