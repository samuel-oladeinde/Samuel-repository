package Response.Get_All_SMS_Template;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.annotation.processing.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("jsonschema2pojo")
public class Get_All_SMS_Template_Response {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 1988994632159112632L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
