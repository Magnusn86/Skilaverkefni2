package is.ru.honn.service.ServiceStubs;


import is.ru.honn.domain.User;
import is.ru.honn.domain.Video;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.ServiceFactories.ServiceStubFactory;
import is.ru.honn.service.VideoService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maggi on 21/09/16.
 */
public class VideoServiceStub implements VideoService {


    private ServiceStubFactory _serviceStubFactory = new ServiceStubFactory();
    private UserServiceStub userServiceStub = _serviceStubFactory.getUserServiceStub();
    private List<Video> videos = new ArrayList<>();

    public VideoServiceStub() {}

    public Video getVideo(int videoId) {

        for (Video video : videos) {
            if (video.getVideoId() == videoId) {
                return video;
            }
        }
        return null;
    }

    public List<Video> getVideosbyUser(int userId) {

        for (User user : userServiceStub.getUsers()) {
            if(user.getUserId() == userId) {
                return user.getVideos();
            }
        }
        return null;
    }

    public int addVideo(Video video, int userId) throws ServiceException {

        for (User user : userServiceStub.getUsers()) {
            if(user.getUserId() == userId) {
                user.addVideo(video);
                videos.add(video);
                return video.getVideoId();
            }
        }
        throw new ServiceException("User Not Found");
    }

}
