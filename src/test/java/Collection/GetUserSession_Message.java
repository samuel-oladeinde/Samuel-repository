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
import static utility.RestCalls.RESPONSE_STATUS_CODE_400;

public class GetUserSession_Message extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Message 200")
    @Story("An Endpoint to Get User Session_Message 200")
    public void GetUserSession_Message_200() throws InterruptedException, IOException {
        Response response = GET_200(GetUserSessionMessage_EndPoint);

        GetChannelResponse ResponsePojo = response.prettyPeek().then().spec(responseSpec_200)
                .extract()
                .as(GetChannelResponse.class);

        Assertions.assertEquals(ResponsePojo.getStatus(), "success");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Message 401")
    @Story("An Endpoint to Get User Session_Message 401")
    public void GetUserSession_Message_401() throws InterruptedException, IOException {
        Response response = GET_401(GetUserSessionMessage_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Message 403")
    @Story("An Endpoint to Get User Session_Message 403")
    public void GetUserSession_Message_403() throws InterruptedException, IOException {
        Response response = GET_403(GetUserSessionMessage_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Session_Message 404")
    @Story("An Endpoint to Get User Session_Message 404")
    public void GetUserSession_Message_404() throws InterruptedException, IOException {
        Response response = GET_200(GetUserSessionMessage404_EndPoint).prettyPeek();
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_404);
    }

}
