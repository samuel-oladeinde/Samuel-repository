package Notifiction_MS;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.Update_sms_template_EndPoint;
import static pojo.PayloadManager.Update_SMS_Template_Payload;
import static utility.RestCalls.*;

public class Update_SMS_Template extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure that SMS Template can be updated using ID with a status code of 200")
    @Story("An Endpoint to Update SMS Template")
    public void Update_SMS_Template() throws InterruptedException, IOException {
        Response response = PUT_200(Update_sms_template_EndPoint, Update_SMS_Template_Payload());
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
    }
}
