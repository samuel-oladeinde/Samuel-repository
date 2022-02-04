package Response.GetUserEnrolled;

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
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("profile_photo")
    @Expose
    private Object profilePhoto;

}
