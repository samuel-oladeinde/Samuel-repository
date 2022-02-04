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
import static pojo.Constant.Constant.GetQueueList_EndPoint;
import static pojo.Constant.Constant.GetServicePag_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetQueueList_Support extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Queue List Support 200")
    @Story("An Endpoint to Get Queue List Support 200")
    public void GetQueueList_Support_200() throws InterruptedException, IOException {
        Response response = GET_200(GetQueueList_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Queue List Support 401")
    @Story("An Endpoint to Get Queue List Support 401")
    public void GetQueueList_Support_401() throws InterruptedException {
        Response response = GET_401(GetQueueList_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Queue List Support 403")
    @Story("An Endpoint to Get Queue List Support 403")
    public void GetQueueList_Support_403() throws InterruptedException, IOException {
        Response response = GET_403(GetQueueList_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
