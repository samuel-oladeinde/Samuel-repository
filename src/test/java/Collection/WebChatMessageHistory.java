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
import static pojo.Constant.Constant.SetUPTemplate_EndPoint;
import static pojo.Constant.Constant.webchatmessageHistory_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class WebChatMessageHistory extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to WebChat Message History 200")
    @Story("An Endpoint to WebChat Message History 200")
    public void WebChatMessageHistory_200() throws InterruptedException, IOException {
        Response response = POST_200(webchatmessageHistory_EndPoint, generateStringFromResource("./src/main/java/Payload/webchatmessageHistory.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to WebChat Message History 401")
    @Story("An Endpoint to WebChat Message History 401")
    public void WebChatMessageHistory_401() throws InterruptedException, IOException {
        Response response = POST_401(webchatmessageHistory_EndPoint, generateStringFromResource("./src/main/java/Payload/webchatmessageHistory.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to WebChat Message History 403")
    @Story("An Endpoint to WebChat Message History 403")
    public void SetUp_WebChatMessageHistory_403() throws InterruptedException, IOException {
        Response response = POST_403(webchatmessageHistory_EndPoint, generateStringFromResource("./src/main/java/Payload/webchatmessageHistory.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to WebChat Message History 400")
    @Story("An Endpoint to WebChat Message History 400")
    public void WebChatMessageHistory_400() throws InterruptedException, IOException {
        Response response = POST_200(webchatmessageHistory_EndPoint, generateStringFromResource("./src/main/java/Payload/AddPhrase.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }
}
