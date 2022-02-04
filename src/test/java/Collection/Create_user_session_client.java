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
import static pojo.Constant.Constant.CreateUser_Session_EndPoint;
import static utility.RestCalls.*;
import static utility.Utility.generateStringFromResource;

public class Create_user_session_client extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create user session client")
    @Story("An Endpoint to Create user session client")
    public void Create_user_session_client_200() throws InterruptedException, IOException {
        Response response = POST_200(CreateUser_Session_EndPoint, generateStringFromResource("./src/main/java/Payload/Create_User_SessionClient.json"));
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create user session client 401")
    @Story("An Endpoint to Create user session client 401")
    public void Create_user_session_client_401() throws InterruptedException, IOException {
        Response response = POST_401(CreateUser_Session_EndPoint, generateStringFromResource("./src/main/java/Payload/Create_User_SessionClient.json"));
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Create user session client 403")
    @Story("An Endpoint to Create user session client 403")
    public void Create_user_session_client_403() throws InterruptedException, IOException {
        Response response = POST_403(CreateUser_Session_EndPoint, generateStringFromResource("./src/main/java/Payload/Create_User_SessionClient.json"));
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
