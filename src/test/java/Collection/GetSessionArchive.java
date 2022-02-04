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
import static pojo.Constant.Constant.GetSessionArchive_EndPoint;
import static utility.RestCalls.*;

public class GetSessionArchive extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Intent 200")
    @Story("An Endpoint to Get Intent 200")
    public void GetIntent_200() throws InterruptedException, IOException {
        Response response = GET_200(GetSessionArchive_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Intent 401")
    @Story("An Endpoint to get Get Intent 401")
    public void GetIntent_401() throws InterruptedException, IOException {
        Response response = GET_401(GetSessionArchive_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Intent 403")
    @Story("An Endpoint to Get Intent 403")
    public void GetIntent_403() throws InterruptedException, IOException {
        Response response = GET_403(GetSessionArchive_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
