package is.ru.honn.domain;

import java.util.List;


public class Video {

    private int videoId;
    private String title;
    private String description;
    private String source;
    private String videoType;
    private List<String> tags;

    public Video(int videoId, String title, String description, String source, String videoType, List<String> tags) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.source = source;
        this.videoType = videoType;
        this.tags = tags;
    }

    public void addTag(String tag){

        tags.add(tag);
    }

    public int getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public String getVideoType() {
        return videoType;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

}