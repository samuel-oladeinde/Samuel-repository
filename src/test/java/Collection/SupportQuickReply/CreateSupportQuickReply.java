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
import static pojo.Constant.Constant.CreatQuickReply_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class CreateSupportQuickReply extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Support Quick Reply Base")
    @Story("An Endpoint to Create Support Quick Reply Base")
    public void CreateSupportQuickReply_200() throws InterruptedException, IOException {
        Response response = POST_200(CreatQuickReply_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateQuickReply.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create User Base 401")
    @Story("An Endpoint to Create User Base 401")
    public void CreateSupportQuickReply_401() throws InterruptedException, IOException {
        Response response = POST_401(CreatQuickReply_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateQuickReply.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create Support Quick Reply 403")
    @Story("An Endpoint to Create Support Quick Reply 403")
    public void CreateSupportQuickReply_403() throws InterruptedException, IOException {
        Response response = POST_403(CreatQuickReply_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateQuickReply.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
