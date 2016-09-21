package is.ru.honn.rutube.service;

import java.util.Date;
import java.util.List;

/**
 * Created by Maggi on 21/09/16.
 */
public class User {

    public int userId;
    public String firstName;
    public String lastName;
    public String email;
    public String displayName;
    public Date birthDate;
    public List<Video> videos;

}
