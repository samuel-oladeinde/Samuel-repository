package Response.Send_SMS_Single_User_Response;

 import javax.annotation.processing.Generated;
 import com.google.gson.annotations.Expose;
 import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("media")
    @Expose
    private String media;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("template")
    @Expose
    private Object template;
    @SerializedName("hasAttachment")
    @Expose
    private Boolean hasAttachment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Object getTemplate() {
        return template;
    }

    public void setTemplate(Object template) {
        this.template = template;
    }

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }
}
