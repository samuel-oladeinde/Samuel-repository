package pojo;


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
public class LoginPojo {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password")
    @Expose
    private String password;

}