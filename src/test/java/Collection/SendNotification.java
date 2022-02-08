package Collection;

import Base.TestBase;
import Response.SearchUser.SearchUserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.SearchUser_EndPoint;
import static pojo.Constant.Constant.SendNotification_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class SendNotification extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 200")
    @Story("An Endpoint to Send Notification 200")
    public void SendNotification_200() throws InterruptedException, IOException {
        Response response = POST_200(SendNotification_EndPoint, generateStringFromResource("./src/main/java/Payload/sendNotificationPayload.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Message Sent");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 401")
    @Story("An Endpoint to Send Notification 401")
    public void SendNotification_401() throws InterruptedException, IOException {
        Response response = POST_401(SearchUser_EndPoint, generateStringFromResource("./src/main/java/Payload/sendNotificationPayload.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 403")
    @Story("An Endpoint to send Notification 403")
    public void SendNotification_403() throws InterruptedException, IOException {
        Response response = POST_403(SearchUser_EndPoint, generateStringFromResource("./src/main/java/Payload/sendNotificationPayload.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Notification 400")
    @Story("An Endpoint to Send Notification 400")
    public void SendNotification_400() throws InterruptedException, IOException {
        Response response = POST_200(SendNotification_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchUser.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertEquals(response.getStatusLine(), StatusLine_400);
    }
}
