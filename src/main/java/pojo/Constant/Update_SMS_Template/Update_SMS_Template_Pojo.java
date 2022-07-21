package pojo.Constant.Update_SMS_Template;

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
public class Update_SMS_Template_Pojo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("name")
    @Expose
    private String name;
}