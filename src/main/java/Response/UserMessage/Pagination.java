package Response.UserMessage;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated("jsonschema2pojo")
class Pagination {

    @SerializedName("pagination")
    @Expose
    private Pagination__1 pagination;
    @SerializedName("data")
    @Expose
    private List<Object> data = null;
    @SerializedName("allSums")
    @Expose
    private AllSums allSums;

}

