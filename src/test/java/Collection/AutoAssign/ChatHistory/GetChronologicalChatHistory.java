package Collection.AutoAssign.ChatHistory;

import Base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import java.io.IOException;
import static pojo.Constant.Constant.GetChronologicalChatHistory_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetChronologicalChatHistory extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Chronological Chat History  200")
    @Story("An Endpoint to Get Chronological Chat History 200")
    public void GetChronologicalChatHistory_200() throws InterruptedException, IOException {
        Response response = GET_200(GetChronologicalChatHistory_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Chronological Chat History 401")
    @Story("An Endpoint to Get Chronological Chat History 401")
    public void GetChronologicalChatHistory_401() throws InterruptedException, IOException {
        Response response = GET_401(GetChronologicalChatHistory_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Chronological Chat History 403")
    @Story("An Endpoint to Get Chronological Chat History 403")
    public void GetChronologicalChatHistory_403() throws InterruptedException, IOException {
        Response response = GET_403(GetChronologicalChatHistory_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
