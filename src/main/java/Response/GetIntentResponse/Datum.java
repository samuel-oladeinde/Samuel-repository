package Response.GetIntentResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("identifier")
    @Expose
    private Object identifier;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("agent_id")
    @Expose
    private Integer agentId;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("has_followup")
    @Expose
    private Integer hasFollowup;
    @SerializedName("process_agent")
    @Expose
    private String processAgent;
    @SerializedName("show_quick_reply")
    @Expose
    private Integer showQuickReply;
    @SerializedName("is_support")
    @Expose
    private Object isSupport;
}
