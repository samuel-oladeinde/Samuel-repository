package Response.GetChannel;

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
public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("created_At")
    @Expose
    private String createdAt;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("user_id")
    @Expose
    private Object userId;

}
