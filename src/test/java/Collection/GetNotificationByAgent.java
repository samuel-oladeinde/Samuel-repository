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
import static pojo.Constant.Constant.GetLocation_EndPoint;
import static pojo.Constant.Constant.GetNotification_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetNotificationByAgent extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Notification By Agent 200")
    @Story("An Endpoint to Get Notification By Agent 200")
    public void GetNotificationByAgent_200() throws InterruptedException, IOException {
        Response response = GET_200(GetNotification_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Notification By Agent 401")
    @Story("An Endpoint to get Get Notification By Agent 401")
    public void GetNotificationByAgent_401() throws InterruptedException {
        Response response = GET_401(GetNotification_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Notification By Agent 403")
    @Story("An Endpoint to Get Notification By Agent 403")
    public void GetNotificationByAgent_403() throws InterruptedException, IOException {
        Response response = GET_403(GetNotification_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
