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
import static pojo.Constant.Constant.GetActiveAgentSupport_EndPoint;
import static pojo.Constant.Constant.SupportQuickReplyList_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class SupportQuickReplyList extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Support Quick Reply List 200")
    @Story("An Endpoint to Get Support Quick Reply List 200")
    public void SupportQuickReplyList_200() throws InterruptedException, IOException {
        Response response = GET_200(SupportQuickReplyList_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Support Quick Reply List 401")
    @Story("An Endpoint to Get Support Quick Reply List 401")
    public void SupportQuickReplyList_401() throws InterruptedException {
        Response response = GET_401(SupportQuickReplyList_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Support Quick Reply List 403")
    @Story("An Endpoint to Get Support Quick Reply List 403")
    public void SupportQuickReplyList_403() throws InterruptedException, IOException {
        Response response = GET_403(SupportQuickReplyList_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

}
