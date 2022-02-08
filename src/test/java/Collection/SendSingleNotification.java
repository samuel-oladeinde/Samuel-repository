package Collection;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.*;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class SendSingleNotification extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Single Notification 200")
    @Story("An Endpoint to Send Single Notification 200")
    public void SendSingleNotification_200() throws InterruptedException, IOException {
        Response response = POST_200(SendSingleNotificationn, generateStringFromResource("./src/main/java/Payload/SendSingleNotification.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Message Sent");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Single Notification 401")
    @Story("An Endpoint to Send Single Notification 401")
    public void SendSingleNotification_401() throws InterruptedException, IOException {
        Response response = POST_401(SendSingleNotificationn, generateStringFromResource("./src/main/java/Payload/SendSingleNotification.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Single Notification 403")
    @Story("An Endpoint to send Single Notification 403")
    public void SendSingleNotification_403() throws InterruptedException, IOException {
        Response response = POST_403(SendSingleNotificationn, generateStringFromResource("./src/main/java/Payload/SendSingleNotification.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Single Notification 400")
    @Story("An Endpoint to Send Single Notification 400")
    public void SendSingleNotification_400() throws InterruptedException, IOException {
        Response response = POST_200(SendSingleNotificationn, generateStringFromResource("./src/main/java/Payload/SendSingleNotification.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertEquals(response.getStatusLine(), StatusLine_400);
    }
}
