package pojo.doctor_signup_form;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Signup_doctor_Request {

private List<String> Emails;
}
