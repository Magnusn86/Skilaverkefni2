package is.ru.honn.service;

import is.ru.honn.domain.Video;
import is.ru.honn.service.Exceptions.ServiceException;

import java.util.List;

/**
 * A interface to add Videos to database has to use the UserService to be able to add videos to users.
 */
public interface VideoService
{
    /**
     * Gets a video by ID
     * @param videoId the ID of the video to retrieve
     * @return the video with the ID
     */
    Video getVideo(int videoId);

    /**
     * Gets all the videos for the given user
     * @param userId the Id of the user to get all the videos from
     * @return a list of videos from the given user
     */
    List<Video> getVideosbyUser(int userId);

    /**
     * Adds a video to the user and the video database
     * @param video the video to be added
     * @param userId the id of the user which owns the video
     * @return the id of the video
     * @throws ServiceException
     */
    int addVideo(Video video, int userId) throws ServiceException;
}
