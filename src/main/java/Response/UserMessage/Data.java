package Response.UserMessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("data")
    @Expose
    private List<Object> data = null;

}
