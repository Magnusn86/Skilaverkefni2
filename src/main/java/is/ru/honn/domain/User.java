package is.ru.honn.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple POJO class for Users in the application
 */
public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String displayName;
    private LocalDate birthDate;
    private List<Video> videos;

    //Constructor that sets all variables except the vides
    public User(int userId, String firstName, String lastName, String email, String displayName, String birthDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.displayName = displayName;
        this.birthDate = LocalDate.parse(birthDate);
        videos = new ArrayList<>();

    }
    public void setVideos(List<Video> videos){

        this.videos = videos;
    }

    public void addVideo(Video video) {
        this.videos.add(video);
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


}