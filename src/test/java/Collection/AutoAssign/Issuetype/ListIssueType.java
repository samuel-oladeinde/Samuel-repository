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

import static pojo.Constant.Constant.ListIssueTypee;
import static pojo.Constant.Constant.ListTeam_EndPoint;
import static utility.RestCalls.*;
import static utility.RestCalls.RESPONSE_STATUS_CODE_200;

public class ListIssueType extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Issue Type 200")
    @Story("An Endpoint to List Issue Type 200")
    public void ListIssueType_200() throws InterruptedException, IOException {
        Response response = GET_200(ListIssueTypee);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Issue Type 401")
    @Story("An Endpoint to List Issue Type 401")
    public void ListIssueType_401() throws InterruptedException, IOException {
        Response response = GET_401(ListTeam_EndPoint);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Issue Type 403")
    @Story("An Endpoint to List Issue Type 403")
    public void ListIssueType_403() throws InterruptedException, IOException {
        Response response = GET_403(ListTeam_EndPoint);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

}
