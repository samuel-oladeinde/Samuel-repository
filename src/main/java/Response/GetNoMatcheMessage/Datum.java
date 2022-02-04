package Response.GetNoMatcheMessage;

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

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("request")
    @Expose
    private String request;
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("user_id")
    @Expose
    private Object userId;
    @SerializedName("is_matched")
    @Expose
    private Integer isMatched;
    @SerializedName("match_date")
    @Expose
    private Object matchDate;
    @SerializedName("match_type")
    @Expose
    private Object matchType;
    @SerializedName("match_by")
    @Expose
    private Object matchBy;
    @SerializedName("agent_id")
    @Expose
    private Integer agentId;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("name")
    @Expose
    private String name;

}
