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
    @Description("An Endpoint to Get all SMS template when a valid authorization is provided")
    @Story("Ensure that a user is able to get all SMS Template")
    public void Get_All_SMS_Template() throws InterruptedException, IOException {
        Response response = GET_200(Get_All_sms_template_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
        response.then().assertThat().body("content[0]", is(" Welcome to bamti {firstname} {LastName}"));
        response.then().assertThat().body("name[0]", is("welcome you all"));
        response.then().assertThat().body("id[0]", is(5));
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get all SMS template when a valid authorization is provided")
    @Story("Ensure that a user is able to get all SMS Template")
    public void Get_All_SMS_Template_Invalid_Authorization() throws InterruptedException, IOException {
        Response response = GET_401(Get_All_sms_template_EndPoint);
        response.prettyPeek().then().spec(responseSpec_403);
    }
}
