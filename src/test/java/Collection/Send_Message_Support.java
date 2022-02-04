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
import static pojo.Constant.Constant.SendMessageSupport_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class Send_Message_Support extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Message Support 200")
    @Story("An Endpoint to Send Message Support 200")
    public void Send_Message_Support_200() throws InterruptedException, IOException {
        Response response = PUT_200(SendMessageSupport_EndPoint, generateStringFromResource("./src/main/java/Payload/Send_Message_Support.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Service Updated Successfully");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Message Support 401")
    @Story("An Endpoint to Send Message Support 401")
    public void Send_Message_Support_401() throws InterruptedException, IOException {
        Response response = POST_401(SendMessageSupport_EndPoint, generateStringFromResource("./src/main/java/Payload/Send_Message_Support.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Message Support 403")
    @Story("An Endpoint to Send Message Support 403")
    public void Send_Message_Support_403() throws InterruptedException, IOException {
        Response response = POST_403(SendMessageSupport_EndPoint, generateStringFromResource("./src/main/java/Payload/Send_Message_Support.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Message Support 404")
    @Story("An Endpoint to Send Message Support 404")
    public void Send_Message_Support_404() throws InterruptedException, IOException {
        Response response = PUT_200(SendMessageSupport_EndPoint, generateStringFromResource("./src/main/java/Payload/Send_Message_Support.json"));
        response.prettyPeek().then().spec(responseSpec_404);
    }
}
