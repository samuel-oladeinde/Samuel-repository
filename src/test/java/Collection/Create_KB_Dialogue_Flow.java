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
import static pojo.Constant.Constant.Create_KB_Dialogue_Flow_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class Create_KB_Dialogue_Flow extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create KB Dialogue Flow")
    @Story("An Endpoint to Create KB Dialogue Flow")
    public void Create_KB_Dialogue_Flow_200() throws InterruptedException, IOException {
        Response response = POST_200(Create_KB_Dialogue_Flow_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKB_Dialogue.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create KB Dialogue Flow 401")
    @Story("An Endpoint to Create KB Dialogue Flow 401")
    public void Create_KB_Dialogue_Flow_401() throws InterruptedException, IOException {
        Response response = POST_401(Create_KB_Dialogue_Flow_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKB_Dialogue.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create KB Dialogue Flow 403")
    @Story("An Endpoint to Create KB Dialogue Flow 403")
    public void Create_KB_Dialogue_Flow_403() throws InterruptedException, IOException {
        Response response = POST_403(Create_KB_Dialogue_Flow_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateKB_Dialogue.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
