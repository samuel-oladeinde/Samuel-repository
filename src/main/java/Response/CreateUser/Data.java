package Response.CreateUser;

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
@Generated("jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("yob")
    @Expose
    private Object yob;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("meta")
    @Expose
    private String meta;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("is_deleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("agent_id")
    @Expose
    private Integer agentId;

}
