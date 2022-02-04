package pojo;

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
public class loginPojo {

    @SerializedName("loginId")
    @Expose
    private String loginId;

    @SerializedName("password")
    @Expose
    private String password;
}
