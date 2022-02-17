package Collection.AutoAssign.LoginSession;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.GetLoggedinSessionUser_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetLoginSessionOfUser extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Login Session of User 200")
    @Story("An Endpoint to Get Login Session of User 200")
    public void GetLoginSessionOfUser_200() throws InterruptedException, IOException {
        Response response = GET_200(GetLoggedinSessionUser_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Login Session of User 401")
    @Story("An Endpoint to Get Login Session of User 401")
    public void GetLoginSessionOfUser_401() throws InterruptedException, IOException {
        Response response = GET_401(GetLoggedinSessionUser_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Login Session of User 403")
    @Story("An Endpoint to Get Login Session of User 403")
    public void GetLoginSessionOfUser_403() throws InterruptedException, IOException {
        Response response = GET_403(GetLoggedinSessionUser_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
