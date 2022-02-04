package Collection;

import Base.TestBase;
import Response.GetIntentResponse.Datum;
import Response.GetIntentResponse.GetIntentResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static pojo.Constant.Constant.GetUserInfo_EndPoint;
import static pojo.Constant.Constant.GetUserInformation_Client_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class GetUserInformation_Client extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Information Client 200")
    @Story("An Endpoint to Get User Information Client 200")
    public void GetUserInformation_Client_200() throws InterruptedException, IOException {
        Response response = GET_200(GetUserInformation_Client_EndPoint);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to User Information Client 401")
    @Story("An Endpoint to get User Information Client 401")
    public void GetUserInformation_Client_401() throws InterruptedException, IOException {
        Response response = GET_401(GetUserInformation_Client_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get User Information Client 403")
    @Story("An Endpoint to User Information Client 403")
    public void GetUserInformation_Client_403() throws InterruptedException, IOException {
        Response response = GET_403(GetUserInformation_Client_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
