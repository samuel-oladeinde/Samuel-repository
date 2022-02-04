package Collection;

import Base.TestBase;
import Response.GetChannel.GetChannelResponse;
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
import static utility.RestCalls.RESPONSE_STATUS_CODE_404;

public class GetUserSessionWebhook extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Webhook 200")
    @Story("An Endpoint to Get User Session_Webhook 200")
    public void GetUserSessionWebhook_200() throws InterruptedException, IOException {
        Response response = GET_200(GetUserSessionWebhookEndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Webhook 401")
    @Story("An Endpoint to Get User Session_Webhook 401")
    public void GetUserSessionWebhook_401() throws InterruptedException, IOException {
        Response response = GET_401(GetUserSessionWebhookEndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Webhook 403")
    @Story("An Endpoint to Get User Session_Webhook 403")
    public void GetUserSessionWebhook_403() throws InterruptedException, IOException {
        Response response = GET_403(GetUserSessionWebhookEndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Webhook 400")
    @Story("An Endpoint to Get User Session_Webhook 400")
    public void GetUserSessionWebhook_400() throws InterruptedException, IOException {
        Response response = GET_200(GetUserSessionWebhookEndPointt).prettyPeek();
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_404);
    }
}
