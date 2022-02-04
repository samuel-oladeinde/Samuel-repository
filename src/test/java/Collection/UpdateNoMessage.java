package Collection;

import Base.TestBase;
import Response.SaveChannel.SaveChannelResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.KnowledgeBase_EndPoint;
import static pojo.Constant.Constant.UpDateNoMessage_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;
import static utility.Utility.generateStringFromResource;

public class UpdateNoMessage extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Number Message 200")
    @Story("An Endpoint to Update Number Message 200")
    public void UpdateNoMessage_200() throws InterruptedException, IOException {
        Response response = PUT_200(UpDateNoMessage_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateNoMessage.json"));

        response.prettyPeek().then().spec(responseSpec_200);
        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Message marked as resolved successfully");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Number Message 401")
    @Story("An Endpoint to Update Number Message 401")
    public void UpdateNoMessage_401() throws InterruptedException, IOException {
        Response response = PUT_401(UpDateNoMessage_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateNoMessage.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Update Number Message 403")
    @Story("An Endpoint to Update Number Message 403")
    public void UpdateNoMessage_403() throws InterruptedException, IOException {
        Response response = PUT_403(UpDateNoMessage_EndPoint, generateStringFromResource("./src/main/java/Payload/UpdateNoMessage.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}

