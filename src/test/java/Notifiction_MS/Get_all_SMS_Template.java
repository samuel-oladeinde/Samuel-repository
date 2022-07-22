package Notifiction_MS;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static pojo.Constant.Constant.Get_All_sms_template_EndPoint;
import static utility.RestCalls.*;

public class Get_all_SMS_Template extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User By Latest Message not Enrolled 200")
    @Story("An Endpoint to Get User By Latest Message not Enrolled 200")
    public void GetUser_By_Latest_Message_Not_Enrolled_200() throws InterruptedException, IOException {
        Response response = GET_200(Get_All_sms_template_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
        response.then().assertThat().body("content[0]", is(59));
        response.then().assertThat().body("name[0]", is(59));
    }
}
