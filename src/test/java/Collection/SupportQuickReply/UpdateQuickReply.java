package Collection.SupportQuickReply;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

import static pojo.Constant.Constant.UpDateNoMessage_EndPoint;
import static pojo.Constant.Constant.UpdateQuickReply_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class UpdateQuickReply extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Quick Reply 200")
    @Story("An Endpoint to Update Quick Reply 200")
    public void UpdateQuickReply_200() throws InterruptedException, IOException {
        Response response = PUT_200(UpdateQuickReply_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateQuickReply.json"));

        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Message marked as resolved successfully");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Quick Reply 401")
    @Story("An Endpoint to Update Quick Reply 401")
    public void UpdateQuickReply_401() throws InterruptedException, IOException {
        Response response = PUT_401(UpdateQuickReply_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateNoMessage.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Quick Reply 403")
    @Story("An Endpoint to Update Quick Reply 403")
    public void UpdateQuickReply_403() throws InterruptedException, IOException {
        Response response = PUT_403(UpdateQuickReply_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateNoMessage.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
