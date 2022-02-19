package Collection.DasBoardsAPI;

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
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetDashBoardServices extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get DashBoard Services 200")
    @Story("An Endpoint to Get DashBoard Services 200")
    public static void GetDashBoardServices_200() throws InterruptedException, IOException {
        Response response = GET_200(DashbpardServices_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get DashBoard Services 401")
    @Story("An Endpoint to Get DashBoard Services 401")
    public void GetDashBoardServices_401() throws InterruptedException, IOException {
        Response response = GET_401(DashbpardServices_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get DashBoard Services 403")
    @Story("An Endpoint to Get DashBoard Services 403")
    public void GetDashBoardServices_403() throws InterruptedException, IOException {
        Response response = GET_403(DashbpardServices_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
