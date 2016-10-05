package is.ru.honn.service.ServiceStubs;


import is.ru.honn.domain.User;
import is.ru.honn.domain.Video;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.VideoService;

import java.util.List;

/**
 * A class that saves instances of Videos and adds them to the UserService as well
 */
public class VideoServiceStub implements VideoService {

    private UserServiceStub userServiceStub;

    public VideoServiceStub(UserServiceStub userServiceStub) { this.userServiceStub = userServiceStub; }

    /**
     * Gets a single instance of a Video by it's ID returns null if a video with the ID does not exist
     * @param videoId The ID of the video to retrieve
     * @return returns the video with the ID requested
     */
    public Video getVideo(int videoId) {

        for(User u : userServiceStub.getUsers()) {
            for (Video video : u.getVideos()) {
                if (video.getVideoId() == videoId) {
                    return video;
                }
            }
        }

        return null;
    }

    /**
     * Gets all the videos that the user with the particular user ID returns null if the user does not exist
     * @param userId the ID of the user to retrieve the videos from
     * @return returns a list of videos for the particular user and null if user does not exist
     */
    public List<Video> getVideosbyUser(int userId) {

        for (User user : userServiceStub.getUsers()) {
            if(user.getUserId() == userId) {
                return user.getVideos();
            }
        }
        return null;
    }

    /**
     * Adds a video to the video list as well as it adds the video to the user in the User Service with the userId
     * in question, throws Service Exception if the user does not exist
     * @param video the video to add to the list of videos
     * @param userId the user Id of the user to add the video to
     * @return returns the video Id that was added
     * @throws ServiceException if user does not exist this exception is thrown
     */
    public int addVideo(Video video, int userId) throws ServiceException {

        for (User user : userServiceStub.getUsers()) {
            if(user.getUserId() == userId) {
                user.addVideo(video);
                return video.getVideoId();
            }
        }
        throw new ServiceException("User Not Found");
    }


}
