package album.dto;

public class Album {
    private int imageid;
    private String imagepath;
    private String comment;
    private String location;
    private String tag;
    
    /**
     * Constructor
     */
    public Album() {
        this.imageid = -1;
        this.imagepath = "";
        this.comment = "";
        this.location = "";
        this.tag = "";
    }
    
    /**
     * @return the imageid
     */
    public int getImageid() {
        return imageid;
    }
    
    /**
     * @param imageid the imageid to set
     */
    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
    
    /**
     * @return the imagepath
     */
    public String getImagepath() {
        return imagepath;
    }
    
    /**
     * @param imagepath the imagepath to set
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
    
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * @return the tag
     */
    public String getTag() {
        return tag;
    }
    
    /**
     * @param tag the tag to set
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
