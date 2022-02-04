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

public class Get_WebChat_Last_Session extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get WebChat Last Session 200")
    @Story("An Endpoint to Get WebChat Last Session 200")
    public void Get_WebChat_Last_Session_200() throws InterruptedException, IOException {
        Response response = POST_200(Get_WebChat_Last_Session_EndPoint, generateStringFromResource("./src/main/java/Payload/GetwebChatLastSession.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get WebChat Last Session 401")
    @Story("An Endpoint to Get WebChat Last Session 401")
    public void Get_WebChat_Last_Session_401() throws InterruptedException, IOException {
        Response response = POST_401(Get_WebChat_Last_Session_EndPoint, generateStringFromResource("./src/main/java/Payload/GetwebChatLastSession.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get WebChat Last Session 403")
    @Story("An Endpoint to Get WebChat Last Session 403")
    public void Get_WebChat_Last_Session_403() throws InterruptedException, IOException {
        Response response = POST_403(Get_WebChat_Last_Session_EndPoint, generateStringFromResource("./src/main/java/Payload/GetwebChatLastSession.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get WebChat Last Session 400")
    @Story("An Endpoint to Get WebChat Last Session 400")
    public void Get_WebChat_Last_Session_400() throws InterruptedException, IOException {
        Response response = POST_200(Get_WebChat_Last_Session_EndPoint, generateStringFromResource("./src/main/java/Payload/CreateUser.json"));
        response.prettyPeek().then().spec(responseSpec_400);
    }
}
