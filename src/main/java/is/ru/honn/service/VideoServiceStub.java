package is.ru.honn.service;


import is.ru.honn.service.Exceptions.ServiceException;

import java.util.List;

/**
 * Created by Maggi on 21/09/16.
 */
public class VideoServiceStub implements VideoService {

    public Video getVideo(int videoId) {
        return null;
    }
    public List<Video> getVideosbyUser(int userId) {
        return null;
    }
    public int addVideo(Video video, int userId) throws ServiceException {
        return 0;
    }
}
