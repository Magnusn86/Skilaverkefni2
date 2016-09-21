package is.ru.honn.rutube.service;

import java.net.URL;
import java.util.List;

/**
 * Created by Maggi on 21/09/16.
 */
public class Video {

    public int videoId;
    public String title;
    public String description;
    //ATH hvort hægt er að nota URL í stað String
    public String src;
    public String type;
    public List<String> tags;

}
