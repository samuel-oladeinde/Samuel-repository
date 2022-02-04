package Response.SearchUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.annotation.processing.Generated;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("user_code")
    @Expose
    private String userCode;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("agent_id")
    @Expose
    private Integer agentId;
    @SerializedName("last_seen")
    @Expose
    private String lastSeen;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("current_mode")
    @Expose
    private String currentMode;
    @SerializedName("profile_photo")
    @Expose
    private Object profilePhoto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

}
