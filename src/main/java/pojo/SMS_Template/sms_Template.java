package pojo.SMS_Template;

import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Generated("jsonschema2pojo")
public class sms_Template {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("content")
    @Expose
    private String content;
}