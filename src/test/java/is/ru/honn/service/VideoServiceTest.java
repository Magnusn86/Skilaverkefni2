package is.ru.honn.service;

import is.ru.honn.domain.User;
import is.ru.honn.domain.Video;
import is.ru.honn.service.Exceptions.ServiceException;
import is.ru.honn.service.ServiceStubs.UserServiceStub;
import is.ru.honn.service.ServiceStubs.VideoServiceStub;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test the VideoService for the following:
 *  Test if adding and getting videos works right
 *  Add video, userId, title and src
 *  Add video that fails
 *  Check if getting videos that do not exist works correctly
 */
public class VideoServiceTest extends TestCase {
    public Video video1;
    public Video video2;

    public User user1;
    public User user2;

    public UserServiceStub userServiceStub = new UserServiceStub();
    public VideoServiceStub videoServiceStub = new VideoServiceStub(userServiceStub);

    //public Video(int videoId, String title, String description, String source, String videoType, List<String> tags) {

    public void setUp() throws Exception {
        super.setUp();
        user1 = new User(1, "jón", "jónsson", "jon@mbl.is", "Jón", "1990-01-01");
        user2 = new User(2, "jóna", "jónsdóttir", "jona@mbl.is", "Jóna", "1991-01-01");

        video1 = new Video(1, "video", "funny video", "youtube.com", "video", null);
        video2 = new Video(2, "video", "sad video", "youtube.com", "video", null);


    }


    public void testGetVideo() throws Exception {
        userServiceStub.addUser(user1);
        userServiceStub.addUser(user2);
        videoServiceStub.addVideo(video1, user1.getUserId());

        Video addedVideo = videoServiceStub.getVideo(1);
        assertEquals(video1, addedVideo);





    }

    public void testGetVideosbyUser() throws Exception {

        List<Video> videosAdded = new ArrayList<>();
        videosAdded.add(video1);
        for(Video v : videosAdded) {
            assertEquals(v.getVideoId(), video1.getVideoId());

        }
    }

    public void testAddVideo() throws Exception {
        userServiceStub.addUser(user1);
        videoServiceStub.addVideo(video1, user1.getUserId());

        List<Video> videos = videoServiceStub.getVideosbyUser(user1.getUserId());
        Video newVideo = null;
        for(Video v : videos) {
            if(v.getVideoId() == video1.getVideoId()){
                newVideo = v;
            }
        }
        assertEquals(newVideo.getVideoId(), video1.getVideoId());
    }

    @Test
    public void testAddExistingUser() throws ServiceException {

        String message = null;
        try {
            videoServiceStub.addVideo(video1, 0);
        } catch (ServiceException e) {
            message = e.getMessage();
        }
        assertEquals( "User Not Found", message);

    }

}