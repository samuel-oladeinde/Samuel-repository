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

public class MessageReply extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Message Reply 200")
    @Story("An Endpoint to Message Reply 200")
    public void MessageReply_200() throws InterruptedException, IOException {
        Response response = POST_200(MessageReply_EndPoint, generateStringFromResource("./src/main/java/Payload/messagereply.json"));

        response.prettyPeek().then().spec(responseSpec_200);

        Assertions.assertEquals(response.path("status").toString(), "success");
        Assertions.assertEquals(response.path("data").toString(), "Message Sent Succesfully");

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Message Reply 401")
    @Story("An Endpoint to Message Reply 401")
    public void MessageReply_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateUser_EndPoint, generateStringFromResource("./src/main/java/Payload/messagereply.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Message Reply 403")
    @Story("An Endpoint to Message Reply 403")
    public void MessageReply_403() throws InterruptedException, IOException {
        Response response = POST_403(TriggerIntent_EndPoint, generateStringFromResource("./src/main/java/Payload/messagereply.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Message Reply 400")
    @Story("An Endpoint to Message Reply 400")
    public void MessageReply_400() throws InterruptedException, IOException {
        Response response = POST_200(TriggerIntent_EndPoint, generateStringFromResource("./src/main/java/Payload/messageReply400.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }
}
