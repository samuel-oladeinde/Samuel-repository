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
import static pojo.Constant.Constant.SendTemplateMessageOnly_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class SendTemplateMessageOnly extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Template Message Only 200")
    @Story("An Endpoint to Send Template Message Only 200")
    public void SendTemplateMessageOnly_200() throws InterruptedException, IOException {
        Response response = POST_200(SendTemplateMessageOnly_EndPoint, generateStringFromResource("./src/main/java/Payload/SendMessageTemplateMessageOnly.json"));
        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data[0]").toString(), "webchat - Platform not available");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Template Message Only 401")
    @Story("An Endpoint to Send Template Message Only 401")
    public void SendTemplateMessageOnly_401() throws InterruptedException, IOException {
        Response response = POST_401(SendTemplateMessageOnly_EndPoint, generateStringFromResource("./src/main/java/Payload/SendMessageTemplateMessageOnly.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Template Message Only 403")
    @Story("An Endpoint to Send Template Message Only 403")
    public void SendTemplateMessageOnly_403() throws InterruptedException, IOException {
        Response response = POST_403(SendTemplateMessageOnly_EndPoint, generateStringFromResource("./src/main/java/Payload/SendMessageTemplateMessageOnly.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Send Template Message Only 400")
    @Story("An Endpoint to Send Template Message Only 400")
    public void SendTemplateMessageOnly_400() throws InterruptedException, IOException {
        Response response = POST_200(SendTemplateMessageOnly_EndPoint, generateStringFromResource("./src/main/java/Payload/SearchUser.json"));
        Assertions.assertEquals(response.prettyPeek().getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertEquals(response.getStatusLine(), StatusLine_400);
    }
}
