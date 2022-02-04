package Response.UserMessage;

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
public class AllSums {

    @SerializedName("delivered")
    @Expose
    private Integer delivered;
    @SerializedName("failed")
    @Expose
    private Integer failed;
    @SerializedName("pending")
    @Expose
    private Integer pending;
    @SerializedName("sent")
    @Expose
    private Integer sent;
    @SerializedName("total")
    @Expose
    private Integer total;

}
