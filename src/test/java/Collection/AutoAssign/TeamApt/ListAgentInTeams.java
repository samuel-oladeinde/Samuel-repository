package Collection.AutoAssign.TeamApt;

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

public class ListAgentInTeams extends TestBase {

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Agent In Teams 200")
    @Story("An Endpoint to List Agent In Teams 200")
    public void ListAgentInTeams_200() throws InterruptedException, IOException {
        Response response = GET_200(ListAgentTeam);
        response.prettyPeek().then().spec(responseSpec_200);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Agent In Teams 401")
    @Story("An Endpoint to List Agent In Teams 401")
    public void ListAgentInTeams_401() throws InterruptedException, IOException {
        Response response = GET_401(ListAgentTeam);
        Assertions.assertEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_401);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("An Endpoint to List Agent In Teams 403")
    @Story("An Endpoint to List Agent In Teams 403")
    public void ListAgentInTeams_403() throws InterruptedException, IOException {
        Response response = GET_403(ListAgentTeam);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_400);
        Assertions.assertNotEquals(response.getStatusCode(), RESPONSE_STATUS_CODE_200);
    }
}
