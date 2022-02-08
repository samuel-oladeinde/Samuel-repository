package Collection.AutoAssign.Issuetype;

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

public class GetUnassignedIssueType extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Unassigned Issue Type 200")
    @Story("An Endpoint to Get Unassigned Issue Type 200")
    public void GetUnassignedIssueType_200() throws InterruptedException, IOException {
        Response response = GET_200(getUnIssueTypee);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Unassigned Issue Type 401")
    @Story("An Endpoint to Get Unassigned Issue Type 401")
    public void GetUnassignedIssueType_401() throws InterruptedException, IOException {
        Response response = GET_401(getUnIssueTypee);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to Get Unassigned Issue Type 403")
    @Story("An Endpoint to Get Unassigned Issue Type 403")
    public void GetUnassignedIssueType_403() throws InterruptedException, IOException {
        Response response = GET_403(getUnIssueTypee);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
